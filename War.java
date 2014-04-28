//Alex DiSanto
//CS110
//Guts of card game war
public class War extends HalfStacks
{
    private int w = 0;
    private boolean console = true;
    private HalfStacks h1 = new HalfStacks();
    
    public void freshGame()
    {
        h1.newDecks();
    }

    public void playHand()
    {
        //Card c1 = h1.player1play();
        //Card c1 = h1.player1play();
        Card c1 = ((Card)this.h1.p1Queue.dequeue());
        Card c2 = ((Card)this.h1.p2Queue.dequeue());
        int hw = this.compareHands(c1,c2);
        //System.out.println("hw: " + hw);
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
            h1.player1addCard(c1);
            hw = 1;
        }
        else if (c1.getRank() < c2.getRank())
        {
            if (console) System.out.println("Player 2 wins");
            h1.player2addCard(c1);
            h1.player2addCard(c2);
            hw = 2;
        }
        else
        {
            if (console) System.out.println("war");
            this.playWar(c1,c2);
            hw = 3;
        }
    }

    public int checkWinner()
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

    public void playWar(Card c1, Card c2)
    {
        Card down1 = h1.player1play();
        Card down2 = h1.player2play();

        this.checkWinner();

        Card up1 = h1.player1play();
        Card up2 = h1.player2play();

        //int hw = this.compareHands(up1, up2);
        if (console)
        {
            System.out.println(" ");
            System.out.println("player 1's card: " + up1.toString());
            System.out.println("player 2's card: " + up2.toString());
        }

        if (up1.getRank() > up2.getRank())
        {
            if (console) System.out.println("Player 1 wins");
                h1.player1addCard(down2);
                h1.player1addCard(up2);
                h1.player1addCard(down1);
                h1.player1addCard(up1);
                h1.player1addCard(c1);
                h1.player1addCard(c2);
        }
        else if (up1.getRank() < up2.getRank())
        {
            if (console) System.out.println("Player 2 wins");
                h1.player2addCard(down2);
                h1.player2addCard(up2);
                h1.player2addCard(down1);
                h1.player2addCard(up1);
                h1.player2addCard(c1);
                h1.player2addCard(c2);
        }
        else
        {
                this.playWar(c1,c2);
        }

    }

    public int compareHands(Card c1, Card c2)
    {
        int hw = 0;
        return hw;
    }
    /*
    public int checkWinner()
    {
        int winner = 0;
        if (p1Queue.isEmpty)
        {
            winner = 2;
        }
        else if (p2Queue.isEmpty())
        {
            winner = 1;
        }
        return winner;
    }
    */
    public int checkSize(int player)
    {
        int out = 0;
        if (player == 1)
        {
            out = h1.checkSize(1);
        }
        if (player == 2)
        {
            out = h1.checkSize(2);
        }
        return out;
    }
    public String toString(int player)
    {
        String out = " ";
        if (player == 1)
        {
            out = h1.toString(1);
        }
        if (player == 2)
        {
            out = h1.toString(2);
        }
        return out;
    }
}
