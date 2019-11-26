/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iman
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.Component;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setSize(700, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        frame.add(p);
        
        JLabel l = new JLabel("Number of disks");
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(l);
        
        Integer[] numOfDisks = {3,4,5,6,7,8,9,10,11,12};
       
        final JComboBox<Integer> cb = new JComboBox<>(numOfDisks);
        cb.setMaximumSize(cb.getPreferredSize());
        p.add(cb);
        
        JButton btn = new JButton("Ok");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(btn);
        
        Tower t = new Tower(3);
      
        frame.getContentPane().add(t);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
//    public int numberOfLevel() {
//      
//    }
    
}
