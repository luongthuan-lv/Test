package com.poly.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.poly.test.model.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Example> exampleList;
    ViewPager vpPicture;
    TabLayout tabs;
    ViewpagerAdapter viewpagerAdapter;
    int pages=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPicture = findViewById(R.id.vpPicture);
        tabs=findViewById(R.id.tabs);

        getDataPicture(pages);
        vpPicture.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                pages++;
//                getDataPicture(pages);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void getDataPicture(int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://picsum.photos")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData(page, 5).enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                exampleList = new ArrayList<>();
                exampleList = response.body();
                Log.e("FFFF", response.body().size() + "");
                viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager(),exampleList);
                vpPicture.setAdapter(viewpagerAdapter);
                tabs.setupWithViewPager(vpPicture);

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e("Loi",t.getMessage());

            }
        });
    }
}