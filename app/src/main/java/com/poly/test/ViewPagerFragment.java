package com.poly.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class ViewPagerFragment extends Fragment {
    ImageView imgViews;
    public ViewPagerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_view,container,false);
        imgViews=view.findViewById(R.id.imgViews);
        //  String title=getArguments().getString("");
        String url=getArguments().getString("url");
        Glide.with(getActivity()).load(url).into(imgViews);
        return view;
    }
}
