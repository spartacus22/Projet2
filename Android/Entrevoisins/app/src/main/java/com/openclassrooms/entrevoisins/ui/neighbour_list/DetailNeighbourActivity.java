package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.avatar2)
    ImageView avatar;

    @BindView(R.id.name2)
    TextView name;

    @BindView(R.id.name3)
    TextView name3;

    @BindView(R.id.address2)
    TextView address;

    @BindView(R.id.aboutme2)
    TextView aboutme;

    private NeighbourApiService mApiService;
    private String mNeighbourImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getNeighbourApiService();
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        Intent intent = getIntent();
        String neighbour_name = intent.getStringExtra("name");
        String neighbour_address = intent.getStringExtra("address");
        String neighbour_aboutme = intent.getStringExtra("aboutme");
        String neighbour_url_string = intent.getStringExtra("avatar_url_string");
        Uri neighbour_url = Uri.parse(neighbour_url_string);

        name.setText(neighbour_name);
        name3.setText(neighbour_name);
        address.setText(neighbour_address);
        aboutme.setText(neighbour_aboutme);

        Glide.with(this)
                .load(neighbour_url)
                .into(avatar);
        };

}
