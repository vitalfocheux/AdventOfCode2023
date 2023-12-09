import java.util.*;

public class jour9 {

    static List<Integer> toIntegerList(List<String> list){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < list.size(); ++i){
            l.add(Integer.parseInt(list.get(i)));
        }
        return l;
    }

    static boolean allZero(List<Integer> list){
        for(int i = 0; i < list.size(); ++i){
            if(list.get(i) != 0){
                return false;
            }
        }
        return true;
    }

    static void part1(){


        List<String> parser = AOC.parser("/txt/jour9.txt", "\n");

        int res = 0;

        for(int i = 0; i < parser.size(); ++i){
            List<String> lines = Arrays.asList(parser.get(i).split(" "));
            List<Integer> l = toIntegerList(lines);
            List<Integer> endExtra = new ArrayList<>();
            
            while(!allZero(l)){
                List<Integer> t_l = new ArrayList<>();
                int k = l.size();
                endExtra.add(l.get(l.size() - 1));
                for(int j = 0; j < k-1; j++){
                    t_l.add(l.get(j+1) - l.get(j));
                }
                l = t_l;
                
            }
            for(int j = 0; j < endExtra.size(); ++j){
                res += endExtra.get(j);
            }
        }

        System.out.println(res);
    }


    static void part2(){

       List<String> parser = AOC.parser("/txt/jour9.txt", "\n");

        int res = 0;

        for(int i = 0; i < parser.size(); ++i){
            List<String> lines = Arrays.asList(parser.get(i).split(" "));
            List<Integer> l = toIntegerList(lines);
            List<Integer> endExtra = new ArrayList<>();
            
            while(!allZero(l)){
                List<Integer> t_l = new ArrayList<>();
                int k = l.size();
                endExtra.add(l.get(0));
                for(int j = 0; j < k-1; j++){
                    t_l.add(l.get(j+1) - l.get(j));
                }
                l = t_l;
                
            }
            int temp = 0;
            for(int j = 0; j < endExtra.size(); ++j){
                if(j%2 == 0){
                    temp += endExtra.get(j);
                }else{
                    temp -= endExtra.get(j);
                }
            }
            res += temp;
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
