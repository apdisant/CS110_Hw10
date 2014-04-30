//Alex DiSanto
//cs110
//half stacks of cards for card game war
/**
 * HalfStacks class holds each players deck in a reference based Queue
 */
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
        while (!(deck.isEmpty())) //alternately deals cards to players
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

    /** returns the top card of player 1's deck
     * @return Card card played
     */
    public Card player1play()
    {
        Card c1 = ((Card)p1Queue.dequeue());
        if (debug) System.out.println(c1.toString());
        return c1;
    }

    /** returns the top card of player 2's deck
     * @return Card card played
     */
    public Card player2play()
    {
        Card c2 = ((Card)p2Queue.dequeue());
        if (debug) System.out.println(c2.toString());
        return c2;
    }

    /** adds a card to the back of player 1's deck
     * @param Card c1
     */
    public void player1addCard(Card c1)
    {
        p1Queue.enqueue(c1);
    }

    /** adds a card to the back of player 2's deck
     * @param Card c2
     */
    public void player2addCard(Card c2)
    {
        p2Queue.enqueue(c2);
    }

    /**checks size of selected player's deck
     * @param int player
     * @return int size
     */
    public int checkSize(int player)
    {
        int n = 0;
        if (player == 1)
        {
            //System.out.println("player 1's cards: ");
            int r = 1;
            n = 2;
            Card cFirst = ((Card)p1Queue.dequeue()); //draws first card
            p1Queue.enqueue(cFirst);//places first card at end of deck
            while(r == 1)
            {
                Card c1 = ((Card)p1Queue.peek());//this method must cycle through the entire deck to see every card
                if (c1.equals(cFirst)) // if whole deck seen
                {
                    r = 0;
                }
                else
                {
                    p1Queue.dequeue();
                    p1Queue.enqueue(c1);
                }
                n++;
            }
        }
        else if (player == 2)
        {
            //System.out.println("player 2's cards: ");
            int r = 1;
            n = 2;
            Card cFirst = ((Card)p2Queue.dequeue());
            p2Queue.enqueue(cFirst);
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
                }
                n++;
            }
        }
        return (n - 2) ;
    }


    /**tells wether or not selected player's deck is empty
     * @param int player
     * @return boolean bool
     */
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

    /**returns a String of all cards in selected player's deck
     * @param int player
     * @return String out
     */
    public String toString(int player)
    {
        String out = "";
        if (player == 1)
        {
            //System.out.println("player 1's cards: ");
            int r = 1;
            int n = 2;
            Card cFirst = ((Card)p1Queue.dequeue());
            p1Queue.enqueue(cFirst);
            out = "1. " + cFirst.toString() + "\n";
            while(r == 1) //as with size method cycles through entire deck
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
            //System.out.println("player 2's cards: ");
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
