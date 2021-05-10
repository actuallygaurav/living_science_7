package view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.livingscienceclass7.R;

import adapter.ChapterAdapter;
import client.GetDataService;
import client.RetrofitClientInstance;
import model.RootModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChapterDetailsFragment extends Fragment {


    private ProgressDialog progressDialog;
    private Context mContext;


    private static final String CHAPTER_NAME = "param1";
    private static final String CHAPTER_INDEX = "param2";


    private String currChapterName;
    private int currChapterIndex;

    public ChapterDetailsFragment() {
    }


    public static ChapterDetailsFragment newInstance(String chapterName, int chapterIndex) {
        ChapterDetailsFragment fragment = new ChapterDetailsFragment();
        Bundle args = new Bundle();
        args.putString(CHAPTER_NAME, chapterName);
        args.putInt(CHAPTER_INDEX, chapterIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currChapterName = getArguments().getString(CHAPTER_NAME);
            currChapterIndex = getArguments().getInt(CHAPTER_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapter_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();


        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading....");

        getActivity().setTitle((currChapterIndex + 1) + ". " + currChapterName);

        final RecyclerView rvContacts = view.findViewById(R.id.rvChapter);


        //Toast.makeText(mContext, currChapterName +", " + currChapterIndex, Toast.LENGTH_LONG).show();



        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<RootModel> call = service.getWeather(currChapterIndex);
        call.enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                progressDialog.dismiss();
                if(response.body() != null) {
                    ChapterAdapter adapter = new ChapterAdapter(response.body().getItems(), mContext);
                    rvContacts.setAdapter(adapter);
                    rvContacts.setLayoutManager(new LinearLayoutManager(mContext));
                } else {
                    Toast.makeText(mContext, "This Chapter will load soon", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(mContext, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
