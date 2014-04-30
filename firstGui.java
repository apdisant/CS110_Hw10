import javax.swing.*;
import java.awt.*;

public class firstGui
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Fuck dis");
        frame.setLayout(new GridLayout(1,4,2,2));

        String img = "cardPics/back.jpg";
        String img2 = "cardPics/aces.jpg";

        ImageIcon image = new ImageIcon(img);
        ImageIcon image2 = new ImageIcon(img2);

        JLabel label = new JLabel("",image2,JLabel.CENTER);
        frame.add(label);

        JLabel label3 = new JLabel("player1",JLabel.CENTER);
        frame.add(label3);

        JLabel label4 = new JLabel("player2",JLabel.CENTER);
        frame.add(label4);

        JLabel label2 = new JLabel("",image,JLabel.CENTER);
        frame.add(label2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.pack();
        //frame.setSize(200,200);
        //frame.setResizable(false);
        frame.validate();
    }
}
