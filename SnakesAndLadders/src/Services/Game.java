package Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Exceptions.InvalidLadderException;
import Exceptions.InvalidSnakeException;
import Models.*;

public class Game {
	private int maxSize;
	private int noOfDice;
	private int maxDiceNumber;
	
	private HashMap<Integer,Ladder> ladderMap;
	private HashMap<Integer,Snake> snakeMap;
	private List<Player> players;
	private int startPosition;
	private int totalMoves;
	
	
	public Game(int maxSize,int noOfDice,int maxDiceNumber,List<int []> snakes,List<int []> ladders,List<String> players) throws InvalidLadderException, InvalidSnakeException
	{
		this.maxSize=maxSize;
		this.noOfDice=noOfDice;
		this.maxDiceNumber=maxDiceNumber;
		this.startPosition=0;
		this.createLadderMap(ladders);
		this.createSnakeMap(snakes);
		this.generatePlayer(players);
		this.setTotalMoves(0);
		
	}
	
	private void createSnakeMap(List<int []> snakes) throws InvalidSnakeException
	{
		this.snakeMap=new HashMap<>();
		for(int []snake : snakes)
		{
			snakeMap.put(snake[0], new Snake(snake[0],snake[1]));
		}
	}
	
	private void createLadderMap(List<int []> ladders) throws InvalidLadderException
	{
		this.ladderMap=new HashMap<>();
		for(int []ladder : ladders)
		{
			this.ladderMap.put(ladder[0], new Ladder(ladder[0],ladder[1]));
		}
	}
	
	private void generatePlayer(List<String> players)
	{
		this.players=new ArrayList<>();
		players.forEach( p -> this.players.add(new Player(p,this.startPosition)));
	}
	


	public int getMaxSize() {
		return maxSize;
	}


	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}


	public int getNoOfDice() {
		return noOfDice;
	}


	public void setNoOfDice(int noOfDice) {
		this.noOfDice = noOfDice;
	}


	public HashMap<Integer, Ladder> getLadderMap() {
		return ladderMap;
	}


	public void setLadderMap(HashMap<Integer, Ladder> ladderMap) {
		this.ladderMap = ladderMap;
	}


	public HashMap<Integer, Snake> getSnakeMap() {
		return snakeMap;
	}


	public void setSnakeMap(HashMap<Integer, Snake> snakeMap) {
		this.snakeMap = snakeMap;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	public int getMaxDiceNumber() {
		return maxDiceNumber;
	}


	public void setMaxDiceNumber(int maxDiceNumber) {
		this.maxDiceNumber = maxDiceNumber;
	}
	
	public int getTotalMoves() {
		return totalMoves;
	}

	public void setTotalMoves(int totalMoves) {
		this.totalMoves = totalMoves;
	}

	private int getRandomMove()
	{
		Random r=new Random();
		return r.nextInt(maxDiceNumber)+1;
	}


	private int [] simulateNextMoveForAPlayer(Player p)
	{
		int totalMove=0;
		for(int i=0;i<this.noOfDice;i++)
			totalMove+=this.getRandomMove();
		
		int futurePosition=p.getPosition()+totalMove;
		
		if(futurePosition>this.maxSize)
			   futurePosition=p.getPosition();   
		else
		{
			while(ladderMap.containsKey(futurePosition) || snakeMap.containsKey(futurePosition))
			{
				if(ladderMap.containsKey(futurePosition))
					futurePosition=ladderMap.get(futurePosition).getEnd();
				else
					futurePosition=snakeMap.get(futurePosition).getTail();
			}
		}
		
		printMove(p.getName(),totalMove,p.getPosition(),futurePosition);
		p.setPosition(futurePosition);
		int temp[]= {futurePosition,totalMove};
		return temp;
	}
	
	private boolean simulateOneIteration()
	{
		for(Player p : this.players)
		{
			
			int playerNextMove=0;
			int movedSteps=0;
			int orgPosition=p.getPosition();
			int consecutiveSixes=0;
			
			do {
				int move[]=simulateNextMoveForAPlayer(p);
				playerNextMove=move[0];
				movedSteps=move[1];
				if(movedSteps==6)
					consecutiveSixes++;
				
			}
			while(movedSteps==6 && consecutiveSixes<3);
			
			if(consecutiveSixes==3)
			{
				p.setPosition(orgPosition);
				playerNextMove=orgPosition;
			}
			
			if(playerNextMove==maxSize)
				 	{
				       System.out.println(p.getName() + " wins the game! "); 
				       return true;
				 	}
				
		}
		
		return false;
	}
	
	public void simulateGame()
	{
		boolean isGameOver=false;
		
		while(!isGameOver) {
			{
				isGameOver=simulateOneIteration();
				this.totalMoves++;
			}
		}
		System.out.println("Total moves taken: " + this.totalMoves);
	}
	
	
	private void printMove(String name,int totalMove,int prevPosition,int currPosition)
	{
		System.out.println(name + " rolled a " + totalMove + " and moved from " + prevPosition + " to "  + currPosition);
	}
	
}
