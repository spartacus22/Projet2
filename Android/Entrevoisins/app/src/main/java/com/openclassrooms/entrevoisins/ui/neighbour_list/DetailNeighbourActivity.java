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
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DetailNeighbourEvent;
import com.openclassrooms.entrevoisins.events.FavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNeighbourActivity extends AppCompatActivity {

    public static String NEIGHBOUR_KEY="neighbourKey";

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

    @BindView(R.id.phone2)
    TextView phone;

    @BindView(R.id.favorite_neighbour)
    ImageView favori;

    @BindView(R.id.backarrow)
    ImageView backarrow;

    private NeighbourApiService mApiService;
    private String mNeighbourImage;
    private Neighbour detailNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
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
        // detailNeighbour = (Neighbour) intent.getSerializableExtra(NEIGHBOUR_KEY);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            detailNeighbour = (Neighbour) getIntent().getExtras()
                    .getSerializable(NEIGHBOUR_KEY);

        }
        name.setText(detailNeighbour.getName());
        name3.setText(detailNeighbour.getName());
        address.setText(detailNeighbour.getAddress());
        aboutme.setText(detailNeighbour.getAboutMe());
        phone.setText(detailNeighbour.getPhoneNumber());

        Uri neighbour_url = Uri.parse(detailNeighbour.getAvatarUrl());
        Glide.with(this)
                .load(neighbour_url)
                .into(avatar);
        };


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(NEIGHBOUR_KEY, detailNeighbour);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }

    @OnClick(R.id.backarrow)
    void backScreen() {
        //Intent i = new Intent(this, ListNeighbourActivity.class);
        //startActivity(i);
        finish();
    }

    @OnClick(R.id.favorite_neighbour)
    void favoriteNeighbour() {

        Boolean flag = detailNeighbour.getFavori();

        if (!flag) {
            favori.setImageResource(R.drawable.ic_star_white_24dp);
            detailNeighbour.setFavori(true);
            EventBus.getDefault().post(new FavoriteNeighbourEvent(detailNeighbour));
            EventBus.getDefault().post(new DetailNeighbourEvent(detailNeighbour));
        }
        else {
            favori.setImageResource(R.drawable.ic_star_border_white_24dp);
            detailNeighbour.setFavori(false);
            EventBus.getDefault().post(new FavoriteNeighbourEvent(detailNeighbour));
            EventBus.getDefault().post(new DetailNeighbourEvent(detailNeighbour));
        }
    }
}
