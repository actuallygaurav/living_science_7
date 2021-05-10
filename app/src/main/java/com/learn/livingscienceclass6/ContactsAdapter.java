package com.learn.livingscienceclass6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    // ... constructor and member variables
    private List<String> mContacts;
    private Context context;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String CHAPTER_NUMBER = "CHAPTER_NUMBER";

    // Pass in the contact array into the constructor
    public ContactsAdapter(List<String> contacts, Context context) {
        mContacts = contacts;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ChapterActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mContacts.get(getLayoutPosition()));
            intent.putExtra(CHAPTER_NUMBER, getLayoutPosition());
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.single_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String contact = mContacts.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(contact);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
