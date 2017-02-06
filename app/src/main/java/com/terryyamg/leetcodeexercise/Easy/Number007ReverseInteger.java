package com.terryyamg.leetcodeexercise.Easy;


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

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * Have you thought about this?
 * <p>
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 */

public class Number007ReverseInteger extends Fragment {

    public Number007ReverseInteger() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n007_reverse_integer, container, false);

        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etNumber = (EditText) view.findViewById(R.id.etNumber);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("Reverse digits of an integer.\n" +
                "\n" +
                "Example1: x = 123, return 321\n" +
                "Example2: x = -123, return -321\n" +
                "\n" +
                "click to show spoilers.\n" +
                "Have you thought about this?\n" +
                "\n" +
                "Here are some good questions to ask before coding. \n" +
                "Bonus points for you if you have already thought through this!\n" +
                "\n" +
                "If the integer's last digit is 0, what should the output be?. \n" +
                "ie, cases such as 10, 100.\n" +
                "\n" +
                "Did you notice that the reversed integer might overflow? \n" +
                "Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. \n" +
                "How should you handle such cases?\n" +
                "\n" +
                "For the purpose of this problem, \n" +
                "assume that your function returns 0 when the reversed integer overflows.\n" +
                "\n" +
                "Update (2014-11-10):\n" +
                "Test cases had been added to test the overflow behavior.\n");


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNumber.getText().toString().equals(""))
                    return;
                int n = Integer.parseInt(etNumber.getText().toString());
                tvAnswer.setText(Integer.toString(reverse(n)));
            }
        });


        return view;
    }

    /**
     * 先判斷正負並取得長度
     * (ex:123)
     * 計算除10餘數同時除以10取得商數
     * (餘數3,商數12)
     * 將餘數乘上10^(長度-1)
     * 10^(3-1)
     * 加回答案
     * 0+3*100
     * 迴圈繼續計算
     * 最後判斷範圍，所以ans用double
     */

    public int reverse(int x) {
        double ans = 0;
        int length;
        if (x >= 0) {
            length = Integer.toString(x).length();
        } else {
            length = Integer.toString(-x).length();
        }

        for (int i = length; i > 0; i--) {
            Log.i("i", i + "");
            int s = x % 10;
            x /= 10;
            ans = ans + s * Math.pow(10, i - 1);
            Log.i("ans", ans + "");

        }

        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int) ans;
        } else {
            return 0;
        }
    }

    /* Best Answer*/
//    public int reverse(int x) {
//        int result = 0;
//
//        while (x != 0) {
//            Log.i("xxxxxxxx",x+"");
//            int tail = x % 10;
//            int newResult = result * 10 + tail;
//            Log.i("newResult",newResult+"");
//            Log.i("tail",tail+"");
//            Log.i("(newResult - tail) / 10",((newResult - tail) / 10)+"");
//            Log.i("result",result+"");
//            if ((newResult - tail) / 10 != result) {
//                return 0;
//            }
//            result = newResult;
//            x = x / 10;
//        }
//
//        return result;
//    }

}
