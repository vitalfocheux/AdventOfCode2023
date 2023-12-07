import java.util.Arrays;
import java.util.List;

public class PokerCardSorting {

    public static char getCardSuit(String card){
        return card.charAt(card.length() - 1);
    }

    static int determineRank(String hand) {
        char[] cards = hand.toCharArray();
        Arrays.sort(cards);

        int[] counts = new int[14]; 
        for (char card : cards) {
            int index = "23456789TJQKA".indexOf(card); 
            counts[index]++;
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();


        if (maxCount == 5) {
            return 7;
        } else if (maxCount == 4) {
            return 6; 
        } else if (maxCount == 3 && Arrays.stream(counts).filter(count -> count == 2).count() == 1) {
            return 5; 
        } else if (maxCount == 3) {
            return 4; 
        } else if (Arrays.stream(counts).filter(count -> count == 2).count() == 2) {
            return 3; 
        } else if (Arrays.stream(counts).filter(count -> count == 2).count() == 1) {
            return 2; 
        } else {
            return 1; 
        }
    }

    static int compareHands(String hand1, String hand2) {
        char[] cards1 = hand1.toCharArray();
        char[] cards2 = hand2.toCharArray();
    

        for (int i = 0; i < cards1.length; i++) {
            int index1 = "23456789TJQKA".indexOf(cards1[i]);
            int index2 = "23456789TJQKA".indexOf(cards2[i]);
            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }
    
        return 0; 
    }
    
    static void sortHands(List<String> hands) {
        hands.sort((hand1, hand2) -> {
            int rank1 = determineRank(hand1);
            int rank2 = determineRank(hand2);

            if (rank1 != rank2) {
                return Integer.compare(rank1, rank2);
            } else {
                return compareHands(hand1, hand2);
            }
        });
    }

}
