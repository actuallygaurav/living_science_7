package com.learn.livingscienceclass6;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


public class MessageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextInputLayout nameEt = view.findViewById(R.id.name_et);
        final TextInputLayout emailEt = view.findViewById(R.id.email_et);
        final TextInputLayout msgEt = view.findViewById(R.id.feedback_et);
        Button btn = view.findViewById(R.id.sendButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getEditText().getText().toString().trim();
                String email = emailEt.getEditText().getText().toString().trim();
                String msg = msgEt.getEditText().getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getContext(), "Name field is empty", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "email field is empty", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(msg)) {
                    Toast.makeText(getContext(), "Feedback field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    saveData(new MessageDTO(name, email, msg, new Date(System.currentTimeMillis()).toString()));
                }
            }
        });
    }

    private void saveData(final MessageDTO messageDTO) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(String.valueOf(System.currentTimeMillis()));

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.setValue(messageDTO);
                Toast.makeText(getContext(), "Message has been sent successfully !!", Toast.LENGTH_LONG).show();

                Fragment fragment = new ChaptersFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.remove(MessageFragment.this);
                transaction.add(R.id.fragment_container, fragment);
                //transaction.replace(R.id.fragment_container, fragment); // give your fragment container id in first parameter
                //transaction.addToBackStack(null);  // if written, this transaction will be added to backstack

                transaction.commit();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Message send failed !", Toast.LENGTH_LONG).show();
            }
        });
    }
}
