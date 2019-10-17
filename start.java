import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame{
    private JPanel backPanel = new JPanel();
    private JPanel firstPanel = new JPanel();
    private JPanel secondPanel = new JPanel();
    private JButton button1 = new JButton("Switch to panel 2");
    private JButton button2 = new JButton("Switch to panel 1");
    CardLayout cl = new CardLayout();
    public start(){
        super("Switch");
        backPanel.setLayout(cl);
        add(backPanel);
        backPanel.add(firstPanel,"1");
        backPanel.add(secondPanel, "2");
        firstPanel.add(button1);
        secondPanel.add(button2);
        button1.setBounds(100,100,140, 40);
        firstPanel.setBackground(Color.BLUE);
        secondPanel.setBackground(Color.PINK);

        cl.show(backPanel, "1");

        button1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"2");
            }
          } );
        button2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
              cl.show(backPanel,"1");}
          } );

		}     

}