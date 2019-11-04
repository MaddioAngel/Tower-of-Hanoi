package conceptCode;
import java.io.*; 
import java.util.*; 

public class userSide {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Scanner reads the keyboard

		System.out.print("How many blocks? "); //Asks user for how many blocks they want
		int numOfBlocks = scan.nextInt(); //Gets the users number
		
		
		Stack<blockObject> a = new Stack<blockObject>(); //peg 1
		Stack<blockObject> b = new Stack<blockObject>(); //peg 2
		Stack<blockObject> c = new Stack<blockObject>(); //peg 3
		
		//adds to Stack A the number of blocks 
		for (int i = numOfBlocks; i >= 1; i-- ) {
			a.add(new blockObject(i)); //Stack a is the first peg and Stack c is the last peg
		}

		int userTries = 0;
		
		while(true) {
			printPegs(a,b,c); //Prints all the pegs (method at line 82)

			System.out.print("Move Block: "); //Asks user which block they want to move
			int userBlock = scan.nextInt(); //Gets the block from user
			
			System.out.print("To peg: "); //Asks user to which peg they want to move userBlock to
			Character userPegMove = scan.next().charAt(0); //Get the peg from user
			
			Stack<blockObject> blockPeg = checkPegsForBlock(userBlock, a,b,c); // checks where the user's block is in the three pegs
			Stack<blockObject> nextPeg = getUserPeg(userPegMove, a, b, c); // finds the peg the user wants to move the block to
			//if the peg the user wants to move the block to is empty 
			//then the block is automatically moved
			
				if(nextPeg.isEmpty()) {
					nextPeg.add(blockPeg.pop());
				}
				//if the block couldn't be found
				//
				
				else if(blockPeg.isEmpty()) {
					
				}
				
				else if(blockPeg.peek().getSize() < nextPeg.peek().getSize()) {
					nextPeg.add(blockPeg.pop());
				}
				
				else {
					System.out.println("Not Allowed");
				}
			
			userTries++;
			if(checkForWin(a, b)) {
				
				break;
				
			}
		}
		printPegs(a,b,c);
		System.out.println("Win");
	}
	
	public static void printArray(Stack<blockObject> s) {
		System.out.print("[ ");
		Stack<blockObject> tempStack = new Stack<blockObject>(); 
		blockObject temp;
		while (!s.isEmpty())
		{	
			temp = s.pop();
			System.out.print(temp +" ");
			tempStack.add(temp);
		}
		
		while (!tempStack.isEmpty())
		{	
			temp = tempStack.pop();
			s.add(temp);
		}
		
		
		System.out.print("]");
		System.out.println();
	}
	public static void printPegs(Stack<blockObject> a, Stack<blockObject> b, Stack<blockObject> c) {
		System.out.print("A: ");
		printArray(a);
		System.out.print("B: ");
		printArray(b);
		System.out.print("C: ");
		printArray(c);
	}
	
	public static Stack<blockObject> checkPegsForBlock(int userBlock, Stack<blockObject> a, Stack<blockObject> b, Stack<blockObject> c) {
		boolean isA = false;
		boolean isB = false;
		boolean isC = false;
		
		blockObject temp;
		Stack<blockObject> tempStack = new Stack<blockObject>(); 
		while (!a.isEmpty())
		{	
			temp = a.pop();
			if(userBlock == temp.getSize()) {
				isA = true;
			}
			tempStack.add(temp);
		}
		
		while (!tempStack.isEmpty())
		{	
			temp = tempStack.pop();
			a.add(temp);
		}
		//End of A Search
		
		while (!b.isEmpty())
		{	
			temp = b.pop();
			if(userBlock == temp.getSize()) {
				isB = true;
			}
			tempStack.add(temp);
		}
		
		while (!tempStack.isEmpty())
		{	
			temp = tempStack.pop();
			b.add(temp);
		}
		//End of B Search
		

		while (!c.isEmpty())
		{	
			temp = c.pop();
			if(userBlock == temp.getSize()) {
				isC = true;
			}
			tempStack.add(temp);
		}
		
		while (!tempStack.isEmpty())
		{	
			temp = tempStack.pop();
			c.add(temp);
		}
		//End of C Search
		if(isA) {return a;}
		else if(isB) {return b;}
		else if(isC) {return c;}
		else {
			System.out.println("Number not found");
			return null;
		}

	}

	public static Stack<blockObject> getUserPeg(Character userMoveToPeg, Stack<blockObject> a, Stack<blockObject> b, Stack<blockObject> c) {
		
		if(userMoveToPeg.equals('A') || userMoveToPeg.equals('a')) {
			return a;
		}
		if(userMoveToPeg.equals('B') || userMoveToPeg.equals('b')) {
			return b;
		}
		if(userMoveToPeg.equals('C') || userMoveToPeg.equals('c')) {
			return c;
		}
		
		else {
			System.out.println("Error");
			return null;
		}
		
	}
	

	public static boolean checkForWin(Stack<blockObject> a, Stack<blockObject> b) {
		if(a.isEmpty() && b.isEmpty()) {
			return true;
		}
		else
			return false;
		
	}
}
