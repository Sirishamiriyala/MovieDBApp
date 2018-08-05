package com.example.sirisha.moviedbapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.title)
    TextView name;
    @BindView(R.id.release)
    TextView rele_date;
    @BindView(R.id.plot_des)
    TextView sysn;
    @BindView(R.id.rating)
    TextView vote_avg;
    @BindView(R.id.poster)
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        String[] getDetails = getIntent().getStringArrayExtra("details_must_required");
        Picasso.with(this).load(getDetails[5]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.error).into(poster);
        rele_date.setText(getDetails[1]);
        name.setText(getDetails[0]);
        sysn.setText(getDetails[4]);
        vote_avg.setText(getDetails[7]);
    }
}
