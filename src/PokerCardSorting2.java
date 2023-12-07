import java.util.Arrays;
import java.util.List;

public class PokerCardSorting2 {

    static int determineRank(String hand) {
        char[] cards = hand.toCharArray();
        Arrays.sort(cards);

        int[] counts = new int[14]; 
        int joker = 0;
        for (char card : cards) {
            int index = "J23456789TQKA".indexOf(card);
            if(index == 0){
                joker++;
            }else{
                counts[index]++;
            }
            
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();


        if (maxCount == 5 || (maxCount == 4 && joker == 1) || joker == 5 || (maxCount == 3 && joker == 2) || (maxCount == 2 && joker == 3) || joker == 4) {
            return 7; 
        } else if (maxCount == 4 || (maxCount == 3 && joker == 1) || (maxCount == 2 && joker == 2) || (maxCount == 1 && joker == 3)) {
            return 6; 
        } else if ((Arrays.stream(counts).filter(count -> count == 2).count() == 2 && joker == 1) || (maxCount == 3 && Arrays.stream(counts).filter(count -> count == 2).count() == 1)) {
            return 5; 
        } else if (maxCount == 3 || (maxCount == 2 && joker == 1) || (maxCount == 1 && joker == 2)) {
            return 4;
        } else if ((Arrays.stream(counts).filter(count -> count == 2).count() == 2) || (Arrays.stream(counts).filter(count -> count == 2).count() == 1 && joker == 1)) {
            return 3; 
        } else if (Arrays.stream(counts).filter(count -> count == 2).count() == 1 || (maxCount == 1 && joker == 1)) {
            return 2; 
        } else {
            return 1; 
        }
    }

    static int compareHands(String hand1, String hand2) {
        char[] cards1 = hand1.toCharArray();
        char[] cards2 = hand2.toCharArray();
    

        for (int i = 0; i < cards1.length; i++) {
            int index1 = "J23456789TQKA".indexOf(cards1[i]);
            int index2 = "J23456789TQKA".indexOf(cards2[i]);
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
