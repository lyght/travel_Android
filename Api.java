package com.example.gallien.assignement;

/**
 * Created by Gallien on 17/04/2018.
 */
import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface Api {



    @POST("/users/{uid}.{json}")
    Call<User> setData(@Path("uid") String s1,@Path("json") String json, @Query("auth") String token, @Body User user);

    @GET("/users/ZqjKMD5qewX0kICD0nXhNTot7f12/-LAPcCnbqZupzvt7FjrB.json?auth=eyJhbGciOiJSUzI1NiIsImtpZCI6ImZlZjg5YmE3MjEyNmU1NGZkZDUwYzkxOWI3YWRiNWUyNmYwMjk5Y2YifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vYW5kcm9pZC1mMjFlOCIsImF1ZCI6ImFuZHJvaWQtZjIxZTgiLCJhdXRoX3RpbWUiOjE1MjQxOTI3NDgsInVzZXJfaWQiOiJacWpLTUQ1cWV3WDBrSUNEMG5YaE5Ub3Q3ZjEyIiwic3ViIjoiWnFqS01ENXFld1gwa0lDRDBuWGhOVG90N2YxMiIsImlhdCI6MTUyNDE5Mjc0OCwiZXhwIjoxNTI0MTk2MzQ4LCJlbWFpbCI6InRva2VuQHRva2VuLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyJ0b2tlbkB0b2tlbi5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.jNdXkUJMuoWaXuui1ndIqET0yUkVom7DiTOInOPKTI46-n03wcqK9Jn2QHi3a3lK0K5ueTz823X1ubxncLsInp_IZ7eemX6GIYiPzFL-GfSFoT_35kQgLlkvjuGOlgo83EAazeVt50DQIBIgFIWewHnEm9fRBIbic_TU_Om-M0mu4Ci3W5Tr7KHpjOUMK7FlNLRobR-JbjbDiu3gsACO2NBh5uITxHGR4G2D0K3lCH33ezYTNPn0DQKWYo1Zt4GKQH7qRAolTLIN2tiodoucRcTicPiHcy4muPi5qSjnd1Xcl6Vtz-fxfW5MnQiYKUXOOlWJF5Gs7mvzTai0ec9UMA")
    Call<User> getData();
    //Call<User> getData(@Path("uid") String s1,@Path("json") String json);


}
