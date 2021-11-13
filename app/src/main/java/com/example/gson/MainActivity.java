package com.example.gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    bt1=findViewById(R.id.button);
    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            updatetextView();
        }
    });
    }
    private void updatetextView() {
        //make the network call here
       /* networkTask newt=new networkTask();
        newt.execute("https://api.github.com/search/users?q=harsit");*/
        try {
            makeNetworkcall("https://api.github.com/search/users?q=harsit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void makeNetworkcall(String url) throws IOException {

        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();

        //    Response response=client.newCall(request).execute();//run on main thread
        //we got crash network on main thread
//async method working in back thread
        client.newCall(request).enqueue(new Callback() {
            //network call fail
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(MainActivity.this, "Fail in connection", Toast.LENGTH_SHORT).show();
            }
            //network success way
            @Override
            public void onResponse(Response response) throws IOException {
//This is not run in main thread

                String res=response.body().string();

              //  ArrayList<GithubUser> users=parseJson(res);
                // Log.e(TAG,"onPostExecute"+users.size());

                //we try to use ui component that is not present in ui thread
                //we go error

                // RecyclerView recyclerView=findViewById(R.id.recycler);
                //recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                Gson gson=new Gson();
                Result apiResult=gson.fromJson(res,Result.class);
                //recyclerView.setAdapter(githubUserAdapter);
                final GithubAdapter githubUserAdapter=new GithubAdapter(apiResult.getItems(),getBaseContext());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //code here run on the main ui thread

                        RecyclerView recyclerView=findViewById(R.id.recycler);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false));

                        recyclerView.setAdapter(githubUserAdapter);
                    }
                });

            }
        });
    }

}