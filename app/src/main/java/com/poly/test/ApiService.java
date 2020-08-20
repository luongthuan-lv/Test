package com.poly.test;

import com.poly.test.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v2/list")
    Call<List<Example>> getData(@Query("page") int page,
                               @Query("limit") int limit);
}
