package com.example.sirisha.moviedbapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sirisha on 09-05-2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    Context context;
    ArrayList<Pojo> dataList=new ArrayList<>();

       public MyAdapter(Context c, ArrayList<Pojo> data){

        this.context=c;
        this.dataList=data;
    }
    @Override
    public MyAdapter.MyAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.image,parent,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyAdapterViewHolder holder, int position) {

        Pojo POJO =dataList.get(position);

        Picasso.with(context).load(POJO.getPoster()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.error).into(holder.iv);
    }
    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        ImageView iv;

        public MyAdapterViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int details=getAdapterPosition();
            String[] str=new String[15];
            str[0]=dataList.get(details).getMtitle();
            str[1]=dataList.get(details).getRel_date();
            str[2]=dataList.get(details).getPoster();
            str[3]=dataList.get(details).getLang();
            str[5]=dataList.get(details).getPoster2();
            str[4]=dataList.get(details).getAnalysis();
            str[6]=Double.toString(dataList.get(details).getVote_count());
            str[7]=Double.toString(dataList.get(details).getVote_avg());
            str[8]=Double.toString(dataList.get(details).getPopularity());
            str[9]=Double.toString(dataList.get(details).getIdent());
            str[10]=Boolean.toString(dataList.get(details).adult);
            str[11]=Boolean.toString(dataList.get(details).vedio);

            Intent intent=new Intent(context,SecondActivity.class);
            intent.putExtra("details_must_required",str);
            v.getContext().startActivity(intent);
        }
    }

}

