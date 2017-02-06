package com.terryyamg.leetcodeexercise.Medium;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.terryyamg.leetcodeexercise.R;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * <p>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Number003LongestSubstringWithoutRepeatingCharacters extends Fragment {

    public Number003LongestSubstringWithoutRepeatingCharacters() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n003_longest_substring_without_repeating_characters, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etTarget = (EditText) view.findViewById(R.id.etTarget);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("003.Given a string, find the length of the longest substring without repeating characters.\n" +
                "\n" +
                "Examples:\n" +
                "\n" +
                "Given \"abcabcbb\", the answer is \"abc\", which the length is 3.\n" +
                "\n" +
                "Given \"bbbbb\", the answer is \"b\", with the length of 1.\n" +
                "\n" +
                "Given \"pwwkew\", the answer is \"wke\", with the length of 3. Note that the answer must be a substring, \"pwke\" is a subsequence and not a substring.");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int longest = lengthOfLongestSubstring(etTarget.getText().toString());
                tvAnswer.setText(Integer.toString(longest));
            }
        });

        return view;
    }

    /**失敗-> Time Limit Exceeded 算太久
     * 建立最大長度初始值為0
     * 建立迴圈
     *              j =0  1  2   3
     *  從i=j=0開始    a  b  c   a
     *                 ╰╯  │  │
     *                 ╰──╯  │
     *                 ╰────╯
     *  從i=j=1開始    a  b  c   a
     *                    ╰╯  │
     *                    ╰──╯
     *                    .
     *                    .
     *                    .
     * 建立一個Map，然後把輸入的字串從第一個字開始放入
     * 檢查Map裡面是否包含該字元 ──有──>  與最大長度比較取最大的
     *                          └─沒有──> 將該字元放入Map，如果為最後一筆 與最大長度比較取最大的
     * 如果最大長度等於0,回傳字串長度
     * */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0)
//            return 0;
//        int longest = 0;
//        for (int j = 0; j < s.length(); j++) {
//            Log.i("start", "從第 " + (j+1)+" 開始");
//            Map<Integer, Character> check = new HashMap<>();
//            for (int i = j; i < s.length(); i++) {
//                if (check.containsValue(s.charAt(i))) { //檢查是否包含已有字串
//                    Log.i("check.size()", "" + check.size());
//                    longest = Math.max(longest, check.size());
//                    Log.i("max-1", longest + "");
//                    break;
//                } else {
//                    Log.i("charAt(i)", String.valueOf(s.charAt(i)) + "");
//                    check.put(i, s.charAt(i));
//                    if(i == s.length()-1) {
//                        longest = Math.max(longest, check.size());
//                        Log.i("max-2", longest + "");
//                    }
//                }
//            }
//        }
//        if (longest == 0)
//            return s.length();
//
//        return longest;
//    }

    /*Best Answer*/
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            Log.i("------","===================");
            if (map.containsKey(s.charAt(i))){
                Log.i("原j","===>"+ j);
                Log.i("包含char位置","===>"+ (map.get(s.charAt(i))+1));
                j = Math.max(j,map.get(s.charAt(i))+1);
                Log.i("新j","===>"+ j);
            }
            Log.i("s.charAt(i)",i+"->"+ s.charAt(i));
            map.put(s.charAt(i),i);
            Log.i("i-j+1", i-j+1 + "");
            max = Math.max(max,i-j+1);
            Log.i("max", max + "");
        }
        return max;
    }
}
