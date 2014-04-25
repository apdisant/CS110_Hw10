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
        War war = new War();
        war.freshGame();

        /*
        war.playHand();
        String s1 = war.toString(1);
        String s2 = war.toString(2);
        System.out.println("1: " + s1 + "\n 2: " + s2);

        war.playHand();
        s1 = war.toString(1);
        s2 = war.toString(2);
        System.out.println("1: " + s1 + "\n 2: " + s2);

        war.playHand();
        s1 = war.toString(1);
        s2 = war.toString(2);
        System.out.println("1: " + s1 + "\n 2: " + s2);

        */
        while(r == 1)
        {
            war.playHand();
            //String s1 = war.toString(1);
            //String s2 = war.toString(2);
            //System.out.println("1: " + s1 + "\n 2: " + s2);
            Scanner sc = new Scanner(System.in);
            while(!sc.nextLine().equals(""));
        }
    }
}

