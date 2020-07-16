package com.grimiore.githubuser.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UsersItem implements Parcelable{
	private String follower;
	private String following;
	private String name;
	private String company;
	private String location;
	private String repository;
	private String username;
	private int avatar;

	public UsersItem(Parcel in) {
		follower = in.readString();
		following = in.readString();
		name = in.readString();
		company = in.readString();
		location = in.readString();
		avatar = in.readInt();
		repository = in.readString();
		username = in.readString();
	}

	public static final Creator<UsersItem> CREATOR = new Creator<UsersItem>() {

		@Override
		public UsersItem createFromParcel(Parcel source) {
			return new UsersItem(source);
		}

		@Override
		public UsersItem[] newArray(int size) {
			return new UsersItem[size];
		}
	};

	public UsersItem() {

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(follower);
		dest.writeString(following);
		dest.writeString(name);
		dest.writeString(company);
		dest.writeString(location);
		dest.writeInt(avatar);
		dest.writeString(repository);
		dest.writeString(username);
	}

	public void setFollower(String follower){
		this.follower = follower;
	}

	public String getFollower(){
		return follower;
	}

	public void setFollowing(String following){
		this.following = following;
	}

	public String getFollowing(){
		return following;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public void setRepository(String repository){
		this.repository = repository;
	}

	public String getRepository(){
		return repository;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
