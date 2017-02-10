package com.terryyamg.leetcodeexercise.Easy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.terryyamg.leetcodeexercise.R;


public class Number009PalindromeNumber extends Fragment {

    public Number009PalindromeNumber() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n009_palindrome_number, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etNumber = (EditText) view.findViewById(R.id.etNumber);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("009.PalindromeNumber\n" +
                "Determine whether an integer is a palindrome.\n" +
                "Do this without extra space.");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNumber.getText().toString().length() <= 0)
                    return;

                tvAnswer.setText(etNumber.getText().toString() + " is palindrome number:" + isPalindrome(Integer.parseInt(etNumber.getText().toString())));

            }
        });


        return view;
    }

    /**
     * 先將輸入數字除10取餘數放入set
     * 使用迴圈比對第一個a與最後一個b
     * 然後往內 第一個a+1 最後一個b-1 比對
     * 如果出現不相等數字回傳false
     * 如果兩個數字位置相等 或 前面位置大於後面位置 皆 中斷迴圈
     * 最後都沒出現不相等則回傳true
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        SparseIntArray set = new SparseIntArray();
//        HashMap<Integer,Integer> set = new HashMap<>();
        int location = 0;
        while (x != 0) {
            int a = x % 10;
            set.append(location,a);
//            set.put(location,a);
            x /= 10;
            location++;
        }
        int i = 0;
        int j = set.size() - 1;
        while (i != j) {
            if (i > j)
                break;
            if (set.get(i) != set.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /*Best Answer*/
//    public boolean isPalindrome(int x) {
//        //(x!=0 && x%10==0) 10,20,30, ...狀況
//        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
//        int rev = 0;
//        //反轉會相等特性
//        while (x > rev) {
//            Log.i("first x===>", x + "");
//            Log.i("rev*10 + x%10 =====", rev + "*10 + " + x + "%10");
//            rev = rev * 10 + x % 10;
//            Log.i("rev", rev + "");
//            x = x / 10;
//            Log.i("last x===>", x + "");
//        }
//        //x==rev    偶數狀況
//        //x==rev/10 奇數狀況
//        return (x == rev || x == rev / 10);
//    }
}
