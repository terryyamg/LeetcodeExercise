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
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.
 Have you thought about this?

 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 Update (2014-11-10):
 Test cases had been added to test the overflow behavior.

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

    public int reverse(int x) {
        int ans;

        return 0;
    }

}
