//Alex DiSanto
//cs110
//half stack tester
public class halfStacksTest
{
    public static void main(String [] args)
    {
        HalfStacks h1 = new HalfStacks();
        h1.newDecks();
        h1.shuffle();
        System.out.println(h1.toString(1));
        System.out.println(" ");
        System.out.println(h1.toString(2));

        h1.shuffle();
        System.out.println(h1.toString(1));
        System.out.println(" ");
        System.out.println(h1.toString(2));
        
        h1.newDecks();
        h1.player1play();
        System.out.println(h1.toString(1));
    }
}
