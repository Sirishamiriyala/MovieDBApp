package com.example.sirisha.moviedbapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    static final String api_key = BuildConfig.api;
    RecyclerView movieapp;

    String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + api_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieapp = findViewById(R.id.movieslist);
        if (isonline()) {
            MyAsyncTask task = new MyAsyncTask(this, movieapp);
            task.execute(url);
        } else {
            Toast.makeText(this, "No Network Connection", Toast.LENGTH_SHORT).show();
        }

    }

    protected boolean isonline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.adapter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (isonline()) {
            switch (item.getItemId()) {
                case R.id.popular:
                    new MyAsyncTask(this, movieapp).execute(url);
                    break;
                case R.id.rating:
                    new MyAsyncTask(this, movieapp).execute("https://api.themoviedb.org/3/movie/top_rated?api_key=" + api_key);
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
        } else {
            Toast.makeText(this, "NO Network Connection", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
