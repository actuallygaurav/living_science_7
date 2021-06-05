//package com.gaurav.livingscience.adapters;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.gaurav.livingscience.R;
//import com.gaurav.livingscience.models.Model;
//import com.gaurav.livingscience.models.ObjectiveModel;
//import com.gaurav.livingscience.models.SubjectiveModel;
//
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
//
//    private List<Model> list;
//
//    public MyAdapter(List<Model> list) {
//        this.list = list;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return list.get(position).getType();
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(viewType == 0) {
//            return new ObjViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_objective_q, parent, false));
//        } else {
//            return new SubViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_subjective, parent, false));
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if(list.get(position).getType() == 0) ((ObjViewHolder)holder).setData(position);
//        else ((SubViewHolder)holder).setData(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    class ObjViewHolder extends RecyclerView.ViewHolder {
//
//        TextView objectiveQues, opA, opB, opC, opD;
//        LinearLayout root;
//
//        ObjViewHolder(@NonNull View itemView) {
//            super(itemView);
//            objectiveQues = itemView.findViewById(R.id.obj_ques_textview);
//            opA = itemView.findViewById(R.id.option_a);
//            opB = itemView.findViewById(R.id.option_b);
//            opC = itemView.findViewById(R.id.option_c);
//            opD = itemView.findViewById(R.id.option_d);
//
//            root = itemView.findViewById(R.id.obj_root_container);
//        }
//
//        void setData(int position) {
//            String[] allOpt = ((ObjectiveModel)list.get(position)).allOption.split("~");
//
//            String ques = (position + 1) + ". " +  ((ObjectiveModel)list.get(position)).ques;
//            objectiveQues.setText(ques);
//
//            String a = "(a) " + allOpt[0];
//            opA.setText(a);
//
//            String b = "(b) " + allOpt[1];
//            opB.setText(b);
//
//            String c = "(c) " + allOpt[2];
//            opC.setText(c);
//
//            String d = "(d) " + allOpt[3];
//            opD.setText(d);
//        }
//    }
//
//    class SubViewHolder extends RecyclerView.ViewHolder {
//        TextView quesNum, ques, answer;
//        ImageView subIV;
//        SubViewHolder(@NonNull View itemView) {
//            super(itemView);
//            quesNum = itemView.findViewById(R.id.ques_num_tv);
//            ques = itemView.findViewById(R.id.ques_tv);
//            answer = itemView.findViewById(R.id.answer_tv);
//            subIV = itemView.findViewById(R.id.sub_image_view);
//        }
//
//        void setData(int position) {
//
//            String[] allOptions = ((SubjectiveModel)list.get(position)).ques.split("~");
//
//            quesNum.setText(allOptions[0]);
//            ques.setText(allOptions[1]);
//            answer.setText(allOptions[3]);
//
//
//
//            if(allOptions[1].equals("I")) {
//                subIV.setImageResource(R.drawable.ss);
//            }
//        }
//    }
//}
