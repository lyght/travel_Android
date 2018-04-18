package com.example.gallien.assignement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;

public class User_Data extends AppCompatActivity {
     private String token;
    private static String BASE_URL = "https://android-f21e8.firebaseio.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__data);

        final String uid = getIntent().getStringExtra("uid");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//url of firebase app
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();

        final Api api = retrofit.create(Api.class);//use of interface
        final TextView country = findViewById(R.id.countryField);
        final TextView cities = findViewById(R.id.citiesField);
        Button post = findViewById(R.id.post);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getToken();

                List<String> listCity = new ArrayList();
                Call<User> call1 =api.setData(uid,"json",token, new User(country.getText().toString(),Arrays.asList(cities.getText().toString().split(","))));
                call1.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(User_Data.this,token,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(User_Data.this, "Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    void getToken(){
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        mUser.getIdToken(true)
                .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                    public void onComplete(@NonNull Task<GetTokenResult> task) {
                        if (task.isSuccessful()) {
                            String idToken = task.getResult().getToken();
                            // Send token to your backend via HTTPS
                            token =idToken;
                        } else {
                            // Handle error -> task.getException();
                            Toast.makeText(User_Data.this, "No token",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
