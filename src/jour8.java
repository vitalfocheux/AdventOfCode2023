import java.util.*;
import java.util.Map.Entry;

public class jour8 {

    static void parser(List<String> parser, Map<String, List<String>> map){
        for(int i = 2; i < parser.size(); ++i){
            List<String> split = Arrays.asList(parser.get(i).split(" = "));
            /*StringBuilder str = new StringBuilder();
            str.append(split.get(0).charAt(2));
            str.append(split.get(0).charAt(1));
            str.append(split.get(0).charAt(0));*/
            List<String> s = Arrays.asList(split.get(1).replace("(", "").replace(")", "").split(", "));
            map.put(split.get(0), s);
        }
    }

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour8.txt", "\n");

        Map<String, List<String>> map = new TreeMap<>();

        parser(parser, map);

        String suite = parser.get(0);

        int marche = 0;
        int dir = 0;
        
        String depart = "AAA";

        while(!depart.equals("ZZZ")){
            ++marche;
            if(dir == suite.length()){
                dir = 0;
            }
            if(suite.charAt(dir) == 'L'){
                ++dir;
                depart = map.get(depart).get(0);
            }else if(suite.charAt(dir) == 'R'){
                ++dir;
                depart = map.get(depart).get(1);
            }
        }
        System.out.println(marche);
    }

    static void parser2(List<String> parser, Map<String, List<String>> map){
        for(int i = 2; i < parser.size(); ++i){
            List<String> split = Arrays.asList(parser.get(i).split(" = "));
            StringBuilder str = new StringBuilder();
            str.append(split.get(0).charAt(2));
            str.append(split.get(0).charAt(1));
            str.append(split.get(0).charAt(0));
            List<String> s = Arrays.asList(split.get(1).replace("(", "").replace(")", "").split(", "));
            StringBuilder _str = new StringBuilder();
            StringBuilder _str_ = new StringBuilder();
            _str.append(s.get(0).charAt(2));
            _str.append(s.get(0).charAt(1));
            _str.append(s.get(0).charAt(0));
            _str_.append(s.get(1).charAt(2));
            _str_.append(s.get(1).charAt(1));
            _str_.append(s.get(1).charAt(0));
            s= new ArrayList<>();
            s.add(_str.toString()); s.add(_str_.toString());
            map.put(str.toString(), s);

        }
    }

    static boolean allEndWithZ(String str){
        return str.charAt(0) ==  'Z';
    }

    static void part2(){

       List<String> parser = AOC.parser("/txt/jour8.txt", "\n");

        Map<String, List<String>> map = new TreeMap<>();

        parser2(parser, map);

        String suite = parser.get(0);

        int dir = 0;
        
        List<String> departs = new ArrayList<>();

        for(Entry<String, List<String>> m : map.entrySet()){
            if(m.getKey().charAt(0) == 'A'){
                String s = m.getKey();
                departs.add(s);
            }
        }
        List<Integer> numbers = new ArrayList<>();
        
        long res = 1;
        for(String str : departs){
            int marche = 0;
            String depart = str;
            while(!allEndWithZ(depart)){
                ++marche;
                if(dir == suite.length()){
                    dir = 0;
                }
                if(suite.charAt(dir) == 'L'){
                    ++dir;
                    depart = map.get(depart).get(0);
                }else if(suite.charAt(dir) == 'R'){
                    ++dir;
                    depart = map.get(depart).get(1);
                }
            }
            numbers.add(marche);
        }
        Map<Integer, Integer> m = maxPrimeFactors(numbers);
        for(Entry<Integer, Integer> ma : m.entrySet()){
            res *= Math.pow(ma.getKey(), ma.getValue());
        }
        System.out.println(res);
    }

    public static Map<Integer, Integer> maxPrimeFactors(List<Integer> numbers) {
        Map<Integer, Integer> maxFactors = new HashMap<>();

        for (int num : numbers) {
            Map<Integer, Integer> factorsCount = new HashMap<>();
            for (int i = 2; i <= num; i++) {
                while (num % i == 0) {
                    factorsCount.put(i, factorsCount.getOrDefault(i, 0) + 1);
                    num /= i;
                }
            }

            for (Map.Entry<Integer, Integer> entry : factorsCount.entrySet()) {
                int prime = entry.getKey();
                int count = entry.getValue();
                maxFactors.put(prime, Math.max(maxFactors.getOrDefault(prime, 0), count));
            }
        }

        return maxFactors;
    }

    public static void main(String[] args) throws Exception{
        System.out.print("Première partie : ");
        part1();
        System.out.print("Seconde partie : ");
        part2();
    }
}
