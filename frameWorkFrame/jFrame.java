
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.BorderLayout;

public class jFrame extends JFrame{
    private JPanel backPanel = new JPanel();
    private JPanel infoScreem = new JPanel();
    private JPanel userScreen = new JPanel();
    private JPanel Welcome = new JPanel();
    private JPanel HistoryScreen = new JPanel();
    
    private JLabel welcomeLabel = new JLabel("WELCOME");
    private JButton welcomeButton1 = new JButton("Switch to Welcome");
    private JButton welcomeButton2 = new JButton("Switch to Welcome");
    private JButton welcomeButton3 = new JButton("Switch to Welcome");
    
    private JLabel logInUserLabel = new JLabel("User:");
    private JFormattedTextField logInUserField = new JFormattedTextField();
    private JLabel logInPasswordLabel = new JLabel("Password:");
    private JPasswordField logInPasswordField = new JPasswordField();
    
    private JButton infoButton = new JButton("INFO");
    private JButton historyButton = new JButton("History");
    private JButton userButton = new JButton("Log In");
    
    private JTextArea HistoryText = new JTextArea("The Tower of Hanoi (also called the Tower of Brahma or Lucas' Tower and sometimes pluralized as Towers) is a mathematical game or puzzle. \nIt consists of three rods and a number of disks of different sizes, which can slide onto any rod. \nThe puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.\n\nThe objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:\n\nOnly one disk can be moved at a time.\nEach move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.\nNo larger disk may be placed on top of a smaller disk.\nWith 3 disks, the puzzle can be solved in 7 moves.\n The minimal number of moves required to solve a Tower of Hanoi puzzle is 2n − 1, where n is the number of disks.\n\nThe puzzle was invented by the French mathematician Édouard Lucas in 1883. \nNumerous myths regarding the ancient and mystical nature of the puzzle popped up almost immediately. \nThese myths are recounted in The Tower of Hanoi - Myths and Maths. \n\nThere is a story about an Indian temple in Kashi Vishwanath which contains a large room with three time-worn posts in it, \nsurrounded by 64 golden disks. \nBrahmin priests, acting out the command of an ancient prophecy, \nhave been moving these disks in accordance with the immutable rules of Brahma since that time. \nThe puzzle is therefore also known as the Tower of Brahma puzzle. \nAccording to the legend, when the last move of the puzzle is completed, the world will end.\n\nIf the legend were true, and if the priests were able to move disks at a rate of one per second, \nusing the smallest number of moves it would take them 264 −\n 1 seconds or roughly 585 billion years to finish, which is about 42 times the current age of the Universe.\n\nThere are many variations on this legend. For instance, in some tellings the temple is a monastery, and the priests are monks. \nThe temple or monastery may be said to be in different parts of the world—including Hanoi, Vietnam—and may be associated with any religion. \nIn some versions other elements are introduced, such as the fact that the tower was created at the beginning of the world, \nor that the priests or monks may make only one move per day.");
    private JTextArea InfoText = new JTextArea("Rules:\n\nMove all of the blocks to the other peg\n\n1. Only move one block at a time\n\n2. A bigger block cannot go on a ");
    
    
    
    CardLayout cl = new CardLayout();
    
    
    
    public static Color VERY_LIGHT_GRAY = new Color(204,204,204);
    
    public jFrame(){
    	
        super("Tower of Hanoi");
        backPanel.setLayout(cl);
        add(backPanel);

        backPanel.add(Welcome,"welcome");
        backPanel.add(infoScreem, "info");
        backPanel.add(userScreen, "user");

        backPanel.add(HistoryScreen, "history");

        Welcome.setBackground(VERY_LIGHT_GRAY);
        infoScreem.setBackground(VERY_LIGHT_GRAY);
        userScreen.setBackground(VERY_LIGHT_GRAY);
        HistoryScreen.setBackground(VERY_LIGHT_GRAY);

        
        BorderLayout lay = new BorderLayout();
        userScreen.setLayout(lay);

        userScreen.add(welcomeButton1, BorderLayout.NORTH);
        

        
        GroupLayout layout2 = new GroupLayout(infoScreem);
        infoScreem.setLayout(layout2);
        InfoText.setEditable(false);
        
        layout2.setHorizontalGroup(
        		layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(InfoText, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addGroup(layout2.createSequentialGroup()
                            .addComponent(welcomeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
        layout2.setVerticalGroup(
        		layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(welcomeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(InfoText, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addContainerGap())
            );
        
        
        
        HistoryText.setEditable(false);
        
        GroupLayout layout1 = new GroupLayout(HistoryScreen);
        HistoryScreen.setLayout(layout1);
        layout1.setHorizontalGroup(
        		layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout1.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(HistoryText, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addGroup(layout1.createSequentialGroup()
                            .addComponent(welcomeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
        layout1.setVerticalGroup(
        		layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout1.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(welcomeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(HistoryText, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addContainerGap())
            );
        
        
        GroupLayout layout = new GroupLayout(Welcome);
        Welcome.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(244, 244, 244)
                    .addComponent(welcomeLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                    .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(userButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(logInPasswordLabel)
                                .addComponent(logInUserLabel))
                            .addGap(70, 70, 70)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(logInUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(logInPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(349, 349, 349))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(89, 89, 89)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logInUserLabel)
                        .addComponent(logInUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logInPasswordLabel)
                        .addComponent(logInPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addComponent(userButton)
                    .addContainerGap(291, Short.MAX_VALUE))
            );

        
        
        
        cl.show(backPanel, "welcome");

        welcomeButton1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"welcome");
              System.out.println("Changed");
            }
          } );
        welcomeButton2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"welcome");
            }
          } );
        
        welcomeButton3.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"welcome");
            }
          } );

          infoButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"info");}
          } );
          historyButton.addActionListener( new ActionListener() {
              @Override
              public void actionPerformed( ActionEvent arg0 ) {
                cl.show(backPanel,"history");}
            } );
          
          //log In
        userButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              if(isPasswordCorrect()) {
                ComHanoi panelCom = new ComHanoi(600, 400);
                ComHanoi panelCom2 = new ComHanoi(500, 400);
                

                userScreen.add(panelCom, BorderLayout.CENTER); 

                cl.show(backPanel,"user");

              }
              else {
            	  JOptionPane.showMessageDialog(Welcome,
            			    "Invald User name or password",
            			    "Error",
            			    JOptionPane.ERROR_MESSAGE);
              }
             }
          } ); 
       

		}
    public boolean isPasswordCorrect() {
    	
    	return true;
    }

}