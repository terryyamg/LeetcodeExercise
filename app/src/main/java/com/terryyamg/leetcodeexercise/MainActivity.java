package com.terryyamg.leetcodeexercise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TabHost mTabHost;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        Util util = new Util(this);

        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        RecyclerView rvEasy = (RecyclerView) findViewById(R.id.rv_easy);
        RecyclerView rvMedium = (RecyclerView) findViewById(R.id.rv_medium);
        RecyclerView rvHard = (RecyclerView) findViewById(R.id.rv_hard);

        mTabHost.setup();
        LinearLayout tv1 = (LinearLayout) findViewById(R.id.tab_easy); //頁籤1內容
        LinearLayout tv2 = (LinearLayout) findViewById(R.id.tab_medium); //頁籤2內容
        LinearLayout tv3 = (LinearLayout) findViewById(R.id.tab_hard); //頁籤3內容

        setupTab(tv1, "Easy"); //頁籤 (內容，標籤，圖id)
        setupTab(tv2, "Medium");
        setupTab(tv3, "Hard");

        mTabHost.setCurrentTab(2); //點選頁籤3
        mTabHost.setCurrentTab(1); //點選頁籤2
        mTabHost.setCurrentTab(0); //點選頁籤1

        util.setRecyclerView(rvEasy,getResources().getStringArray(R.array.number_easy),getResources().getStringArray(R.array.title_easy));
        util.setRecyclerView(rvMedium,getResources().getStringArray(R.array.number_medium),getResources().getStringArray(R.array.title_medium));
        util.setRecyclerView(rvHard,getResources().getStringArray(R.array.number_hard),getResources().getStringArray(R.array.title_hard));
        rvEasy.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvEasy,listenerEasy));
        rvMedium.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvMedium,listenerMedium));
        rvHard.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvHard,listenerHard));
    }

    private void setupTab(final View view, final String tag) {
        View tabView = createTabView(mTabHost.getContext(), tag); //設定頁籤
        TabHost.TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabView).setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return view;
            }
        });
        mTabHost.addTab(setContent);
    }

    @SuppressLint("InflateParams")
    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
        TextView tv = (TextView) view.findViewById(R.id.tabsText); //顯示文字
        tv.setText(text); //設定文字
        return view;
    }

    private RecyclerTouchListener.ClickListener listenerEasy = new RecyclerTouchListener.ClickListener() {

        @Override
        public void onClick(View view, int position) {
            switch (position){
                case 0:
                    MainActivityFragment.n001(fragmentManager);
                    break;
                case 1:
                    MainActivityFragment.n007(fragmentManager);
                    break;
                case 2:
                    MainActivityFragment.n009(fragmentManager);
                    break;
                case 3:
                    MainActivityFragment.n014(fragmentManager);
                    break;
                case 4:
                    MainActivityFragment.n202(fragmentManager);
                    break;
                default:
                    Log.i("none","none");
                    break;
            }
        }

        @Override
        public void onLongClick(View view, int position) {

        }
    };

    private RecyclerTouchListener.ClickListener listenerMedium = new RecyclerTouchListener.ClickListener() {

        @Override
        public void onClick(View view, int position) {
            switch (position){
                case 0:
                    MainActivityFragment.n002(fragmentManager);
                    break;
                case 1:
                    MainActivityFragment.n003(fragmentManager);
                    break;
                case 2:
                    MainActivityFragment.n006(fragmentManager);
                    break;
                case 3:
                    MainActivityFragment.n011(fragmentManager);
                    break;
                default:
                    Log.i("none","none");
                    break;
            }
        }

        @Override
        public void onLongClick(View view, int position) {

        }
    };

    private RecyclerTouchListener.ClickListener listenerHard = new RecyclerTouchListener.ClickListener() {

        @Override
        public void onClick(View view, int position) {
            switch (position){
                case 0:
                    Log.i("h","001");
                    break;
                default:
                    Log.i("none","none");
                    break;
            }
        }

        @Override
        public void onLongClick(View view, int position) {

        }
    };
}
