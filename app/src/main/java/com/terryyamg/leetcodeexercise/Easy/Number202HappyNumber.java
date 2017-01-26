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


public class Number202HappyNumber extends Fragment {

    private EditText etNumber;
    private TextView tvInfo;

    public Number202HappyNumber() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n202_happy_number, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        tvDescription.setText("202.HappyNumber \n" +
                "Write an algorithm to determine if a number is 'happy'.\n" +
                " A happy number is a number defined by the following process:\n" +
                " Starting with any positive integer,\n" +
                " replace the number by the sum of the squares of its digits,\n" +
                " and repeat the process until the number equals 1 (where it will stay),\n" +
                " or it loops endlessly in a cycle which does not include 1.\n" +
                " Those numbers for which this process ends in 1 are happy numbers.\n" +
                "\n" +
                " Example: 19 is a happy number\n" +
                "\n" +
                " 12 + 92 = 82\n" +
                " 82 + 22 = 68\n" +
                " 62 + 82 = 100\n" +
                " 12 + 02 + 02 = 1");

        etNumber = (EditText) view.findViewById(R.id.etNumber);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        tvInfo = (TextView) view.findViewById(R.id.tvInfo);

        btnSend.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int number = Integer.parseInt(etNumber.getText().toString()); // 輸入數字
                if (isHappy(number)) {
                    tvInfo.setText(number + "是 Happy Number");
                } else {
                    tvInfo.setText(number + "不是 Happy Number");
                }

            }
        });

        return view;
    }

    /* 回傳驗證是否為happy number */
    public boolean isHappy(int n) {
        Log.i("keyNumber:", n + "");
        int sum, length;
        do {
            sum = getNumber(n, Integer.toString(n).length());
            length = Integer.toString(sum).length(); // 總和數字長度
            n = sum;
        } while (length != 1);// 重複執行到剩個位數

        Log.i("sum:", sum + "");
        return sum == 1;// true:個位數等於1 happy number!! false:不是happy number...

    }

    /* 取得每個數字 放入數字陣列 計算總合 */
    public int getNumber(int n, int length) {
		/* 建立每個數字陣列 */
        int[] numberArray = new int[length];
        int quotient = 0;// 商數
        int sum = 0; // 總合
        for (int i = 0; i < length; i++) {
            if (i == 0) { // 一開始輸入的數字計算
                numberArray[i] = n % 10; // 獲得餘數
                quotient = n / 10; // 獲得商數
            } else { // 計算後的總合再計算
                numberArray[i] = quotient % 10; // 獲得餘數
                quotient = quotient / 10; // 獲得商數
            }
            sum += (int) Math.pow(numberArray[i], 2); // 計算總和

        }
        return sum; // 回傳總和
    }
}
