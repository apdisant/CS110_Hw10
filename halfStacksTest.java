import java.util.Scanner;
//Alex DiSanto
//cs110
//half stack tester also includes first working attempt at a game of war
public class halfStacksTest
{
    public static void main(String [] args)
    {
        int r = 1;
        int w = 0;
        HalfStacks h1 = new HalfStacks();
        h1.newDecks();

        Card c1 = ((Card)h1.player1play());
        h1.player2addCard(c1);
        System.out.println(c1.toString());
        c1 = h1.player1play();
        h1.player2addCard(c1);
        c1 = h1.player1play();
        h1.player2addCard(c1);
        System.out.println(h1.checkSize(2));
        System.out.println(h1.toString(2));
        System.out.println(" ");
        //System.out.println(h1.toString(2));

        System.out.println(h1.checkSize(1));
        System.out.println(h1.toString(1));
        System.out.println(" ");
        //System.out.println(h1.toString(2));
        
        /*
        
        //War game test
        while (r == 1)
        {
            Card c1 = h1.player1play();
            Card c2 = h1.player2play();

            System.out.println(" ");
            System.out.println(c1.toString());
            System.out.println(c2.toString());

            if (c1.getRank() > c2.getRank())
            {
                System.out.println("Player 1 wins");
                h1.player1addCard(c2);
            }
            else if (c1.getRank() < c2.getRank())
            {
                System.out.println("Player 2 wins");
                h1.player2addCard(c1);
            }
            else 
            {
                System.out.println("war");
            }

            //Scanner sc = new Scanner(System.in);
            //while(!sc.nextLine().equals(""));

            if (h1.isEmpty(1))
            {
                r = 0;
                w = 2;
            }

            System.out.println(r + " " + w);
            
            if (h1.isEmpty(2))
            {
                r = 0;
                w = 1;
            }

            System.out.println(r + " " + w);
        }
        
        if (w == 1)
        {
            System.out.println("Player 1 wins");
        }
        else if (w == 2)
        {
            System.out.println("Player 2 wins");
        }
        else
        {
            System.out.println("error");
        }
        /*
        while (r ==1)
        {
            h1.player1play();
            if (h1.isEmpty(1))
                System.out.println("1 empty");
            h1.player2play();
            if (h1.isEmpty(2))
                System.out.println("2 empty");
        }
        */
    }
}
