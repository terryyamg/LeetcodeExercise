package com.terryyamg.leetcodeexercise;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.terryyamg.leetcodeexercise.Easy.Number001TwoSum;
import com.terryyamg.leetcodeexercise.Easy.Number007ReverseInteger;
import com.terryyamg.leetcodeexercise.Easy.Number009PalindromeNumber;
import com.terryyamg.leetcodeexercise.Easy.Number014LongestCommonPrefix;
import com.terryyamg.leetcodeexercise.Easy.Number202HappyNumber;
import com.terryyamg.leetcodeexercise.Medium.Number002AddTwoNumbers;
import com.terryyamg.leetcodeexercise.Medium.Number003LongestSubstringWithoutRepeatingCharacters;
import com.terryyamg.leetcodeexercise.Medium.Number006ZigZagConversion;
import com.terryyamg.leetcodeexercise.Medium.Number011ContainerWithMostWater;

class MainActivityFragment {

    static void n001(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number001TwoSum(), "001");
    }

    static void n002(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number002AddTwoNumbers(), "002");
    }

    static void n003(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number003LongestSubstringWithoutRepeatingCharacters(), "003");
    }

    static void n006(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number006ZigZagConversion(), "006");
    }

    static void n007(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number007ReverseInteger(), "007");
    }

    static void n009(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number009PalindromeNumber(), "009");
    }

    static void n011(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number011ContainerWithMostWater(), "011");
    }

    static void n014(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number014LongestCommonPrefix(), "014");
    }


    static void n202(FragmentManager fragmentManager){
        setFragment(fragmentManager, new Number202HappyNumber(), "202");
    }

    private static void setFragment(FragmentManager fragmentManager, Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
}
