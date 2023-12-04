import java.util.*;

public class jour4 {

    public static void cartes(List<String> parser, List<List<Integer>> gagnants, List<List<Integer>> cartes){
        for(String str : parser){
            String[] split = str.split(": ");
            //System.out.println(split[1]);
            String[] s = split[1].split("\\|");
            String[] ga = s[0].split(" ");
            String[] c = s[1].split(" ");
            List<Integer> gan = new ArrayList<>();
            List<Integer> ca = new ArrayList<>();
            for(String g : ga){
                //System.out.println(g.trim());
                if(!g.trim().isEmpty()){
                    gan.add(Integer.parseInt(g.trim()));
                }
                
            }
            for(String carte : c){
                //System.out.println(carte.trim());
                if(!carte.trim().isEmpty()){
                    ca.add(Integer.parseInt(carte.trim()));
                }
                //
            }
            gagnants.add(gan);
            cartes.add(ca);
        }
    }


    static void part1(){

        List<String> parser = AOC.parser("/txt/jour4.txt", "\n");
        
        List<List<Integer>> gagnants = new ArrayList<>();
        List<List<Integer>> cartes = new ArrayList<>();

        cartes(parser, gagnants, cartes);
        
        int res = 0;

        for(int i = 0; i < parser.size(); ++i){
            int point = 0;

            for(int j = 0; j < cartes.get(i).size(); ++j){
                if(gagnants.get(i).contains(cartes.get(i).get(j))){
                    if(point == 0){
                        ++point;
                    }else{
                        point *= 2;
                    }
                }
            }

            res += point;
        }


        System.out.println(res);
    }

    public static void part2(){

        List<String> parser = AOC.parser("/txt/jour4.txt", "\n");

        
        List<List<Integer>> gagnants = new ArrayList<>();
        List<List<Integer>> cartes = new ArrayList<>();

        cartes(parser, gagnants, cartes);

        List<List<Integer>> instance = new ArrayList<>();

        for(int i = 0; i < parser.size(); ++i){
            instance.add(new ArrayList<>());
            instance.get(i).add(1);
        }
        
        int res = 0;

        int c = 1;
        for(int i = 0; i < parser.size(); ++i){
            
            int point = 0;

            for(int j = 0; j < cartes.get(i).size(); ++j){
                if(gagnants.get(i).contains(cartes.get(i).get(j))){
                    point++;
                }
            }


            for(int k = 0; k < point; ++k){
                int p = instance.get(k+c).get(0);
                instance.get(k+c).remove(0);
                p += instance.get(c-1).get(0);
                instance.get(k+c).add(p);
                
            }
            ++c;
        }

        for(int i = 0; i < instance.size(); ++i){
                res += instance.get(i).get(0);
            
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
