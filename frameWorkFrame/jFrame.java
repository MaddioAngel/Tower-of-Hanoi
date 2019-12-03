
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.util.Random;

public class jFrame extends JFrame{
    private JPanel backPanel = new JPanel();
    private JPanel infoScreem = new JPanel();
    private JPanel userScreen = new JPanel();
    private JPanel Welcome = new JPanel();
    private JPanel HistoryScreen = new JPanel();
    private JPanel gameScreen = new JPanel();

    private JLabel welcomeLabel = new JLabel("WELCOME to Tower Of Hanoi");
    private JButton welcomeButton1 = new JButton("Switch to Welcome"); // User button
    private JButton welcomeButton2 = new JButton("Switch to Welcome"); // History button
    private JButton welcomeButton3 = new JButton("Switch to Welcome"); // Info button
    private JButton backToOptions = new JButton("Switch back to Game Modes");

    private JButton infoButton = new JButton("Info");
    private JButton historyButton = new JButton("History");
    private JButton userButton = new JButton("Start!");

    private JButton normal = new JButton("Classic Mode");
    private JButton randomMode = new JButton("Random Mode");
    private JButton computer = new JButton("Watch the Computer");
    private JButton comVSpLayer = new JButton("Computer vs Player");

    private JLabel numBlockLabel = new JLabel("  Set the number of blocks: ");
    private SpinnerNumberModel numOfblocksModel = new SpinnerNumberModel(1, 1, 12, 1);
    private JSpinner numOfblocks = new JSpinner(numOfblocksModel);

    JPanel containerMain = new JPanel();
    JPanel containerSettings = new JPanel();
    JPanel container = new JPanel();

    // int numOfLives = 5;
    // JLabel NumberOfLivesLabel = new JLabel(" "+ numOfLives);

    private CardLayout cl = new CardLayout();

    public jFrame() {
        super("Tower of Hanoi");
        backPanel.setLayout(cl);
        add(backPanel);

        backPanel.add(Welcome, "welcome");
        backPanel.add(infoScreem, "info");
        backPanel.add(userScreen, "user");
        backPanel.add(HistoryScreen, "history");
        backPanel.add(gameScreen, "game");

        JLabel backgroundInfo = setBackgroundIH(infoScreem, "Rules.jpg");
        backgroundInfo.add(welcomeButton3);
        Color pink = new Color(254, 219, 222);

        infoScreem.setBackground(pink);

        JLabel backgroundHistory = setBackgroundIH(HistoryScreen, "History.jpg");
        backgroundHistory.add(welcomeButton2);
        Color white = Color.WHITE;

        HistoryScreen.setBackground(white);

        JLabel backgroundTower = setBackgroundMain(Welcome, "Tower.png");
        welcomeLabel.setForeground(new Color(255, 255, 255));

        backgroundTower.add(welcomeLabel);
        backgroundTower.add(userButton);
        backgroundTower.add(historyButton);
        backgroundTower.add(infoButton);

        cl.show(backPanel, "welcome");

        welcomeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(backPanel, "welcome");
            }
        });
        welcomeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(backPanel, "welcome");
            }
        });
        welcomeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(backPanel, "welcome");
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(backPanel, "info");
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(backPanel, "history");
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BorderLayout border = new BorderLayout();
                userScreen.setLayout(border);
                userScreen.add(welcomeButton1, border.NORTH);

                Color purple = new Color(128, 0, 128);

                userScreen.setBackground(purple);
                numBlockLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
                numBlockLabel.setPreferredSize(new Dimension(250, 100));
                numBlockLabel.setForeground(new Color(255, 255, 255));


                containerMain.setBackground(purple);
                containerMain.setLayout(new GridLayout(2, 2));
                containerMain.add(normal);
                containerMain.add(randomMode);
                containerMain.add(computer);
                containerMain.add(comVSpLayer);

                containerSettings.setBackground(purple);
                containerSettings.setLayout(new GridLayout(1, 3));
                containerSettings.add(numBlockLabel);
                containerSettings.add(numOfblocks);

                BorderLayout border2 = new BorderLayout();
                container.setLayout(border2);

                container.add(containerMain, border2.CENTER);
                container.add(containerSettings, border2.NORTH);

                userScreen.add(container, border.CENTER);

                cl.show(backPanel, "user");

            }
        });

        backToOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                gameScreen.removeAll();

                cl.show(backPanel, "user");
            }
        });

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BorderLayout border = new BorderLayout();
                int num = (int) numOfblocks.getValue();
                gameScreen.setLayout(border);
                userTower t = new userTower(num);

                gameScreen.add(backToOptions, border.NORTH);
                cl.show(backPanel, "game");
                JPanel gameContainer = new JPanel();
                gameContainer.setSize(700, 500);
                gameContainer.add(t);

                gameScreen.add(gameContainer, BorderLayout.CENTER);

            }
        });

        randomMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BorderLayout border = new BorderLayout();
                gameScreen.setLayout(border);
                gameScreen.add(backToOptions, border.NORTH);

                cl.show(backPanel, "game");
                Random rand = new Random();
                int randnum = 1 + rand.nextInt(12);
                
                userTower t = new userTower(randnum);
        
                JPanel gameContainer = new JPanel();
                gameContainer.setSize(700, 500);
                gameContainer.add(t);
                gameScreen.add(gameContainer, border.CENTER);
            }});

        computer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int num = (int) numOfblocks.getValue();
                BorderLayout border = new BorderLayout();
                gameScreen.setLayout(border);
                gameScreen.add(backToOptions, border.NORTH);

                JPanel gameContainer = new JPanel();
                gameContainer.setSize(700, 500);
                gameContainer.setLayout(new GridLayout(1, 2));

                ComHanoi t2 = new ComHanoi(num);

                gameContainer.add(t2);

                gameScreen.add(gameContainer, border.CENTER);

                cl.show(backPanel, "game");
            }
        });

        comVSpLayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int num = (int) numOfblocks.getValue();
                BorderLayout border = new BorderLayout();
                gameScreen.setLayout(border);
                gameScreen.add(backToOptions, border.NORTH);

                JPanel gameContainer = new JPanel();
                gameContainer.setSize(1400, 500);
                gameContainer.setLayout(new GridLayout(1, 2));

                userTower t = new userTower(num);
                ComHanoi t2 = new ComHanoi(num);

                gameContainer.add(t);
                gameContainer.add(t2);

                gameScreen.add(gameContainer, border.CENTER);

                cl.show(backPanel, "game");
            }
        });

    }

    public static JLabel setBackgroundMain(JPanel panel, String backgroundFilePath) {
        panel.setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon(backgroundFilePath);
        Image image = img.getImage(); // transform it
        Image newimg = image.getScaledInstance(1400, 700, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon imageResized = new ImageIcon(newimg); // transform it back
        JLabel background = new JLabel(imageResized);
        panel.add(background);
        background.setLayout(new FlowLayout(0));
        return background;
    }

    public static JLabel setBackgroundIH(JPanel panel, String backgroundFilePath) {
        panel.setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon(backgroundFilePath);
        Image image = img.getImage(); // transform it
        Image newimg = image.getScaledInstance(800, 800, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon imageResized = new ImageIcon(newimg); // transform it back
        JLabel background = new JLabel(imageResized);
        panel.add(background);
        background.setLayout(new FlowLayout(0));
        return background;
    }
}
