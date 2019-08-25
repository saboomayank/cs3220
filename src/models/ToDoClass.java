package models;

public class ToDoClass {
	static int count  = 0;
	int id;
	String task;
	boolean done;
	//add id and boolean for task done

	public ToDoClass(String task) {
		this.task = task;
		this.id = count++;
		done = false;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
