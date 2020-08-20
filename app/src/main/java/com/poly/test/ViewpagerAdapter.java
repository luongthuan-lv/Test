package com.poly.test;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.poly.test.model.Example;

import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private List<Example> exampleList;


    public ViewpagerAdapter(@NonNull FragmentManager fm, List<Example> exampleList) {
        super(fm);
        this.exampleList = exampleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",exampleList.get(position).getDownloadUrl());
        viewPagerFragment.setArguments(bundle);
        return viewPagerFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return exampleList.get(position).getAuthor();
    }

    @Override
    public int getCount() {
        return exampleList.size();
    }
//    @Override
//    public int getItemPosition(@NonNull Object object) {
//        return POSITION_NONE;
//    }
}
