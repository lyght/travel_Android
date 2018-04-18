package com.example.gallien.assignement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class View_Data extends AppCompatActivity {
    private static String BASE_URL = "https://android-f21e8.firebaseio.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__data);

        final String uid = getIntent().getStringExtra("uid");
        final TextView view_data = findViewById(R.id.view_data);

        Button add_travel = findViewById(R.id.add_travel);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//url of firebase app
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();

        final Api api = retrofit.create(Api.class);

        Call<User> call2=api.getData(uid);

        call2.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //view_data.setText(response.body().getCountry());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        add_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_user_uid = new Intent(View_Data.this, User_Data.class);
                intent_user_uid.putExtra("uid", uid);
                startActivity(intent_user_uid);
            }
        });
    }
}
