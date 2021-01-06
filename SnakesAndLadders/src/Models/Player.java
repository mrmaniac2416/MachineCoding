package Models;

public class Player {
	private String name;
	private int id;
	private int position;
	
	public Player(String name,int position) {
		super();
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
}
