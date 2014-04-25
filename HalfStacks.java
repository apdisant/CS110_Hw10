//Alex DiSanto
//cs110
//half stacks of cards for card game war
public class HalfStacks extends Deck
{
    private int i = 0;
    private boolean debug = false;
    public QueueInterface p1Queue = new QueueReferenceBased();
    public QueueInterface p2Queue = new QueueReferenceBased();

    public void newDecks()
    {
        Deck deck = new Deck();
        deck.freshDeck();
        deck.shuffle();
        p1Queue.dequeueAll();
        p2Queue.dequeueAll();
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
        if (debug) System.out.println(c1.toString());
        return c1;
    }

    public Card player2play()
    {
        Card c2 = ((Card)p2Queue.dequeue());
        if (debug) System.out.println(c2.toString());
        return c2;
    }

    public void player1addCard(Card c1)
    {
        p1Queue.enqueue(c1);
    }

    public void player2addCard(Card c2)
    {
        p2Queue.enqueue(c2);
    }

    public boolean isEmpty(int player)
    {
        boolean t = false;
        if (player == 1)
        {
            if (p1Queue.isEmpty() == true)
            {
                t = true;
            }
            else
            {
                t = false;
            }
        }
        else if (player == 2)
        {
            if (p2Queue.isEmpty() == true)
            {
                t = true;
            }
            else 
            {
                t = false;
            }
        }
        else
        {
            System.out.println("Enter 1 or 2");
        }
        return t;
    }

    public String toString(int player)
    {
        String out = "";
        if (player == 1)
        {
            System.out.println("player 1's cards: ");
            int r = 1;
            int n = 2;
            Card cFirst = ((Card)p1Queue.dequeue());
            p1Queue.enqueue(cFirst);
            out = "1. " + cFirst.toString() + "\n";
            while(r == 1)
            {
                Card c1 = ((Card)p1Queue.peek());
                if (c1.equals(cFirst))
                {
                    r = 0;
                }
                else
                {
                    p1Queue.dequeue();
                    p1Queue.enqueue(c1);
                    out = out +n+". " + c1.toString() + "\n";
                }
                n++;
            }
        }
        else if (player == 2)
        {
            System.out.println("player 2's cards: ");
            int r = 1;
            int n = 2;
            Card cFirst = ((Card)p2Queue.dequeue());
            p2Queue.enqueue(cFirst);
            out = "1. " + cFirst.toString() + "\n";
            while(r == 1)
            {
                Card c2 = ((Card)p2Queue.peek());
                if (c2.equals(cFirst))
                {
                    r = 0;
                }
                else
                {
                    p2Queue.dequeue();
                    p2Queue.enqueue(c2);
                    out = out +n+". " + c2.toString() + "\n";
                }
                n++;
            }
        }
        else
        {
            out = "enter 1 or 2 to see player one or two's decks";
        }
        return out;
    }


}
