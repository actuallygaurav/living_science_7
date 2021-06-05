//package com.gaurav.livingscience;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import com.gaurav.livingscience.adapter.MyAdapter;
//import com.gaurav.livingscience.data.ObjectiveData;
//import com.gaurav.livingscience.data.SubjectiveData;
//import com.gaurav.livingscience.model.Model;
//import com.gaurav.livingscience.model.ObjectiveModel;
//import com.gaurav.livingscience.model.SubjectiveModel;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AnswerActivity extends AppCompatActivity {
//
//    private int position;
//    private List<Model> list;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_answer);
//
//        position = getIntent().getIntExtra("chapter_number", 0);
//
//
//        setdata();
//        setRv();
//
//        loadBannerAd();
//    }
//
//    void setRv() {
//        RecyclerView rv = findViewById(R.id.ans_rv);
//        rv.setLayoutManager(new LinearLayoutManager(AnswerActivity.this));
//        rv.setHasFixedSize(true);
//        rv.setAdapter(new MyAdapter(list));
//    }
//
//    void setdata() {
//        list = new ArrayList<>();
//
//        ObjectiveData data = new ObjectiveData(AnswerActivity.this);
//
//        List<String> ques = data.getQuestions(position);
//        List<String> options = data.getOptions(position);
//
//        for(int i=0; i<ques.size(); ++i) {
//            ObjectiveModel objectiveModel = new ObjectiveModel(ques.get(i), options.get(i));
//            list.add(objectiveModel);
//        }
//
//        SubjectiveData data2 = new SubjectiveData(AnswerActivity.this);
//        List<String> quesAndAnsList = data2.getQuesAndAnsList(position);
//
//        for(int i=0; i<quesAndAnsList.size(); ++i) {
//            SubjectiveModel subjectiveModel = new SubjectiveModel(quesAndAnsList.get(i));
//            list.add(subjectiveModel);
//        }
//    }
//
//    private void loadBannerAd() {
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }
//}
