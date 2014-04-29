import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
    private War war;
    private JPanel panel = new JPanel();
    private int p1Size = 26;
    private int p2Size = 26;
    private int currentLeader;
    private int numTurns;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label12;
    private JButton button9,button10, button11;
    private String b,c1,c2;

    public WarGUI()
    {
        int warOn = 1;
        int winner = 0;
        war = new War();
        war.freshGame();
        
        panel.setLayout(new GridLayout(2,6,2,2));
        setTitle("War!");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = "cardPics/back.jpg";
        c1 = "cardPics/"+war.getCardPic(1);
        c2 = "cardPics/2s.jpg";

        ImageIcon back = new ImageIcon(b);
        ImageIcon card1 = new ImageIcon(c1);
        ImageIcon card2 = new ImageIcon(c2);


        label1 = new JLabel("",back,JLabel.LEFT);
        label2 = new JLabel("");
        label3 = new JLabel("",card1,JLabel.CENTER);
        label4 = new JLabel("",card2,JLabel.CENTER);
        label5 = new JLabel("");
        label6 = new JLabel("",back,JLabel.CENTER);
        label7 = new JLabel("P1 remaining:");
        label8 = new JLabel("current leader:");
        button9 = new JButton("turns so far:");
        button10 = new JButton("next turn");
        button11 = new JButton("auto run");
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
        panel.add(button11);
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
                if (war.checkWinner() > 0)
                {
                }
                else
                {
                    //panel.remove(label12);
                    war.playHand();
                    p1Size = war.checkSize(1);
                    p2Size = war.checkSize(2);
                    label7.setText("p1 cards remaining:\n" + p1Size);
                    label12.setText("p2 cards remaining:\n" + p2Size);
                    c1 = "cardPics/"+war.getCardPic(1);
                    ImageIcon card1 = new ImageIcon(c1);
                    label3.setIcon(card1);
                    c2 = "cardPics/"+war.getCardPic(2);
                    ImageIcon card2 = new ImageIcon(c2);
                    label4.setIcon(card2);
                    //panel.add(label12);
                }
            }
        }
    }

    public static void main(String[] args)
    {

        WarGUI war = new WarGUI();
    }
}
