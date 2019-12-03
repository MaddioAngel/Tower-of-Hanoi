/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iman
*/
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
//import java.awt.event.ActionListener;
////import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
//import javax.swing.BoxLayout;
//import java.awt.Component;
import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

public final class ComboBox extends JPanel {
 Integer[] num = new Integer[]{3,4,5,6,7,8,9,10,11,12};
    JComboBox comboBox = new JComboBox<>(num);
    JPanel p = new JPanel();
    
    public ComboBox() {
        p.setLayout(null);
	p.setBounds(0, 0,125, 50);
        p.setBackground(Color.BLUE);
        comboBox.setBounds(15,15,100,25);
        p.add(comboBox);
        add(p);
        towerActionListener();
        
    }
    
      public void towerActionListener() {
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox comboBox = (JComboBox) ae.getSource();
            Object selected = comboBox.getSelectedItem();
            System.out.println("Select item " + selected);
        }
        });
    
    }
    
//        JPanel p = new JPanel();
//        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
//        frame.add(p);
//        
//        JLabel l = new JLabel("Number of disks");
//        l.setAlignmentX(Component.CENTER_ALIGNMENT);
//        p.add(l);
//        
//        Integer[] numOfDisks = {3,4,5,6,7,8,9,10,11,12};
//       
//        final JComboBox<Integer> cb = new JComboBox<>(numOfDisks);
//        cb.setMaximumSize(cb.getPreferredSize());
//        p.add(cb);
//        
//        JButton btn = new JButton("Ok");
//        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
//        p.add(btn);
}
