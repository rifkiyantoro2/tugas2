package com.grimiore.githubuser.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.grimiore.githubuser.R;
import com.grimiore.githubuser.model.UsersItem;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_suer";

    ImageView ivAvatar;
    TextView tvName, tvUsername, tvFollower, tvFollowing, tvLocation, tvCompany, tvRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvFollower = findViewById(R.id.tv_follower);
        tvFollowing = findViewById(R.id.tv_following);
        tvLocation = findViewById(R.id.tv_location);
        tvCompany = findViewById(R.id.tv_company);
        tvRepository = findViewById(R.id.tv_repository);
        ivAvatar = findViewById(R.id.iv_avatar);

        UsersItem usersItem = this.getIntent().getParcelableExtra(EXTRA_USER);

        tvName.setText(usersItem.getName());
        tvUsername.setText(usersItem.getUsername());
        tvLocation.setText(usersItem.getLocation());
        tvCompany.setText(usersItem.getCompany());
        tvRepository.setText(usersItem.getRepository());
        tvFollower.setText(usersItem.getFollower());
        tvFollowing.setText(usersItem.getFollowing());
        ivAvatar.setImageResource(usersItem.getAvatar());
    }
}
