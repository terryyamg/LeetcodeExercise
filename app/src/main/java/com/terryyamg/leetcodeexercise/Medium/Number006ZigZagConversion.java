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
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 **/

public class Number006ZigZagConversion extends Fragment {

    public Number006ZigZagConversion() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n006_zigzag_conversion, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etTarget = (EditText) view.findViewById(R.id.etTarget);
        final EditText etRow = (EditText) view.findViewById(R.id.etRow);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("006. The string \"PAYPALISHIRING\" is written in a zigzag pattern on a given number of rows like this: \n" +
                "(you may want to display this pattern in a fixed font for better legibility)\n" +
                "\n" +
                "P   A   H   N\n" +
                "A P L S I I G\n" +
                "Y   I   R\n" +
                "\n" +
                "And then read line by line: \"PAHNAPLSIIGYIR\"\n" +
                "\n" +
                "Write the code that will take a string and make this conversion given a number of rows:\n" +
                "\n" +
                "string convert(string text, int nRows);\n" +
                "\n" +
                "convert(\"PAYPALISHIRING\", 3) should return \"PAHNAPLSIIGYIR\". ");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etTarget.getText().toString().equals("") || etRow.getText().toString().equals(""))
                    return;
                tvAnswer.setText(convert(etTarget.getText().toString(), Integer.parseInt(etRow.getText().toString())));
            }
        });

        return view;
    }
    /**
     1 0
     2 2
     3 4
     4 6
     5 8
     -------1----------
     PAYPALISHIRING

     -------2----------2*1
     PYAIHRNAPLSIIG        P A Y P A L I S H I R I N G
                           0 1 2 3 4 5 6 7 8 9
     PYAIHRN
     APLSIIG

     -------3----------2*2
     PAHNAPLSIIGYIR        P AYP A LIS H IRI N G
                           0 123 4 567 8 901 2 3
     P   A   H   N
     A P L S I I G
     Y   I   R

     -------4----------2*3
     PINALSIGYAHRPI       P AYPAL I SHIRI N G
                          0 12345 6 78901 2 3
     P     I     N
     A   L S   I G
     Y A   H R
     P     I

     -------5----------2*4
     PHASIYIRPLIGAN       P AYPALIS H IRING
                          0 1234567 8 9012345 6
     P     H
     A   S I
     Y  I  R
     P L   I G
     A     N

     找到第一排的字元 2 * (輸入列 - 1)，字元存起來並紀錄位置
     開始向內取得字元 如果最後沒有字元就假設有
     P AYPALIS H IRING** *
     →      ← →     ←
    如果到同一個位置，紀錄一個並中斷while迴圈

     */
    /*success*/
    public String convert(String s, int numRows) {
        if(numRows == 0)
            return "";
        if(numRows == 1)
            return s;
        StringBuilder ans = new StringBuilder();
        HashMap<Integer,Integer> location = new HashMap<>();
//        SparseIntArray location = new SparseIntArray();

        for (int i = 0, j = 0; i < s.length()+ 2 * (numRows - 1); i = i + 2 * (numRows - 1), j++) {
            Log.i("iiiii",i+"");
            if(i < s.length())
                ans.append(s.charAt(i));
//            location.append(j, i);
            location.put(j,i);
        }
        int j=1;
        int pre=0;
        while (true) {
            for (int i = 0; i < location.size(); i++) {
                if (location.get(i) - j > 0 && location.get(i) - j < s.length()) {
                    if(location.get(i) - j == pre) {
                        Log.i("continue","continue");
                        continue;
                    }
                    ans.append(s.charAt(location.get(i) - j));
                    Log.i("char-j",s.charAt(location.get(i) - j)+"");
                }
                if (location.get(i) + j > 0 && location.get(i) + j < s.length()) {
                    Log.i("location.pre",pre+"");
                    Log.i("location.get(i) + j",(location.get(i) + j)+"");
                    pre = location.get(i) + j;

                    ans.append(s.charAt(location.get(i) + j));
                    Log.i("char+j",s.charAt(location.get(i) + j)+"");
                }


            }
            if(location.get(0) + j == numRows-1){
                break;
            }
            j++;
        }

        return ans.toString();
    }

    /* Best Answer*/
//    public String convert(String s, int nRows) {
//        char[] c = s.toCharArray();
//        int len = c.length;
//        StringBuffer[] sb = new StringBuffer[nRows];
//        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
//
//        int i = 0;
//        while (i < len) {
//            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
//                sb[idx].append(c[i++]);
//            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
//                sb[idx].append(c[i++]);
//        }
//        for (int idx = 1; idx < sb.length; idx++)
//            sb[0].append(sb[idx]);
//        return sb[0].toString();
//    }

}
