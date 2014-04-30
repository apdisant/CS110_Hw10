import java.util.Scanner;
//Alex DiSanto
//cs110
//war game tester (console)
public class warTester
{
    public static void main(String [] args)
    {
        int r = 1;
        int w = 0;
        War war = new War();//start game of war
        war.freshGame();
        war.setConsole();

        try
        {
            while(r == 1)
            {
                war.playHand(); //play hand of war, will decide to play a war or not on it's own
                //String s1 = war.toString(1);
                //String s2 = war.toString(2);
                //int s1 = war.checkSize(1);
                //int s2 = war.checkSize(2);
                //System.out.println("1: " + s1 + "\n 2: " + s2);
                Scanner sc = new Scanner(System.in);
                while(!sc.nextLine().equals(""));
            }
        }
        catch (QueueException e) //if either stack ever tries to draw a card with no cards in queue
        {
            System.out.println("***************************");
            System.out.println("Game Over");
            System.out.println("***************************");
            int winner = war.checkWinner();
            if(winner == 1)
            {
                System.out.println("player 1 wins");
            }
            else if (winner == 2)
            {
                System.out.println("player 2 wins");
            }
            else System.out.println("error");
        }
    }
}
