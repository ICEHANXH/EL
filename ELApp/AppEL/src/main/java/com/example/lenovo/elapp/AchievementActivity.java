package com.example.lenovo.elapp;



import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


import java.util.ArrayList;
import java.util.List;


public class AchievementActivity extends AppCompatActivity {

    private List<Achievement_item> itemList = new ArrayList<Achievement_item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        //设置瀑布流
        initItems();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Achievement_Adapter adapter=new Achievement_Adapter(itemList);
        recyclerView.setAdapter(adapter);
        //隐藏actionbar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

    }

    private void initItems(){
        for(int i=0;i<2;i++){
            Achievement_item item_1 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_1);
            Achievement_item item_2 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_2);
            Achievement_item item_3 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_3);
            Achievement_item item_4 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_4);
            Achievement_item item_5 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_5);
            Achievement_item item_6 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_6);
            Achievement_item item_7 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_7);
            Achievement_item item_8 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_8);
            Achievement_item item_9 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_9);
            Achievement_item item_10 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_10);
            Achievement_item item_11 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_11);
            Achievement_item item_12 = new Achievement_item("master",R.mipmap.achievement);
            itemList.add(item_12);
        }
    }

}
