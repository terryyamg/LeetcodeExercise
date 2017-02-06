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
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * Subscribe to see which companies asked this question
 **/

public class Number001TwoSum extends Fragment {

    public Number001TwoSum() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n001_two_sum, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        final EditText etNumber1 = (EditText) view.findViewById(R.id.etNumber1);
        final EditText etNumber2 = (EditText) view.findViewById(R.id.etNumber2);
        final EditText etNumber3 = (EditText) view.findViewById(R.id.etNumber3);
        final EditText etNumber4 = (EditText) view.findViewById(R.id.etNumber4);
        final EditText etTarget = (EditText) view.findViewById(R.id.etTarget);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        tvDescription.setText("001.Two Sum \n" +
                "Given an array of integers, return indices of the two numbers such that they add up to a specific target.\n" +
                "You may assume that each input would have exactly one solution.\n" +
                " \n" +
                "Example:\n" +
                "Given nums = [2, 7, 11, 15], target = 9,\n" +
                "Because nums[0] + nums[1] = 2 + 7 = 9,\n" +
                "return [0, 1].\n" +
                "\n" +
                "UPDATE (2016/2/13):\n" +
                "The return format had been changed to zero-based indices. Please read the above updated description carefully.\n" +
                "Subscribe to see which companies asked this question");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(etNumber1.getText().toString());
                int n2 = Integer.parseInt(etNumber2.getText().toString());
                int n3 = Integer.parseInt(etNumber3.getText().toString());
                int n4 = Integer.parseInt(etNumber4.getText().toString());
                int tag = Integer.parseInt(etTarget.getText().toString());

                int[] send = {n1,n2,n3,n4};
                int[] sum = twoSum(send,tag);
                if(sum != null) {
                    tvAnswer.setText("位置:"+(sum[0]+1)+"+"+(sum[1]+1));
                }else{
                    tvAnswer.setText("無解答");
                }
            }
        });


        return view;
    }
    /**
     * 想法:
     * 建立答案陣列 ans
     * [n1,n2,n3,n4]
     * 兩個迴圈計算(n1+n2),(n1+n3), ... ,(n2+n4),(n3+n4)
     * 如果兩個相加等於目標數字
     * 紀錄兩個數字位置並回傳
     * */

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i != j ){
                    if(nums[i]+nums[j] == target){
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
        }

        return null;
    }

     /*BEST Answer*/
//     public int[] twoSum(int[] numbers, int target) {
//        int[] result = new int[2];
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < numbers.length; i++) {
//            Log.i("i",i+"");
//            if (map.containsKey(target - numbers[i])) {
//                result[1] = i;
//                result[0] = map.get(target - numbers[i])-1;
//                return result;
//            }
//            Log.i("numbers[i]",numbers[i]+"");
//            Log.i("i + 1",i + 1+"");
//            map.put(numbers[i], i + 1);
//        }
//        return null;
//     }


}
