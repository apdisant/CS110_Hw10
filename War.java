//Alex DiSanto
//CS110
//Guts of card game war
public class War extends HalfStacks
{
    private int w = 0;
    private boolean console = true;
    private HalfStacks h1 = new HalfStacks();
    

    public void War()
    {
        h1.newDecks();
    }

    public void playHand()
    {
        Card c1 = h1.player1play();
        Card c2 = h1.player2play();

        if (console)
        {
            System.out.println(" ");
            System.out.println("player 1's card: " + c1.toString());
            System.out.println("player 2's card: " + c2.toString());
        }

        if (c1.getRank() > c2.getRank())
        {
            if (console) System.out.println("Player 1 wins");
            h1.player1addCard(c2);
        }
        else if (c1.getRank() < c2.getRank())
        {
            if (console) System.out.println("Player 2 wins");
            h1.player2addCard(c1);
        }
        else
        {
            if (console) System.out.println("war");
            this.playWar(c1,c2);
        }
    }

    public int checkWinner();
    {
        if (h1.isEmpty(1))
        {
            w = 2;
        } 

        if (h1.isEmpty(2))
        { 
            w = 1;
        }
        return w;
    }

    public int playWar(Card c1, Card c2);
    {
        Card down1 = h1.player1play();
        Card down2 = h1.player2play();

        this.checkWinner();

        Card up1 = h1.player1play();
        Card up2 = h1.player2play();



