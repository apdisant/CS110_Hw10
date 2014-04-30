import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Alex DiSanto
//cs110
//hw10 War gui class and tester
//Just a warning if you play hands too fast it will mess up the number of cards output but should not mess up the actual game
/**This class runs a game of war using the War class in a GUI
 */
public class WarGUI extends JFrame
{
    private War war;
    private JPanel panel = new JPanel(); // initiate GUI main panel
    private int p1Size = 26; // set starting deck sizes
    private int p2Size = 26;
    private int ng = 1; // variable for war grab cards or not
    private int currentLeader, numTurns; // variables self explanatory
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label11, label12; //init labels
    private JButton button9,button10, button11; // init buttons
    private ImageIcon back = new ImageIcon("cardPics/back.jpg"); // init images
    private ImageIcon blank = new ImageIcon("cardPics/blank.jpg");
    private ImageIcon none = new ImageIcon("cardPics/none.jpg");
    private int pw = 0; //0 = normal hand 1 = war
    private String c1,c2; 
    private Card cWar1, cWar2; // cards for war
    private int debug = 1; //variable to turn on and off debugging easily

    public WarGUI()
    {
        int warOn = 1;
        int winner = 0;
        war = new War(); // start the game
        war.freshGame();
        
        panel.setLayout(new GridLayout(2,6,2,2)); // set up GUI
        panel.setBackground(Color.white);
        setTitle("War!");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("",back,JLabel.LEFT);
        label2 = new JLabel("");
        label3 = new JLabel("",blank,JLabel.CENTER);
        label4 = new JLabel("",blank,JLabel.CENTER);
        label5 = new JLabel("");
        label6 = new JLabel("",back,JLabel.CENTER);
        label7 = new JLabel("P1 remaining: " + p1Size);
        label8 = new JLabel("current leader:");
        button9 = new JButton("Next Turn");
        button10 = new JButton("New Game");
        label11 = new JLabel("This round's winner: ");
        label12 = new JLabel("p2 remaining: " + p2Size);

        button9.addActionListener(new PlayRound()); //make buttons work
        button10.addActionListener(new NewGame());

        panel.add(label1); //add labels and buttons to the gui screen
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(button9);
        panel.add(button10);
        panel.add(label11);
        panel.add(label12);
        this.getContentPane().add(panel);
        pack();

        add(panel);
        setVisible(true);
    }

    /**
     * The PlayRound class plays a round of the game of war
     */
    private class PlayRound implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() instanceof JButton)
            {
                //JButton b = (JButton)(e.getSource());
                try 
                {
                    c1 = "cardPics/"+war.getCardPic(1); //display card pictures
                    ImageIcon card1 = new ImageIcon(c1);
                    label3.setIcon(card1);
                    c2 = "cardPics/"+war.getCardPic(2);
                    ImageIcon card2 = new ImageIcon(c2);
                    label4.setIcon(card2);
                    label2.setIcon(blank);
                    label5.setIcon(blank);

                    if (ng == 1)
                    {
                            cWar1 = war.getCard(1); //read top card for war
                            cWar2 = war.getCard(2);
                            if (debug == 1) System.out.println("cwar1: "+cWar1.toString()+" cwar2: "+ cWar2.toString());
                    }

                    if (pw == 0)
                    {
                        int hw = war.playHand(); //play round of war
                        if (hw == 1)
                        {
                            label11.setText("This round's winner: P1");
                        }
                        else if (hw == 2)
                        {
                            label11.setText("This round's winner: P2");
                        }
                        else if (hw == 3)
                        {
                            label11.setText("War!!!");
                            pw = 1; //play war set
                            ng = 0; //do not re grab top cards as they are new now
                        }
                    }
                    else if (pw == 1)
                    {
                        label2.setIcon(back);
                        label5.setIcon(back);
                        int hw = war.playWar(cWar1, cWar2);
                            if (hw == 1)
                            {
                                label11.setText("This war's winner: P1");
                                pw = 0;
                                ng = 1;
                            }
                            else if (hw == 2)
                            {
                                label11.setText("This war's winner: P2");
                                pw = 0;
                                ng = 1;
                            }
                            else if (hw == 3)
                            {
                                label11.setText("War!!! again!!!");
                                pw = 1; 
                                ng = 1;
                                war.warFixer();
                            }
                            if (debug == 1) System.out.println(war.toString(1));
                            if (debug == 1) System.out.println(war.toString(2));
                    }

                    p1Size = war.checkSize(1); //display size of both decks
                    p2Size = war.checkSize(2);
                    if (debug == 1) System.out.println("p1: "+p1Size+" p2: "+p2Size);
                    label7.setText("p1 cards remaining:\n" + p1Size);
                    label12.setText("p2 cards remaining:\n" + p2Size);
                    if (p1Size > p2Size) label8.setText("Current leader: p1");
                    else if (p2Size > p1Size) label8.setText("Current leader: p2"); 
                    else label8.setText("The game is a tie");
                    //panel.add(label12);
                }
                catch (QueueException we)
                {
                    label1.setText("Game"); //clear board and display game over message
                    label1.setIcon(none);
                    label2.setText("Over");
                    label2.setIcon(none);
                    label3.setText("The");
                    label3.setIcon(none);
                    label4.setText("Winner");
                    label4.setIcon(none);
                    label5.setText("is");
                    label5.setIcon(none);
                    label6.setIcon(none);
                    int winner = war.checkWinner();
                    if (winner == 1) label6.setText("Player 1!");
                    if (winner == 2) label6.setText("Player 2!");
                }
            }
        }
    }
    /*
     * The new game class starts a new game of war in the GUI
     */
    private class NewGame implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            war.freshGame();
            label1.setIcon(back);
            label2.setIcon(blank);
            label3.setIcon(blank);
            label4.setIcon(blank);
            label5.setIcon(blank);
            label6.setIcon(back);
            p1Size = 26;
            p2Size = 26;
            label12.setText("p2 remaining: " + p2Size);
            label7.setText("p1 remaining: " + p1Size);
        }
    }

    public static void main(String[] args)
    {

        WarGUI war = new WarGUI();
    }
}
