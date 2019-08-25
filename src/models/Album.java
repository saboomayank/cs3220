package models;

import java.util.ArrayList;

public class Album {
	static int id;
	String albumName;
	String description;
	int photoCount;
	int albumId;
	ArrayList<Photo> photoAlbum = new ArrayList<Photo>();

	public Album(String albumName, String description) {
		this.albumName = albumName;
		this.description = description;
		this.photoCount = 0;
		this.albumId = id++;
	}

	public void addPhoto(Photo photo) {
		this.photoAlbum.add(photo);
		this.photoCount++;
	}

	public void addPhoto(String fileName, String address){
		this.photoAlbum.add(new Photo(fileName, address));
		this.photoCount++;
	}

	public Photo getPhoto(String fileName) {
		for(int i = 0; i < photoAlbum.size(); i++) {
			if(photoAlbum.get(i).photoName.equals(fileName)) {
				return photoAlbum.get(i);
			}
		}
		return null;
	}

	public void removePhoto(String fileName) {
		this.photoAlbum.remove(getPhoto(fileName));
		if(photoCount != 0)
			this.photoCount--;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public String getDescription() {
		return this.description;
	}

	public int getAlbumID(){
		return this.albumId;
	}
	
	public void setAlbumName(String albumName, String description) {
		this.albumName = albumName;
		this.description = description;
	}

	public int getPhotoct() {
		int temp = 0;
		for(int i = 0; i < photoAlbum.size(); i++) {
			temp++;
		}
		photoCount = temp;
		return this.photoCount;
	}

	public ArrayList<Photo> getPhotoAlbum(){
		return this.photoAlbum;
	}

	public void setPhotoAlbum(ArrayList<Photo> album){
		this.photoAlbum = album;
	}

}
