package Models;

import Exceptions.InvalidLadderException;

public class Ladder {
	private int start;
	private int end;
	
	
	
	public Ladder(int start, int end) throws InvalidLadderException {
		super();
		if(start>=end)
			throw new InvalidLadderException("Start position should be less than end position");
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	

}
