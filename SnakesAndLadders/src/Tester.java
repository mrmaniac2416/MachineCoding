import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.InvalidLadderException;
import Exceptions.InvalidSnakeException;
import Services.Game;

public class Tester {

	public static void main(String[] args) throws InvalidLadderException, InvalidSnakeException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int numberOfSnakes=sc.nextInt();
		List<int []> snakes=new ArrayList<>();
		for(int i=0;i<numberOfSnakes;i++)
		{
			int head=sc.nextInt();
			int tail=sc.nextInt();
			int temp[]= {head,tail};
			snakes.add(temp);
			
		}
		
		
		int numberOfLadders=sc.nextInt();
		List<int []> ladders=new ArrayList<>();
		for(int i=0;i<numberOfLadders;i++)
		{
			int start=sc.nextInt();
			int end=sc.nextInt();
			int temp[]= {start,end};
			ladders.add(temp);
		}
		
		int numberOfPlayers=sc.nextInt();
		List<String> players=new ArrayList<>();
		for(int i=0;i<numberOfPlayers;i++)
		{
			String name=sc.next();
			players.add(name);
			sc.nextLine();
		}
		
		Game game=new Game(100,1,6,snakes,ladders,players);
		game.simulateGame();
		
	}

}
