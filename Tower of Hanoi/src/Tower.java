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
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.geom.RoundRectangle2D;

public class Tower extends JPanel implements MouseListener, MouseMotionListener{
    //MouseListener handles events when mouse is not in motion
    //MouseMotionListener handles events when the mouse is in motion
    private Stack<RoundRectangle2D.Double> towerStack[]= new Stack[3];
    private Stack<Color> colorStack[] = new Stack[3];
    static final int panelWidth = 700;
    static final int panelHeight = 500; 
    static final Color lightRed = new Color(255,102,102);
    static final Color lightOrange = new Color(255,153,0);
    static final Color lightBlue = new Color(51,204,255);
    static final Color lightGreen = new Color(102,255,102);
    RoundRectangle2D.Double t;
    boolean diskPressed = false;
    private Double prevPointX;
    private Double prevPointY;
    public int numOfDisks;
    Color c;
    int tx, ty;
    
    public Tower(int n) {
        init(n);
        numOfDisks = n;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        addMouseListener(this);
        addMouseMotionListener(this);
    } 
    
    public void init(int n) {
        towerStack[0] = new Stack<>(); //disks at first pole
        towerStack[1] = new Stack<>(); //disks at second pole
        towerStack[2] = new Stack<>(); //disks at third pole

        colorStack[0] = new Stack<>(); //colors of disks for first pole
        colorStack[1] = new Stack<>(); //colors of disks for second pole
        colorStack[2] = new Stack<>(); //colors of disks for third pole
        Color diskColors[] = {lightOrange, lightBlue, lightRed, lightGreen, Color.MAGENTA, Color.ORANGE, Color.GRAY, Color.RED, 
            Color.DARK_GRAY,Color.CYAN, Color.BLUE, Color.yellow, Color.MAGENTA}; //list of colors for disks
       
        for (int i = 0; i < n; i++) {
            RoundRectangle2D.Double rec = new RoundRectangle2D.Double();
            double x = panelWidth /6;	
            double y = panelHeight-100;
            if(x==0)
                x=150;
            double wr= n*25-20*i;
//            rec.setFrame(x-wr/2,(y - 27)-i*20,wr,20);
            rec.setRoundRect(x-wr/2, (y - 27)-i*20, wr, 20, 25,25);
            towerStack[0].push(rec);
            colorStack[0].push(diskColors[i]);
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
        
//        g1.setColor(lightRed);
//        g1.drawLine(0, 0, panelWidth/3, panelHeight);
//        g1.drawLine(panelWidth/3, 0, 2*panelWidth/3, panelHeight);
//        g1.drawLine(2*panelWidth/3, 0, panelWidth, panelHeight);
        
        g1.setStroke(new BasicStroke(1));
        
        drawTower(g1,0);
        drawTower(g1,1);
        drawTower(g1,2);
    }
    
    private void drawTower(Graphics2D g2, int n) {
        if (!towerStack[n].isEmpty()) {
            for (int i = 0; i < towerStack[n].size();i++) {
                g2.setColor(colorStack[n].get(i));
                g2.fill(towerStack[n].get(i));
//                g2.draw(towerStack[n].get(i));
            }
        }
    }

    private int getCurrentTower(Point p) {
       RoundRectangle2D.Double r1 = new RoundRectangle2D.Double();
       RoundRectangle2D.Double r2 = new RoundRectangle2D.Double();
       RoundRectangle2D.Double r3 = new RoundRectangle2D.Double();
       
       r1.setFrame(0, 0, panelWidth/3, panelHeight);
       r2.setFrame(panelWidth/3, 0,  panelWidth/3, panelHeight);
       r3.setFrame(2*panelWidth/3, 0, panelWidth/3, panelHeight);
       
       if (r1.contains(p))
            return 0;
       else if (r2.contains(p))
            return 1;
       else if (r3.contains(p))
            return 2;
       else 
           return -1;
    }
//    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Point p = me.getPoint();
        int n = getCurrentTower(p);
//        if (!towerStack[n].isEmpty()){
            t = towerStack[n].peek();
            if (t.contains(p)) {
                System.out.println(n + "(before) : " +towerStack[n]);
                t = towerStack[n].pop();
                c = colorStack[n].pop();
                System.out.println(n + "(after) : " +towerStack[n]);
                diskPressed = true;
                prevPointX = p.getX() - t.getX();
                prevPointY = p.getY()-t.getY();
                tx = (int) p.getX();
                ty = (int) p.getY();
//        }
        }
    }

     @Override
    public void mouseDragged(MouseEvent me) {
        double dx; //diff between previous point's x location and current point's x location
        double dy;
        if(diskPressed) {
            dx = me.getX()- prevPointX; 
            dy = me.getY()-prevPointY;
            t.setFrame(dx, dy, t.getWidth(),t.getHeight());
            repaint();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent me) { 
//        RoundRectangle2D.Double t = towerStack[0].peek();
        int n = getCurrentTower(me.getPoint());
        double x,y;
        if (!towerStack[n].isEmpty()) {
            if (towerStack[n].peek().getWidth() > t.getWidth()){
                   y = towerStack[n].peek().getY()-20;
            }
            else {
                System.out.println("Wrong move");
                n = getCurrentTower(new Point(tx, ty));
                if(!towerStack[n].isEmpty()) {
                    y = towerStack[n].peek().getY()-20;
                }
                else {
                 y = getHeight() - 98;
                }
            }   
        }
        else {
            y = getHeight()-98;
        }
        System.out.println(n + "(released): " +towerStack[n]);
        x = panelWidth / 6;
        int i = 2*n + 1;
        x = x * i;
        t.setFrame(x -t.getWidth()/2,y,t.getWidth(),t.getHeight());
        towerStack[n].push(t);
        colorStack[n].push(c);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
