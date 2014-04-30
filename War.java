import java.util.ArrayList;
//Alex DiSanto
//CS110
//Guts of card game war
public class War extends HalfStacks
{
    private int w = 0;
    private boolean console = false; // allows you to select wether using console or GUI
    private HalfStacks h1 = new HalfStacks();
    private int debug = 1;
    private ArrayList<Card> warStack = new ArrayList<Card>();
    
    public void freshGame()
    {
        h1.newDecks();
    }

    public int playHand()
    {
        //Card c1 = h1.player1play();
        //Card c1 = h1.player1play();
        Card c1 = ((Card)this.h1.p1Queue.dequeue());
        Card c2 = ((Card)this.h1.p2Queue.dequeue());
        int hw = 0;
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
            //this.getCard(c1,c2);
            hw = 3;
        }
        return hw;
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
    public Card getCard(int player)
    {
        Card out = new Card(1,1);
        if (player == 1)
        {
            out = ((Card)this.h1.p1Queue.peek());
        }
        else if (player == 2)
        {
            out = ((Card)this.h1.p2Queue.peek());
        }
        else
        {
            System.out.println("enter 1 or 2");
        }
        return out;
    }

    public String getCardPic(int player)
    {
        String out = "";
        Card c1 = new Card(1,1);
        if (player == 1) 
        {
            c1 = ((Card)h1.p1Queue.peek()); 
        }
        if (player == 2) 
        {
            c1 = ((Card)h1.p2Queue.peek()); 
        }
        int suit = c1.getSuit();
        String ss = "";
        switch (suit)
        {
            case 0: ss = "s";
                    break;
            case 1: ss = "h";
                    break;
            case 2: ss = "d";
                    break;
            case 3: ss = "c";
                    break;
        }

        String rank = c1.getRankAsString().toLowerCase();

        out = rank + ss + ".jpg";
        return out;
    }

    public int playWar(Card c1, Card c2)
    {
        int hw = 0;
        int i = 0;
        Card down1 = h1.player1play();
        Card down2 = h1.player2play();

        //this.checkWinner();

        Card up1 = h1.player1play();
        Card up2 = h1.player2play();

        warStack.add(c1);
        warStack.add(c2);
        warStack.add(up1);
        warStack.add(up2);
        warStack.add(down1);
        warStack.add(down2);

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
            /*
                h1.player1addCard(down2);
                h1.player1addCard(up2);
                h1.player1addCard(down1);
                h1.player1addCard(up1);
                h1.player1addCard(c1);
                h1.player1addCard(c2);
                */
            int wss = warStack.size(); //stack shrinks as removed so must call before loop
                if (debug == 1) System.out.println(warStack.size());
            for(i = 0; i<wss;i++)
            {
                Card cGet = warStack.get(0);
                if (debug ==1) System.out.println(cGet.toString());
                warStack.remove(0);
                h1.player1addCard(cGet);
            }
                hw = 1;
        }
        else if (up1.getRank() < up2.getRank())
        {
            if (console) System.out.println("Player 2 wins");
            /*
                h1.player2addCard(down2);
                h1.player2addCard(up2);
                h1.player2addCard(down1);
                h1.player2addCard(up1);
                h1.player2addCard(c1);
                h1.player2addCard(c2);
                */
            int wss = warStack.size(); //stack shrinks as removed so must call before loop
                if (debug == 1) System.out.println(warStack.size());
            for(i = 0; i<wss;i++)
            {
                Card cGet = warStack.get(0);
                if (debug ==1) System.out.println(cGet.toString());
                warStack.remove(0);
                h1.player2addCard(cGet);
            }
                hw = 2;
        }
        else
        {
                //this.playWar(c1,c2);
                hw = 3;
        }
        return hw;
    }
    public void warFixer()
    {
        warStack.remove(0);
        warStack.remove(1);
    }

    public int compareHands(Card c1, Card c2)
    {
        int hw = 0;
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
            //this.playWar(c1,c2);
            hw = 3;
        }
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
