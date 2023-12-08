import java.util.*;
import java.util.Map.Entry;

public class jour8 {

    /*static void parser(List<String> parser, Map<String, List<String>> map){
        for(int i = 2; i < parser.size(); ++i){
            List<String> split = Arrays.asList(parser.get(i).split(" = "));
            StringBuilder str = new StringBuilder();
            str.append(split.get(0).charAt(2));
            str.append(split.get(0).charAt(1));
            str.append(split.get(0).charAt(0));
            List<String> s = Arrays.asList(split.get(1).replace("(", "").replace(")", "").split(", "));
            map.put(str, s);

        }
    }*/

    /*static void part1(){

        List<String> parser = AOC.parser("/txt/jour8.txt", "\n");

        Map<String, List<String>> map = new TreeMap<>();

        parser(parser, map);

        String suite = parser.get(0);

        System.out.println(suite);

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
*/
    static void parser2(List<String> parser, Map<String, List<String>> map){
        for(int i = 2; i < parser.size(); ++i){
            List<String> split = Arrays.asList(parser.get(i).split(" = "));
            StringBuilder str = new StringBuilder();
            str.append(split.get(0).charAt(2));
            str.append(split.get(0).charAt(1));
            str.append(split.get(0).charAt(0));
            List<String> s = Arrays.asList(split.get(1).replace("(", "").replace(")", "").split(", "));
            map.put(str.toString(), s);

        }
    }

    static boolean allEndWithZ(List<String> list){
        if(list.isEmpty()){
            return false;
        }
        for(String s : list){
            if(s.charAt(0) != 'Z'){
                return false;
            }
        }
        return true;
    }

    static void part2(){

       List<String> parser = AOC.parser("/txt/jour8.txt", "\n");

        Map<String, List<String>> map = new TreeMap<>();

        parser2(parser, map);

        String suite = parser.get(0);

        System.out.println(map);

        int marche = 0;
        int dir = 0;
        
        List<String> departs = new ArrayList<>();
        List<String> new_departs = departs;

        for(Entry<String, List<String>> m : map.entrySet()){
            if(m.getKey().charAt(0) == 'A'){
                departs.add(m.getKey());
            }
        }
        int j = 0;
        
        while(!allEndWithZ(departs) || !allEndWithZ(new_departs)){
            System.out.println(departs);
            System.out.println(new_departs);
            if(j > 10){break;}
            ++marche;
            if(dir == suite.length()){
                dir = 0;
            }
            int i = 0;
            System.out.println(j%2);
            if(j%2 == 1){
                for(String str : new_departs){
                    if(str.charAt(dir) == 'L'){
                        System.out.print("L ndeparts");
                        departs.add(i, map.get(str).get(0));
                        new_departs.remove(i);
                            
                    }else if(str.charAt(dir) == 'R'){
                        System.out.print("R ndeparts");
                        departs.add(i, map.get(str).get(1));
                        new_departs.remove(i);
                    }  
                ++i;
                }
            }else if(j%2 == 0){
                for(String str : departs){
                    if(str.charAt(dir) == 'L'){
                        System.out.print("L departs");
                        new_departs.add(i, map.get(str).get(0));
                            departs.remove(i);
                            
                    }else if(str.charAt(dir) == 'R'){
                        System.out.print("R departs");
                        departs.add(i, map.get(str).get(1));
                        new_departs.remove(i);
                        
                    }  
                ++i;
                }
            }
            
            ++j;
            ++dir;
        }
    }


    public static void main(String[] args) throws Exception{
        /*System.out.print("Première partie : ");
        part1();*/
        System.out.print("Seconde partie : ");
        part2();
    }
}
