package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.livingscienceclass7.R;

import java.util.List;

import view.ChapterDetailsFragment;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<String> mContacts;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String CHAPTER_NUMBER = "CHAPTER_NUMBER";


    public ContactsAdapter(List<String> contacts) {
        mContacts = contacts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();

                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,
                                    ChapterDetailsFragment.newInstance(
                                            mContacts.get(getLayoutPosition()),
                                            getLayoutPosition())
                            )
                            .addToBackStack(null)
                            .commit();

                }
            });
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
        String contact = "Chapter " + (position + 1) + " - " + mContacts.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(contact);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
