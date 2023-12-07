import java.util.*;

public class jour7 {

    static void map(String line, Map<String, Integer> map, List<String> main){
        List<String> split = Arrays.asList(line.split(" "));
        map.put(split.get(0), Integer.parseInt(split.get(1)));
        main.add(split.get(0));
    }

    static void trier(Map<String, Integer> map, List<Integer> trier, List<String> list){
        PokerCardSorting.sortHands(list);
        for(String c : list){
            trier.add(map.get(c));
        }
    }

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour7.txt", "\n");

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < parser.size(); ++i){
            map(parser.get(i), map, list);
        }

        List<Integer> trier = new ArrayList<>();

        trier(map, trier, list);

        int res = 0;

        for(int i = 0; i < trier.size(); ++i){
            res += trier.get(i) * (i+1);
        }

        System.out.println(res);
    }

    static void trier2(Map<String, Integer> map, List<Integer> trier, List<String> list){
        PokerCardSorting2.sortHands(list);
        for(String c : list){
            trier.add(map.get(c));
        }
    }

    static void part2(){

       List<String> parser = AOC.parser("/txt/jour7.txt", "\n");

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < parser.size(); ++i){
           map(parser.get(i), map, list);
        }

        List<Integer> trier = new ArrayList<>();

        trier2(map, trier, list);

        int res = 0;

        for(int i = 0; i < trier.size(); ++i){
            res += trier.get(i) * (i+1);
        }

        System.out.println(res);
    }


    public static void main(String[] args) throws Exception{
        System.out.print("Première partie : ");
        part1();
        System.out.print("Seconde partie : ");
        part2();
    }
}
