package models;

public class Photo {
	static int id;
	int photoId;
	String photoName;
	String address;

	/* Default photo constructor */
	public Photo() {
		this.photoName = "";
		this.address = "";
		this.photoId = id++;

	}

	/* Photo Constructor */
	public Photo(String fileName, String address) {
		this.photoName = fileName;
		this.address = address;
		this.photoId = id++;
	}

	/* Create a photo */
	public Photo createPhoto() {
		Photo newPhoto = new Photo();
		return newPhoto;
	}
	/* Create photo with specific name and address */
	public Photo createPhoto(String filename, String address) {
		Photo newPhoto = new Photo(filename, address);
		return newPhoto;
	}

	public String getAdress() {
		return this.address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public String getPhotoName(){
		return this.photoName;
	}

}
