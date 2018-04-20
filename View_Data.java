package com.example.gallien.assignement;

import android.content.Intent;
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
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class View_Data extends AppCompatActivity {
    private String token;
    private static String BASE_URL = "https://android-f21e8.firebaseio.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__data);

        final String uid = getIntent().getStringExtra("uid");
        final TextView view_data = findViewById(R.id.view_data);
        Button receive_button = findViewById(R.id.receive_button);
        Button add_travel = findViewById(R.id.add_travel);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//url of firebase app
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();

        final Api api = retrofit.create(Api.class);



        receive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> call2=api.getData();
                call2.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        //getToken();
                        //view_data.setText(response.body().getCountry().toString());
                        //Gson gson = new Gson();
                        //travel_info info = gson.fromJson(response.body(),travel_info.class);
                        view_data.setText(response.body().getCountry().toString());
                        Toast.makeText(View_Data.this, response.body().getCountry().toString(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(View_Data.this, "Nope",
                                Toast.LENGTH_SHORT).show();
                    }
                });
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
                            Toast.makeText(View_Data.this, "No token",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
