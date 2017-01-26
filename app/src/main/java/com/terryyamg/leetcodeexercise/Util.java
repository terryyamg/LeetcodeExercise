package com.terryyamg.leetcodeexercise;


import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class Util {

    private Context mContext;

    Util(Context context){
        this.mContext = context;
    }

   void setRecyclerView(RecyclerView rv, String[] levelNumber, String[] levelTitle){
        LinearLayoutManager lm = new LinearLayoutManager(mContext);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        QuestionAdapter questionAdapter = new QuestionAdapter(levelNumber,levelTitle);
        rv.setAdapter(questionAdapter);
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

        private String[] mNumber,mTitle;

        class QuestionViewHolder extends RecyclerView.ViewHolder {
            private TextView tvNumber,tvTitle;

            private QuestionViewHolder(View view) {
                super(view);
                tvNumber = (TextView) view.findViewById(R.id.tvNumber);
                tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            }
        }

        QuestionAdapter(String[] number,String[] title) {
            this.mNumber = number;
            this.mTitle = title;
        }

        @Override
        public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //設定item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_questions, parent, false);

            return new QuestionViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(QuestionViewHolder holder, int position) {
            //放入資料
            holder.tvNumber.setText(mNumber[position]);
            holder.tvTitle.setText(mTitle[position]);
        }

        @Override
        public int getItemCount() {
            //取得長度
            return mNumber.length;
        }
    }

}
