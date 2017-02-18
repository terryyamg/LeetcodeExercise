package com.terryyamg.leetcodeexercise.Medium;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.terryyamg.leetcodeexercise.R;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * <p>
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * <p>
 * Find two lines, which together with x-axis forms a container,
 * <p>
 * such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 **/

public class Number011ContainerWithMostWater extends Fragment {

    int[] heights;

    public Number011ContainerWithMostWater() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n011_container_with_most_water, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etLines = (EditText) view.findViewById(R.id.etLines);
        final TextView tvRandom = (TextView) view.findViewById(R.id.tvRandom);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        etLines.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etLines.getText().toString().length()<=0 || etLines.getText().toString().length()>4)
                    return;
                int length = Integer.parseInt(etLines.getText().toString());
                heights = new int[length];
                StringBuilder sb = new StringBuilder();
                for (int n = 0; n < length; n++) {

                    if (n == 0)
                        sb.append("[");
                    int random = (int) (Math.random() * 100 + 1);
                    sb.append(random);
                    heights[n] = random;
                    if (n == length - 1)
                        sb.append("]");
                    else
                        sb.append(",");
                }
                tvRandom.setText(sb);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tvDescription.setText("011. Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).\n" +
                " \n" +
                " n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).\n" +
                " \n" +
                " Find two lines, which together with x-axis forms a container,\n" +
                " \n" +
                " such that the container contains the most water.\n" +
                "\n" +
                " Note: You may not slant the container and n is at least 2. ");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heights.length<=0)
                    return;
               tvAnswer.setText(Integer.toString(maxArea(heights)));
            }
        });

        return view;
    }

    /**
     * Time Limit Exceeded 果然還是不能用雙迴圈啊啊啊，輸入很大數字999就可以發現差異
     * <p>
     * 依序取出兩根比較高度，取比較小的乘上兩根距離 = 面積
     * 紀錄面積，往下繼續取出兩根重複計算
     * 當下面積大於前面計算面積時才紀錄
     * <p>
     * y
     * ↑
     * │          a2
     * │          │    a3
     * │    a1    │    │
     * │    │    │    │
     * │    │    │    │
     * │    │    │    │
     * ┼──┴──┴──┴──→x
     * 1     2     3
     */
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i; j < height.length; j++) {
//
//                if (i != j) {
//                    int mHeight = Math.min(height[i], height[j]);
//                    maxArea = Math.max(maxArea, mHeight * (j - i));
//                    Log.i("maxArea", maxArea + "");
//                }
//            }
//        }
//
//        Log.i("maxArea-final", maxArea + "");
//
//        return maxArea;
//    }

    /*Best Answer*/
    //不要留低的，假設A高B低情況下，底縮小了，A面積會比較大，所以不要留低的
    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len -1 ;
        int maxArea = 0;
        while (low < high) {
            Log.i("left",low+"");
            Log.i("right",high+"");
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            Log.i("maxArea",maxArea+"");
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

}
