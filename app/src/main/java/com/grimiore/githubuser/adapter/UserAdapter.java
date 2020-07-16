package com.grimiore.githubuser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.grimiore.githubuser.R;
import com.grimiore.githubuser.model.UsersItem;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UsersItem> usersItems = new ArrayList<>();

    public void setUsersItems(ArrayList<UsersItem> usersItems){
        this.usersItems = usersItems;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return usersItems.size();
    }

    @Override
    public Object getItem(int position) {
        return usersItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.user_list, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        UsersItem usersItem = (UsersItem) getItem(position);
        viewHolder.bind(usersItem);
        return convertView;
    }

    private class ViewHolder{
        private TextView tvName, tvLocation, tvUsername;
        private ImageView imgAvatar;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvLocation = view.findViewById(R.id.tv_location);
            tvUsername = view.findViewById(R.id.tv_username);
            imgAvatar = view.findViewById(R.id.iv_avatar);
        }

        void bind(UsersItem usersItem){
            tvName.setText(usersItem.getName());
            tvLocation.setText(usersItem.getLocation());
            tvUsername.setText(usersItem.getUsername());
            imgAvatar.setImageResource(usersItem.getAvatar());
        }
    }
}
