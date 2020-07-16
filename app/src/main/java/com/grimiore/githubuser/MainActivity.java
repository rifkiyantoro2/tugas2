package com.grimiore.githubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.grimiore.githubuser.activity.DetailActivity;
import com.grimiore.githubuser.adapter.UserAdapter;
import com.grimiore.githubuser.model.UsersItem;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {
    private UserAdapter userAdapter;
    private String[] dataName, dataLocation, dataCompany, dataRepository, dataFollower, dataFollowing, dataUsername;
    private TypedArray dataAvatar;
    private ArrayList<UsersItem> usersItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_userGithub);
        userAdapter = new UserAdapter(this);
        listView.setAdapter(userAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_USER, usersItems.get(position));
                startActivity(detailIntent);
            }
        });
    }

    private void addItem() {
        usersItems = new ArrayList<>();
        for (int i=0; i < dataName.length; i++){
            UsersItem usersItem = new UsersItem();
            usersItem.setName(dataName[i]);
            usersItem.setLocation(dataLocation[i]);
            usersItem.setCompany(dataCompany[i]);
            usersItem.setRepository(dataRepository[i]);
            usersItem.setFollower(dataFollower[i]);
            usersItem.setFollowing(dataFollowing[i]);
            usersItem.setUsername(dataUsername[i]);
            usersItem.setAvatar(dataAvatar.getResourceId(i, -1));
            usersItems.add(usersItem);
        }
        userAdapter.setUsersItems(usersItems);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataLocation = getResources().getStringArray(R.array.location);
        dataCompany = getResources().getStringArray(R.array.company);
        dataRepository = getResources().getStringArray(R.array.repository);
        dataFollower = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
        dataUsername = getResources().getStringArray(R.array.username);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
    }
}
