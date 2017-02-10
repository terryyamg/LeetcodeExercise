package com.terryyamg.leetcodeexercise;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.terryyamg.leetcodeexercise.Easy.Number001TwoSum;
import com.terryyamg.leetcodeexercise.Easy.Number007ReverseInteger;
import com.terryyamg.leetcodeexercise.Easy.Number009PalindromeNumber;
import com.terryyamg.leetcodeexercise.Easy.Number202HappyNumber;
import com.terryyamg.leetcodeexercise.Medium.Number002AddTwoNumbers;
import com.terryyamg.leetcodeexercise.Medium.Number003LongestSubstringWithoutRepeatingCharacters;
import com.terryyamg.leetcodeexercise.Medium.Number006ZigZagConversion;

class MainActivityFragment {

    static void n001(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number001TwoSum number001TwoSum = new Number001TwoSum();
        fragmentTransaction.replace(R.id.content_frame, number001TwoSum, "001");
        fragmentTransaction.addToBackStack("001");
        fragmentTransaction.commit();
    }

    static void n002(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number002AddTwoNumbers number002AddTwoNumbers = new Number002AddTwoNumbers();
        fragmentTransaction.replace(R.id.content_frame, number002AddTwoNumbers, "002");
        fragmentTransaction.addToBackStack("002");
        fragmentTransaction.commit();
    }

    static void n003(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number003LongestSubstringWithoutRepeatingCharacters number003LongestSubstringWithoutRepeatingCharacters = new Number003LongestSubstringWithoutRepeatingCharacters();
        fragmentTransaction.replace(R.id.content_frame, number003LongestSubstringWithoutRepeatingCharacters, "003");
        fragmentTransaction.addToBackStack("003");
        fragmentTransaction.commit();
    }

    static void n006(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number006ZigZagConversion number006ZigZagConversion = new Number006ZigZagConversion();
        fragmentTransaction.replace(R.id.content_frame, number006ZigZagConversion, "006");
        fragmentTransaction.addToBackStack("006");
        fragmentTransaction.commit();
    }

    static void n007(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number007ReverseInteger number007ReverseInteger = new Number007ReverseInteger();
        fragmentTransaction.replace(R.id.content_frame, number007ReverseInteger, "007");
        fragmentTransaction.addToBackStack("007");
        fragmentTransaction.commit();
    }

    static void n009(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number009PalindromeNumber number009PalindromeNumber = new Number009PalindromeNumber();
        fragmentTransaction.replace(R.id.content_frame, number009PalindromeNumber, "009");
        fragmentTransaction.addToBackStack("009");
        fragmentTransaction.commit();
    }

    static void n202(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number202HappyNumber number202HappyNumber = new Number202HappyNumber();
        fragmentTransaction.replace(R.id.content_frame, number202HappyNumber, "202");
        fragmentTransaction.addToBackStack("202");
        fragmentTransaction.commit();
    }
}
