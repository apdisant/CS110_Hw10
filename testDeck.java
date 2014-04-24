import java.util.ArrayList;

public class testDeck 
{
   public static void main(String [] args) 
   {
       int i = 0;
       QueueInterface p1Queue = new QueueReferenceBased();
       QueueInterface p2Queue = new QueueReferenceBased();
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
       System.out.println("player 1's cards: ");
       for (int a = 0; a<26; a++)
       {
           Card c1 = ((Card)p1Queue.dequeue());
           System.out.println(c1.toString());
       }

       System.out.println(" ");
       System.out.println("player 2's cards: ");
       for (int b = 0; b<26; b++)
       {
           Card c2 = ((Card)p2Queue.dequeue());
           System.out.println(c2.toString());
       }

   }
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
 
   
   
   }
}
