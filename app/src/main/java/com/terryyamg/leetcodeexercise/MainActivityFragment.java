package com.terryyamg.leetcodeexercise;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.terryyamg.leetcodeexercise.Easy.Number001TwoSum;
import com.terryyamg.leetcodeexercise.Medium.Number006ZigZagConversion;
import com.terryyamg.leetcodeexercise.Easy.Number202HappyNumber;
import com.terryyamg.leetcodeexercise.Medium.Number002AddTwoNumbers;
import com.terryyamg.leetcodeexercise.Medium.Number003LongestSubstringWithoutRepeatingCharacters;

class MainActivityFragment {

    static void n001Easy(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number001TwoSum number001TwoSum = new Number001TwoSum();
        fragmentTransaction.replace(R.id.content_frame, number001TwoSum, "easy001");
        fragmentTransaction.addToBackStack("easy001");
        fragmentTransaction.commit();
    }

    static void n002Medium(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number002AddTwoNumbers number002AddTwoNumbers = new Number002AddTwoNumbers();
        fragmentTransaction.replace(R.id.content_frame, number002AddTwoNumbers, "medium002");
        fragmentTransaction.addToBackStack("medium002");
        fragmentTransaction.commit();
    }

    static void n003Medium(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number003LongestSubstringWithoutRepeatingCharacters number003LongestSubstringWithoutRepeatingCharacters = new Number003LongestSubstringWithoutRepeatingCharacters();
        fragmentTransaction.replace(R.id.content_frame, number003LongestSubstringWithoutRepeatingCharacters, "medium003");
        fragmentTransaction.addToBackStack("medium003");
        fragmentTransaction.commit();
    }

    static void n202Easy(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number202HappyNumber number202HappyNumber = new Number202HappyNumber();
        fragmentTransaction.replace(R.id.content_frame, number202HappyNumber, "easy202");
        fragmentTransaction.addToBackStack("easy202");
        fragmentTransaction.commit();
    }

    static void n006Medium(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        Number006ZigZagConversion number006ZigZagConversion = new Number006ZigZagConversion();
        fragmentTransaction.replace(R.id.content_frame, number006ZigZagConversion, "medium006");
        fragmentTransaction.addToBackStack("medium006");
        fragmentTransaction.commit();
    }

}
