package view;

import android.app.ProgressDialog;
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

import com.google.android.material.textfield.TextInputLayout;
import com.gaurav.livingscience.R;

import java.util.Date;

import model.MessageDTO;


public class MessageFragment extends Fragment {

    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Sending...");

        getActivity().setTitle("Help us to improve");

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
                    progressDialog.show();
                    saveData(new MessageDTO(name, email, msg, new Date(System.currentTimeMillis()).toString(), "Living Science class 6"));
                }
            }
        });
    }

    private void saveData(final MessageDTO messageDTO) {
        Toast.makeText(getContext(), "Message has been sent successfully !!", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new ChapterIndexFragment())
                        .commit();
                progressDialog.dismiss();

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference myRef = database.getReference(String.valueOf(System.currentTimeMillis()));

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                //myRef.setValue(messageDTO);
//                Toast.makeText(getContext(), "Message has been sent successfully !!", Toast.LENGTH_LONG).show();
//
//                getActivity().getSupportFragmentManager().popBackStack();
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fragment_container, new ChapterIndexFragment())
//                        .commit();
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getContext(), "Message send failed !", Toast.LENGTH_LONG).show();
//                progressDialog.dismiss();
//            }
//        });
    }

}
