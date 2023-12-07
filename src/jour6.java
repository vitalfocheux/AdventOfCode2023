import java.util.*;

public class jour6 {

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour6_1.txt", "\n");

        List<String> temp = Arrays.asList(parser.get(0).replace("Time:", "").trim().split("     "));
        List<String> dist = Arrays.asList(parser.get(1).replace("Distance:", "").trim().split("   "));

        int res = 1;

        for(int i = 0; i < temp.size(); ++i){
            int temp_res = 0;
            int time = Integer.parseInt(temp.get(i).trim());
            int d = Integer.parseInt(dist.get(i).trim());
            for(int j = 0; j <= time; ++j){
                int mm = 0;
                if(j == 0){
                    continue;
                }
                while(time - j > mm){
                    ++mm;
                }
                
                if(j*mm > d){
                    temp_res++;
                }
            }
            res *= temp_res;
        }

        System.out.println(res);
    }

    static void part2(){

       List<String> parser = AOC.parser("/txt/jour6_2.txt", "\n");

        List<String> temp = Arrays.asList(parser.get(0).replace("Time:", "").trim().split("     "));
        List<String> dist = Arrays.asList(parser.get(1).replace("Distance:", "").trim().split("   "));

        Long res = (long)1;

        for(int i = 0; i < temp.size(); ++i){
            Long time = Long.parseLong(temp.get(i).trim());
            Long d = Long.parseLong(dist.get(i).trim());
            for(Long j = (long) 0; j <= time; ++j){
                Long mm = (long)0;
                if(j == 0){
                    continue;
                }
                
                mm = (time-j) * j;
                if(mm > d){
                    ++res;
                }
            }
        }
        --res;

        System.out.println(res);
    }


    public static void main(String[] args) throws Exception{
        System.out.print("Première partie : ");
        part1();
        System.out.print("Seconde partie : ");
        part2();
    }
}
