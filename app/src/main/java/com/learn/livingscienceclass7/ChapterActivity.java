package com.learn.livingscienceclass7;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.learn.livingscienceclass7.model.RootModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterActivity extends AppCompatActivity {

    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        progressDoalog = new ProgressDialog(ChapterActivity.this);
        progressDoalog.setMessage("Loading....");

        Intent intent = getIntent();
        String message = intent.getStringExtra(ContactsAdapter.EXTRA_MESSAGE);
        int chapterNumber = intent.getIntExtra(ContactsAdapter.CHAPTER_NUMBER, 0);
        setTitle(message.toUpperCase());
        //Toast.makeText(this, String.valueOf(chapterNumber), Toast.LENGTH_SHORT).show();

        final RecyclerView rvContacts = findViewById(R.id.rvChapter);



        progressDoalog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<RootModel> call = service.getWeather(chapterNumber);
        call.enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                progressDoalog.dismiss();
                if(response.body() != null) {
                    ChapterAdapter adapter = new ChapterAdapter(response.body().getItems(), ChapterActivity.this);
                    // Attach the adapter to the recyclerview to populate items
                    rvContacts.setAdapter(adapter);
                    // Set layout manager to position the items
                    rvContacts.setLayoutManager(new LinearLayoutManager(ChapterActivity.this));
                    //MainActivity.this.startActivity(myIntent);
                } else {
                    Toast.makeText(ChapterActivity.this, "Questions and Answers will load very soon", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(ChapterActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}
