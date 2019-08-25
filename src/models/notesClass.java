package models;

public class notesClass {
	static int count = 0;
	int id;
	String name;
	String note;
	
	
	public notesClass(String name, String note) {
		this.name = name;
		this.note = note;
		this.id = count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}
	
}
