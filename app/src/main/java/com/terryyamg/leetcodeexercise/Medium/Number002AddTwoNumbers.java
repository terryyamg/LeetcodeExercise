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

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Subscribe to see which companies asked this question
 **/

public class Number002AddTwoNumbers extends Fragment {

    public Number002AddTwoNumbers() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.n002_add_two_numbers, container, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);

        tvDescription.setText("002.You are given two non-empty linked lists representing two non-negative integers. \n" +
                "The digits are stored in reverse order and each of their nodes contain a single digit. \n" +
                "Add the two numbers and return it as a linked list.\n" +
                "You may assume the two numbers do not contain any leading zero, except the number 0 itself.\n" +
                " \n" +
                "Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)\n" +
                "Output: 7 -> 0 -> 8\n" +
                "\n" +
                "Subscribe to see which companies asked this question");

        final EditText etNumber11 = (EditText) view.findViewById(R.id.etNumber11);
        final EditText etNumber12 = (EditText) view.findViewById(R.id.etNumber12);
        final EditText etNumber13 = (EditText) view.findViewById(R.id.etNumber13);
        final EditText etNumber21 = (EditText) view.findViewById(R.id.etNumber21);
        final EditText etNumber22 = (EditText) view.findViewById(R.id.etNumber22);
        final EditText etNumber23 = (EditText) view.findViewById(R.id.etNumber23);

        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        final TextView tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNumber11.getText().toString().equals("") || etNumber12.getText().toString().equals("") ||etNumber13.getText().toString().equals("") ||etNumber21.getText().toString().equals("") ||etNumber22.getText().toString().equals("") ||etNumber23.getText().toString().equals("")){
                    return;
                }
                int n11 = Integer.parseInt(etNumber11.getText().toString());
                int n12 = Integer.parseInt(etNumber12.getText().toString());
                int n13 = Integer.parseInt(etNumber13.getText().toString());
                int n21 = Integer.parseInt(etNumber21.getText().toString());
                int n22 = Integer.parseInt(etNumber22.getText().toString());
                int n23 = Integer.parseInt(etNumber23.getText().toString());

                ListNode ln1 = new ListNode(n11);
                ln1.next = new ListNode(n12);
                ln1.next.next = new ListNode(n13);

                ListNode ln2 = new ListNode(n21);
                ln2.next = new ListNode(n22);
                ln2.next.next = new ListNode(n23);

                ListNode ans = addTwoNumbers(ln1, ln2);
                tvAnswer.setText(ans.val + " -> " + ans.next.val + " -> " + ans.next.next.val);
            }
        });

        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);

        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);

        ListNode ans = addTwoNumbers(ln1, ln2);
        Log.i("ans", ans.val + " -> " + ans.next.val + " -> " + ans.next.next.val);
        return view;
    }

    /**
     * 243+564=807
     * i=0
     * sum = (i+2+5) = 7
     * sum/10 = a...7   a=0
     * <p>
     * sum = (a+4+6) = 10
     * sum/10 = b...0   b=1
     * <p>
     * sum = (b+3+4) = 8
     * sum/10 = c...8
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

   /* 失敗->題目看不懂*/
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int sum;
//        int quotient = 0;
//        ListNode ans = new ListNode(0);
//        while (l1 != null || l2 != null){
//            sum = quotient+ (l1 != null ? l1.val : 0) +l2.val;
//            quotient = sum / 10;    //商數
//            int remainder = sum % 10;   //餘數
//            ans.next = new ListNode(remainder);
//            if(l1.next != null)
//                l1 = l1.next;
//            if(l2.next != null)
//                l2 = l2.next;
//
//        }
//
//        return ans;
//    }

    /*Best answer*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            Log.i("curr", curr.next.val + "");
            Log.i("dummyHead-1", dummyHead.next.val + "");
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        Log.i("dummyHead-2", dummyHead.next.val + "");
        return dummyHead.next;
    }


}
