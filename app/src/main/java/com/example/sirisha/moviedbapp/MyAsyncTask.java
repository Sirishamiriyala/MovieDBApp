package com.example.sirisha.moviedbapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sirisha on 10-05-2018.
 */

class MyAsyncTask extends AsyncTask<String,Void,String> {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Context context;
    ArrayList<Pojo> data= new ArrayList<>();

    public MyAsyncTask(MainActivity mainActivity, RecyclerView movieapp) {

        this.context=mainActivity;
        this.recyclerView=movieapp;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog= new ProgressDialog(context);
        progressDialog.setTitle("MovieDBApp");
        progressDialog.setMessage("wait for while....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {


        String url=strings[0];
        StringBuilder output=new StringBuilder();
        try {
            URL buildUrl =new URL(url);
            HttpURLConnection connection=(HttpURLConnection)buildUrl.openConnection();
            InputStream inputStream=connection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line!=null)
            {
                line=bufferedReader.readLine();
                output.append(line);
            }
            return output.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String Poster2,poster,title,analysis,rel_date,lang,mtitle;
        double vote_count,vote_avg,Ident,popularity;
        boolean video,adult;
        try{
            JSONObject jsonObject =new JSONObject(s);
            JSONArray jsonArray =jsonObject.getJSONArray("results");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jb=jsonArray.getJSONObject(i);
                title=jb.getString("title");
                poster="https://image.tmdb.org/t/p/w500"+jb.getString("poster_path");
                Poster2="https://image.tmdb.org/t/p/w500"+jb.getString("backdrop_path");
                analysis=jb.getString("overview");
                rel_date=jb.getString("release_date");
                vote_avg=jb.getDouble("vote_average");
                vote_count=jb.getDouble("vote_count");
                popularity=jb.getDouble("popularity");
                video=jb.getBoolean("video");
                Ident=jb.getDouble("id");
                adult=jb.getBoolean("adult");
                mtitle=jb.getString("original_title");
                lang=jb.getString("original_language");

                Pojo p=new Pojo(Poster2,poster,title,analysis,rel_date,vote_avg,vote_count,popularity,video,Ident,adult,mtitle,lang);
                data.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(new MyAdapter(context,data));
        progressDialog.dismiss();
    }


}
