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
//public class ObjectiveData {
//    private Context context;
//    private List<List<String>> objQues, objAns;
//
//    /**
//     * 1 -> objQues
//     * 2 -> objOptions
//     * @param context
//     */
//
//    public ObjectiveData(Context context) {
//        this.context = context;
//        objQues = new ArrayList<>();
//        objAns = new ArrayList<>();
//        setData();
//    }
//
//    public List<String> getQuestions(int chapNum) {return objQues.get(chapNum);}
//    public List<String> getOptions(int chapNum) {return objAns.get(chapNum);}
//
//    private void setData() {
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch1_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch2_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch3_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch4_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch5_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch6_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch7_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch8_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch9_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch10_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch11_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch12_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch13_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch14_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch15_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch16_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch17_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch18_ob_ques)));
//        objQues.add(getList(context.getResources().getStringArray(R.array.ch19_ob_ques)));
//
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch1_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch2_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch3_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch4_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch5_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch6_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch7_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch8_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch9_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch10_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch11_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch12_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch13_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch14_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch15_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch16_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch17_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch18_ob_options)));
//        objAns.add(getList(context.getResources().getStringArray(R.array.ch19_ob_options)));
//    }
//
//    private List<String> getList(String[] inp) {
//        List<String> temp = new ArrayList<>();
//        Collections.addAll(temp, inp);
//        return temp;
//    }
//}