/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iman
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Stack;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.BasicStroke;

public class Tower extends JPanel implements MouseListener, MouseMotionListener{
    //MouseListener handles events when mouse is not in motion
    //MouseMotionListener handles events when the mouse is in motion
    private Stack<Rectangle2D.Double> towerStack[]= new Stack[3];
    private Stack<Color> colorOfDisk[] = new Stack[3];
    static final int panelWidth = 700;
    static final int panelHeight = 500; 
    public Tower() {
        init(5);
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        
    }
    
    public void init(int n) {
        towerStack[0] = new Stack<>(); //disks at first pole
//        towerStack[1] = new Stack<Rectangle2D.Double>(); //disks at second pole
//        towerStack[2] = new Stack<Rectangle2D.Double>(); //disks at third pole

        colorOfDisk[0] = new Stack<>(); //colors of disks for first pole
        colorOfDisk[1] = new Stack<>(); //colors of disks for second pole
        colorOfDisk[2] = new Stack<>(); //colors of disks for third pole
        Color diskColors[] = {Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.GRAY, Color.RED, 
            Color.DARK_GRAY,Color.CYAN, Color.BLUE, Color.GREEN,Color.MAGENTA}; //list of colors for disks
       
        
        for (int i = 0; i < n; i++) {
            Rectangle2D.Double rec = new Rectangle2D.Double();
            
            double x = panelWidth /6;	
            double y = panelHeight-100;
            if(x==0)
                x=150;
            double wr= n*25-20*i;
            System.out.println("wr: "+ wr);
            rec.setFrame (x-wr/2,(y - 27)-i*20,wr,20);
            towerStack[0].push(rec);
            colorOfDisk[0].push(diskColors[i]);
        }
        
        
    }
    @Override
    public void paintComponent(Graphics g) {
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
//        drawTower(g1,1);
//        drawTower(g1,2);
    }
    
    private void drawTower(Graphics2D g2, int n) {
        if (!towerStack[n].isEmpty()) {
            for (int i = 0; i < towerStack[n].size();i++) {
                g2.setColor(colorOfDisk[n].get(i));
                g2.fill(towerStack[n].get(i));
                g2.draw(towerStack[n].get(i));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int px = me.getX();
        int py = me.getY();
        System.out.println("Point clicked on is " + px + " " + py);
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Point p = me.getPoint();
        System.out.println("Point clicked on is " + p);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
