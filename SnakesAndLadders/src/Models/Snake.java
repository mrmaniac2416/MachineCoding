package Models;

import Exceptions.InvalidSnakeException;

public class Snake {
	private int head;
	private int tail;
	public Snake(int head, int tail) throws InvalidSnakeException {
		super();
		if(head<=tail)
			throw new InvalidSnakeException("Head should be greater than tail");
		this.head = head;
		this.tail = tail;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getTail() {
		return tail;
	}
	public void setTail(int tail) {
		this.tail = tail;
	}
	
	

}
