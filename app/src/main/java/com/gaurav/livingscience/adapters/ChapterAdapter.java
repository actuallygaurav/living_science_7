//package com.gaurav.livingscience.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.gaurav.livingscience.R;
//
//public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.Chapter> {
//
//    private Context mContext;
//    private String[] chapters;
//    private OnChapterClickListener onChapterClickListener;
//
//
//
//    public ChapterAdapter(Context mContext, String[] chapters) {
//        this.mContext = mContext;
//        this.chapters = chapters;
//        onChapterClickListener = (OnChapterClickListener) mContext;
//    }
//
//    @NonNull
//    @Override
//    public Chapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.single_chapter, parent, false);
//        return new Chapter(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Chapter holder, final int position) {
//        holder.chapterName.setText(chapters[position]);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onChapterClickListener.onChapterClick(position);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return chapters.length;
//    }
//
//    static class Chapter extends RecyclerView.ViewHolder {
//        TextView chapterName;
//        LinearLayout root;
//        View itemView;
//        public Chapter(@NonNull View itemView) {
//            super(itemView);
//            this.itemView = itemView;
//            chapterName = itemView.findViewById(R.id.chapter_name_tv);
//            root = itemView.findViewById(R.id.root_container);
//        }
//    }
//
//    public interface OnChapterClickListener {
//        void onChapterClick(int pos);
//    }
//}
