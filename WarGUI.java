import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
    private War war;
    private JPanel panel = new JPanel();
    private int p1Size = 26;
    private int p2Size = 26;
    private int ng = 1;
    private int currentLeader, numTurns;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label11, label12;
    private JButton button9,button10, button11;
    private ImageIcon back = new ImageIcon("cardPics/back.jpg");
    private ImageIcon blank = new ImageIcon("cardPics/blank.jpg");
    private ImageIcon none = new ImageIcon("cardPics/none.jpg");
    private int pw = 0; //0 = normal hand 1 = war
    private String c1,c2;
    private Card cWar1, cWar2;
    private int debug = 1; //variable to turn on and off debugging easily

    public WarGUI()
    {
        int warOn = 1;
        int winner = 0;
        war = new War();
        war.freshGame();
        
        panel.setLayout(new GridLayout(2,6,2,2));
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
        label7 = new JLabel("P1 remaining:");
        label8 = new JLabel("current leader:");
        button9 = new JButton("turns so far:");
        button10 = new JButton("next turn");
        label11 = new JLabel("This round's winner: ");
        label12 = new JLabel("p2 cards remaining: " + p2Size);

        //button10.setActionCommand("nextTurn");
        button10.addActionListener(new PlayRound());


        panel.add(label1);
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
                            cWar1 = war.getCard(1);
                            cWar2 = war.getCard(2);
                            if (debug == 1) System.out.println("cwar1: "+cWar1.toString()+" cwar2: "+ cWar2.toString());
                    }

                    //panel.remove(label12);
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
                            pw = 1; 
                            ng = 0;
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
                    //panel.add(label12);
                }
                catch (QueueException we)
                {
                    label1.setText("Game");
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

    public static void main(String[] args)
    {

        WarGUI war = new WarGUI();
    }
}
