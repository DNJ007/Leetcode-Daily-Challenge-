import java.util.Map;
import java.util.TreeMap;

public class _6_6_24_Hand_of_Straights {
     public static boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        if( n % groupSize != 0 )
        {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new TreeMap<>();

        for(int card : hand)
        {
            cardCount.put(card, cardCount.getOrDefault(card,0)+1);
        }

        for(int card : cardCount.keySet())
        {
            int count = cardCount.get(card);

            if(count>0)
            {
                for(int i=0 ; i<groupSize ; i++)
                {
                    if(cardCount.getOrDefault(card+i,0) < count)
                    {
                        return false;
                    }
                    cardCount.put(card+i, cardCount.get(card+i)-count);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int hand[] = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }
}
