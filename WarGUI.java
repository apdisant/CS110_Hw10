import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
    private JPanel panel = new JPanel();
    private int p1Size = 26;
    private int p2Size = 26;
    private int currentLeader;
    private int numTurns;
    private War war;

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

        buildPanel();

        add(panel);
        setVisible(true);
    }

    public void buildPanel()
    {
        String b = "cardPics/back.jpg";
        String c1 = "cardPics/2h.jpg";
        String c2 = "cardPics/2s.jpg";

        ImageIcon back = new ImageIcon(b);
        ImageIcon card1 = new ImageIcon(c1);
        ImageIcon card2 = new ImageIcon(c2);

        JLabel label1 = new JLabel("",back,JLabel.LEFT);
        JLabel label2 = new JLabel("");
        JLabel label3 = new JLabel("",card1,JLabel.CENTER);
        JLabel label4 = new JLabel("",card2,JLabel.CENTER);
        JLabel label5 = new JLabel("");
        JLabel label6 = new JLabel("",back,JLabel.CENTER);
        JLabel label7 = new JLabel("P1 remaining:");
        JLabel label8 = new JLabel("current leader:");
        JLabel label9 = new JLabel("turns so far:");
        JButton button10 = new JButton("next turn");
        JLabel label11 = new JLabel("auto run");
        JLabel label12 = new JLabel("p2 cards remaining: " + p2Size);

        button10.setActionCommand("nextTurn");

        button10.addActionListener(new PlayRound());

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(button10);
        panel.add(label11);
        panel.add(label12);
    }

    private class PlayRound implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() instanceof JButton)
            {
                if (war.checkWinner() > 0)
                {
                }
                else
                {
                    war.playHand();
                    p1Size = war.checkSize(1);
                    p2Size = war.checkSize(2);
                }
            }
        }
    }

    public static void main(String[] args)
    {

        WarGUI war = new WarGUI();
    }
}
