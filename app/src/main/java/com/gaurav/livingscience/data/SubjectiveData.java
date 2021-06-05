//package com.gaurav.livingscience.data;
//
//import android.content.Context;
//
//import com.gaurav.livingscience.R;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class SubjectiveData {
//    private Context context;
//    private List<List<String>> quesAndAnsList;
//
//    /**
//     * 1 -> objQues
//     * 2 -> objOptions
//     * @param context
//     */
//
//    public SubjectiveData(Context context) {
//        this.context = context;
//        quesAndAnsList = new ArrayList<>();
//        setData();
//    }
//
//    public List<String> getQuesAndAnsList(int chapNum) {return quesAndAnsList.get(chapNum);}
//
//    private void setData() {
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch1_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch2_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch3_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch4_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch5_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch6_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch7_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch8_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch9_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch10_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch11_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch12_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch13_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch14_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch15_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch16_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch17_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch18_sub_1)));
//        quesAndAnsList.add(getList(context.getResources().getStringArray(R.array.ch19_sub_1)));
//    }
//
//    private List<String> getList(String[] inp) {
//        List<String> temp = new ArrayList<>();
//        Collections.addAll(temp, inp);
//        return temp;
//    }
//}
