package conceptCode;
import java.io.*;
import java.util.Stack; 

public class blockObject {
	private int size;
	private int priority;
	
	public blockObject(int n) {
		this.priority = n;
		this.size = n;

	}
	public int getSize() {
		return size;
	}
	public int getPriority() {
		return priority;
	}
	
	public boolean checkPriority(Stack<blockObject> b) {
		if (getPriority() >  b.peek().getPriority()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString() {
		String toString = String.valueOf(size);
		return toString;
		
	}
}