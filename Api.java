package com.example.gallien.assignement;

/**
 * Created by Gallien on 17/04/2018.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface Api {



    @POST("/users/{uid}.{json}")
    Call<User> setData(@Path("uid") String s1,@Path("json") String json, @Query("auth") String token, @Body User user);

    @GET("/users/{uid}.json")
    Call<User> getData(@Path("uid") String s1);


}
