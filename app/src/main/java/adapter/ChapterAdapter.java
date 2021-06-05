package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gaurav.livingscience.R;

import java.util.List;

import model.Item;
import util.ViewType;

/**
 * class
 * onBindViewHolder
 * onCreateViewHolder
 * getItemViewType
 */

public class ChapterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> chapterList;
    private Context context;

    public ChapterAdapter(List<Item> chapterList, Context context) {
        this.chapterList = chapterList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case ViewType.QUESTION:
                View quesView = inflater.inflate(R.layout.single_ques, parent, false);
                return new ViewHolder1Ques(quesView);
            case ViewType.ANSWER:
                View ansView = inflater.inflate(R.layout.single_answer, parent, false);
                return new ViewHolder2Ans(ansView);
            case ViewType.OBJECTIVE:
                View objView = inflater.inflate(R.layout.single_objective, parent, false);
                return new ViewHolder3Objective(objView);
            case ViewType.FILL_THE_BLANK:
                View fillView = inflater.inflate(R.layout.single_fill, parent, false);
                return new ViewHolder4Fill(fillView);
            case ViewType.PIC:
                View imgView = inflater.inflate(R.layout.single_image, parent, false);
                return new ViewHolder5Img(imgView);
            default:
                break;

        }
        return new ViewHolder6Inv(inflater.inflate(R.layout.single_empty, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item curr = chapterList.get(position);

        switch (holder.getItemViewType()) {
            case ViewType.QUESTION:
                ViewHolder1Ques vh1 = (ViewHolder1Ques)holder;
                if(curr.getQuestion().page_number != null) {
                    vh1.pageNumTV.setText(String.format("Page No %s:", curr.getQuestion().page_number));
                } else {
                    ((ViewGroup)vh1.rootView).removeView(vh1.pageNumTV);
                }
                if(curr.getQuestion().question_num != null) {
                    vh1.quesNumTV.setText(String.format("Question %s:", curr.getQuestion().question_num));
                } else {
                    ((ViewGroup)vh1.rootView).removeView(vh1.quesNumTV);
                }
                vh1.quesTV.setText(curr.getQuestion().ques);
                break;
            case ViewType.ANSWER:
                ViewHolder2Ans viewHolder2 = (ViewHolder2Ans)holder;
                viewHolder2.ansTV.setText(curr.getAnswer().ans);
                break;
            case ViewType.OBJECTIVE:
                ViewHolder3Objective vh3 = (ViewHolder3Objective)holder;
                vh3.pageNumTV.setText(String.format("Page No %s:", curr.getObjetive().page_number));
                vh3.quesNumTV.setText(String.format("Question %s:", curr.getObjetive().question_num));
                vh3.quesTV.setText(curr.getObjetive().ques);

                vh3.op1.setText(curr.getObjetive().options.get(0));
                vh3.op2.setText(curr.getObjetive().options.get(1));
                vh3.op3.setText(curr.getObjetive().options.get(2));
                vh3.op4.setText(curr.getObjetive().options.get(3));

                vh3.corrInd.setText(curr.getObjetive().options.get(curr.getObjetive().correct_ind));
                vh3.explanation.setText(curr.getObjetive().explanation);
                break;
            case ViewType.FILL_THE_BLANK:
                ViewHolder4Fill vh4 = (ViewHolder4Fill)holder;
                vh4.pageNumTV.setText(String.format("Page No %s:", curr.getFill().page_number));
                vh4.quesNumTV.setText(String.format("Question %s:", curr.getFill().question_num));
                vh4.quesTV.setText(curr.getFill().ques);
                vh4.ans.setText(curr.getFill().ans);
                break;
            case ViewType.PIC:
                ViewHolder5Img vh5 = (ViewHolder5Img)holder;
                Glide.with(context)
                        .load(curr.getPic().name)
                        .placeholder(R.drawable.ic_cloud_download_black_24dp)
                        .error(R.drawable.ic_error_red)
                        .override(800, 800)
                        .into(vh5.imageView);
                break;
            default:
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        Item item = chapterList.get(position);
        if(item.getQuestion() != null) {
            return ViewType.QUESTION;
        } else if(item.getAnswer() != null) {
            return ViewType.ANSWER;
        } else if(item.getObjetive() != null) {
            return ViewType.OBJECTIVE;
        } else if(item.getFill() != null) {
            return ViewType.FILL_THE_BLANK;
        } else if(item.getPic() != null) {
            return ViewType.PIC;
        }
        return -1;
    }



    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    // 1
    public static class ViewHolder1Ques extends RecyclerView.ViewHolder {
        TextView pageNumTV;
        TextView quesNumTV;
        TextView quesTV;
        View rootView;
        public ViewHolder1Ques(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            pageNumTV = itemView.findViewById(R.id.page_num_tv);
            quesNumTV = itemView.findViewById(R.id.ques_num_tv);
            quesTV = itemView.findViewById(R.id.ques_tv);
        }
    }

    // 2
    public static class ViewHolder2Ans extends RecyclerView.ViewHolder {
        TextView ansTV;
        //TextView heading;
        public ViewHolder2Ans(@NonNull View itemView) {
            super(itemView);
            ansTV = itemView.findViewById(R.id.ans_tv);
            //heading = itemView.findViewById(R.id.table_heading);
        }
    }

    // 3
    public static class ViewHolder3Objective extends RecyclerView.ViewHolder {
        TextView pageNumTV;
        TextView quesNumTV;
        TextView quesTV;

        TextView op1;
        TextView op2;
        TextView op3;
        TextView op4;

        TextView corrInd;
        TextView explanation;
        public ViewHolder3Objective(@NonNull View itemView) {
            super(itemView);
            pageNumTV = itemView.findViewById(R.id.page_num_tv_o);
            quesNumTV = itemView.findViewById(R.id.ques_num_tv_o);
            quesTV = itemView.findViewById(R.id.ques_tv_o);

            op1 = itemView.findViewById(R.id.option1);
            op2 = itemView.findViewById(R.id.option2);
            op3 = itemView.findViewById(R.id.option3);
            op4 = itemView.findViewById(R.id.option4);

            corrInd = itemView.findViewById(R.id.correct_ans_ind);
            explanation = itemView.findViewById(R.id.explanation);
        }
    }

    // 4
    public static class ViewHolder4Fill extends RecyclerView.ViewHolder {
        TextView pageNumTV;
        TextView quesNumTV;
        TextView quesTV;

        TextView ans;
        public ViewHolder4Fill(@NonNull View itemView) {
            super(itemView);
            pageNumTV = itemView.findViewById(R.id.page_num_tv);
            quesNumTV = itemView.findViewById(R.id.ques_num_tv);
            quesTV = itemView.findViewById(R.id.ques_tv);
            ans = itemView.findViewById(R.id.ans_tv);
        }
    }

    // 5
    public static class ViewHolder5Img extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder5Img(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_vw);
        }
    }

    // 6
    public static class ViewHolder6Inv extends RecyclerView.ViewHolder {
        public ViewHolder6Inv(@NonNull View itemView) {
            super(itemView);
        }
    }

}
