package com.terryyamg.leetcodeexercise.Easy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.terryyamg.leetcodeexercise.R;

/**
 * Created by terry.yang on 2017/5/24.
 */

public class Number014LongestCommonPrefix extends Fragment {

    public Number014LongestCommonPrefix() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n014_longest_common_prefix, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etString1 = (EditText) view.findViewById(R.id.etString1);
        final EditText etString2 = (EditText) view.findViewById(R.id.etString2);
        final EditText etString3 = (EditText) view.findViewById(R.id.etString3);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("014.Longest Common Prefix\n" +
                "Write a function to find the longest common prefix string amongst an array of strings.");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etString1.getText().toString().length() <= 0 || etString2.getText().toString().length() <= 0 || etString3.getText().toString().length() <= 0)
                    return;
                String[] strs = new String[]{etString1.getText().toString(), etString2.getText().toString(), etString3.getText().toString()};
                tvAnswer.setText("[" + strs[0] + "," + strs[1] + "," + strs[2] + "] 's Common Prefix:" + longestCommonPrefix(strs));

            }
        });


        return view;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String ans = "";
        int minLength = strs[0].length();
        for (String item : strs) {
            if (item.length() < minLength)
                minLength = item.length();
        }

        outerLoop:
        for (int i = 0; i < minLength; i++) {
            String save = "";
            for (int index = 0; index < strs.length; index++) {
                Character cc = strs[index].charAt(i);
                if (index == 0)
                    save = cc.toString();
                if (!save.equals(cc.toString()))
                    break outerLoop;
                if (save.equals(cc.toString()) && index == strs.length - 1)
                    ans += cc.toString();
            }
        }

        return ans;
    }

    /*Best Answer*/
//    public String longestCommonPrefix(String[] strs) {
//        if(strs==null || strs.length==0) return "";
//        if(strs.length==1) return strs[0];
//        String pre = strs[0];
//        for(int i=1;i<strs.length;i++){
//            while(!strs[i].startsWith(pre)){
//                pre=pre.substring(0,pre.length()-1);
//            }
//        }
//        return pre;
//    }

}
