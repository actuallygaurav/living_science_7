package view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gaurav.livingscience.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import adapter.ContactsAdapter;
import util.Constants;


public class ChapterIndexFragment extends Fragment {

    public ChapterIndexFragment() {
        // Required empty public constructor
    }

    //2
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapter, container, false);
    }

    //3
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(Constants.MAIN_ACTIVITY_APP_NAME_HEADER);

        RecyclerView rvContacts = view.findViewById(R.id.rvContacts);
        ArrayList<String> chapterName = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("chapters");

            for (int i = 0; i < m_jArry.length(); i++) {
                chapterName.add(m_jArry.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ContactsAdapter adapter = new ContactsAdapter(chapterName);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("chapter_name.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
