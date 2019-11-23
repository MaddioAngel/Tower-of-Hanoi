
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.undo.StateEditable;

import java.util.Stack;

public class ComHanoi extends JPanel implements  Runnable{
	Color diskColors[] = {Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.GRAY, Color.RED, 
	          Color.DARK_GRAY,Color.CYAN, Color.BLUE, Color.GREEN,Color.MAGENTA}; //list of colors for disks
    private static Stack<RoundRectangle2D.Double> towerStack[]= new Stack[3];
    private Stack<Color> colorOfDisk[] = new Stack[3];
    static int panelWidth = 500;
    static int panelHeight = 400;
	static int numberOfBlocks = 3;
	static double biggestBlock;
	Thread t = new Thread(this);

	public ComHanoi(int w, int h) {
		setLayout(null);
		panelWidth = w;
		panelHeight = h;
		
		setSize(panelWidth, panelHeight);
		
        towerStack[0] = new Stack<>(); //disks at first pole
        towerStack[1] = new Stack<RoundRectangle2D.Double>(); //disks at second pole
        towerStack[2] = new Stack<RoundRectangle2D.Double>(); //disks at third pole

        colorOfDisk[0] = new Stack<>(); //colors of disks for first pole
        colorOfDisk[1] = new Stack<>(); //colors of disks for second pole
        colorOfDisk[2] = new Stack<>(); //colors of disks for third pole
        
        
      for (int i = 0; i < numberOfBlocks; i++) {
          RoundRectangle2D.Double rec = new RoundRectangle2D.Double();
          double x = panelWidth/6;	
          double y = panelHeight-100;
          if(x==0)
              x=150;
          double wr= numberOfBlocks*25-20*i;
          if(biggestBlock < wr) {
        	  biggestBlock = wr;
          }
          
          System.out.println("wr: "+ wr);
          rec.setRoundRect(x-wr/2, (y - 27)-i*20, wr, 20, 25,25);
          towerStack[0].push(rec);
          colorOfDisk[0].push(diskColors[i]);
	  }
	  t.start();
	}
	public void towerOfHanoi(int n, Stack<RoundRectangle2D.Double> from_rod, Stack<RoundRectangle2D.Double> to_rod, Stack<RoundRectangle2D.Double> aux_rod, Stack<Color> c1, Stack<Color> c3, Stack<Color> c2 ) 
    {
		if (n == 1) { try {t.sleep(700);
        	if(!from_rod.isEmpty()) {
        	to_rod.add(from_rod.pop());
        	c3.push(c1.pop());
        	moveRect(to_rod);
        	repaint();
        }
        	return;
        	}
		
		catch(Exception e) {}
		
		}
        else {
          	towerOfHanoi(n-1, from_rod, aux_rod, to_rod, c1, c2, c3);
          	towerOfHanoi(1, from_rod, to_rod, aux_rod,c1,c3,c2);
            towerOfHanoi(n-1, aux_rod, to_rod, from_rod, c2, c3, c1);
            
      	}
		if(checkForWin()) {
        	System.out.println("Done");
        }
        }
	public void run() {	
		try
        {
        towerOfHanoi(numberOfBlocks, towerStack[0], towerStack[2], towerStack[1], colorOfDisk[0], colorOfDisk[2], colorOfDisk[1]);
        
		}
		catch(Exception e) {}
	}
	public void paint(Graphics g){
		super.paint(g);
		
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.white); 
        g1.fillRect(0, 0, panelWidth , panelHeight); //setting background to white

        int x1 = panelWidth/6;
        int y1 = panelHeight-100;
        int y2 = panelHeight-375;
        g1.setColor(Color.black);
        g1.setStroke(new BasicStroke(13));
        
        g1.drawLine(0,y1, panelWidth,y1); //line at bottom
        g1.drawLine(x1, y1, x1, y2); //first pole
        g1.drawLine(x1*3, y1, x1*3, y2); //second pole
        
        g1.drawLine(x1*5, y1, x1*5, y2); //third pole
        
        g1.setStroke(new BasicStroke(1));
        
        drawTower(g1,0);
        drawTower(g1,1);
        drawTower(g1,2);
	}
	public static void moveRect(Stack<RoundRectangle2D.Double> stack) {
		int x1 = panelWidth/6;
		double y = panelHeight-100;
		RoundRectangle2D.Double	temp = stack.pop();
		double i = biggestBlock-temp.getWidth();
		i = i/20;
		double wr= (numberOfBlocks*25-20*i);
		
		if(stack == towerStack[1]) {
			double j = getSizeStack(towerStack[1]);
			
			temp.setRoundRect(x1*3-wr/2, (y - 27)-j*20, temp.getWidth(), 20, 25,25);
			stack.push(temp);
		}
		else if(stack == towerStack[2]) {
			i = i/20;
			double j = getSizeStack(towerStack[2]);
			temp.setRoundRect(x1*5-wr/2, (y - 27)-j*20, temp.getWidth(), 20, 25,25);
			stack.push(temp);
		}
		else {
			double j = getSizeStack(towerStack[0]);
			
			temp.setRoundRect(x1-wr/2, (y - 27)-j*20, temp.getWidth(), 20, 25,25);
			stack.push(temp);
			
		}
		
	}
	public static int getSizeStack(Stack<RoundRectangle2D.Double> a) {
		int count = 0;
		Stack<RoundRectangle2D.Double> tempStack = new Stack<RoundRectangle2D.Double>();
		while(!a.isEmpty()) {
			RoundRectangle2D.Double temp = a.pop();
			count++;
			tempStack.push(temp);
		}
		while(!tempStack.isEmpty()) {
			RoundRectangle2D.Double temp = tempStack.pop();
			a.push(temp);
					
		}
		return count;
		
	}
	private void drawTower(Graphics2D g2, int n) {    	
            for (int i = 0; i < towerStack[n].size();i++) {
                g2.setColor(colorOfDisk[n].get(i));
                g2.fill(towerStack[n].get(i));
                g2.draw(towerStack[n].get(i));
            }
        }
	public boolean checkForWin() {
		boolean yesWin = false;
		if(towerStack[0].isEmpty() &&  towerStack[1].isEmpty() && getSizeStack(towerStack[2]) == numberOfBlocks) {
			yesWin = true;
			t.stop();
		}
		return yesWin;
	}	
 }