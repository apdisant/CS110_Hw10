//Alex DiSanto
//cs110
//half stacks of cards for card game war
public class HalfStacks extends Deck
{
    private int i = 0;
    public QueueInterface p1Queue = new QueueReferenceBased();
    public QueueInterface p2Queue = new QueueReferenceBased();

    public void newDecks()
    {
        Deck deck = new Deck();
        deck.freshDeck();
        deck.shuffle();
        while (!(deck.isEmpty()))
        {
            if (i == 0)
            {
                p1Queue.enqueue(new Card(deck.dealCard()));
            }   
            else
            {
                p2Queue.enqueue(new Card(deck.dealCard()));
            }   
            i++;
            if (i == 2)
                i = 0;
        }   
    }

    public Card player1play()
    {
        Card c1 = ((Card)p1Queue.dequeue());
        System.out.println(c1.toString());
        return c1;
    }

    public Card player2play()
    {
        Card c2 = ((Card)p2Queue.dequeue());
        System.out.println(c2.toString());
        return c2;
    }

    public String toString(int player)
    {
        String out = "";
        if (player == 1)
        {
            System.out.println("player 1's cards: ");
            int r = 1;
            Card cFirst = ((Card)p1Queue.dequeue());
            p1Queue.enqueue(cFirst);
            out = cFirst.toString() + "\n";
            while(r == 1)
            {
                Card c1 = ((Card)p1Queue.dequeue());
                p1Queue.enqueue(c1);
                if (c1.equals(cFirst))
                {
                    r = 0;
                }
                out = out + c1.toString() + "\n";
            }
        }
        else if (player == 2)
        {
            System.out.println("player 2's cards: ");
            while(!(p2Queue.isEmpty()))
            {
                Card c2 = ((Card)p2Queue.dequeue());
                //p2Queue.enqueue(c2);
                out = out + c2.toString() + "\n";
            }
        }
        else
        {
            out = "select one or two to see player one or two's decks";
        }
        return out;
    }


}
