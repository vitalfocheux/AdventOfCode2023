import java.util.*;

public class jour3 {

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour3.txt", "\n");
        int res = 0;
       for(int i = 0; i < parser.size(); ++i){
            for(int j = 0; j < parser.get(i).length(); ++j){
                int temp = 0;
                int l = 0;
                if(parser.get(i).charAt(j) >= '0' && parser.get(i).charAt(j) <= '9'){
                    l = j;
                    temp *= 10;
                    temp += parser.get(i).charAt(j) - '0';
                    ++l;
                    while(l < parser.get(i).length() && parser.get(i).charAt(l) >= '0' && parser.get(i).charAt(l) <= '9'){  
                        temp *= 10;
                        temp += parser.get(i).charAt(l) - '0'; 
                        ++l;
                    }
                    
                    int k = j-1;
                    if(k < 0){
                        k = j;
                    }
                    while(k < l+1){
                        if(k >= parser.get(i).length()){
                            break;
                        }
                        if(i >= 0 && i < parser.size() - 1){
                            if(parser.get(i+1).charAt(k) != '.' && !(parser.get(i+1).charAt(k) >= '0' && parser.get(i+1).charAt(k) <= '9')){
                                res += temp;
                                break;
                            }
                        }
                        if(i < parser.size() && i > 0){
                            if(parser.get(i-1).charAt(k) != '.' && !(parser.get(i-1).charAt(k) >= '0' && parser.get(i-1).charAt(k) <= '9')){
                                res += temp;
                                break;
                            }
                        }
                        if(k > 0 && k < parser.get(i).length() - 1){
                            if(parser.get(i).charAt(k) != '.' && !(parser.get(i).charAt(k) >= '0' && parser.get(i).charAt(k) <= '9')){
                                res += temp;
                                break;
                            }
                        }
                        
                        ++k;
                    }
                    j = l;
                    
                }
            }
       }
        
        System.out.println(res);
    }

    public static void map(List<String> parser, HashMap<ArrayList<Integer>, Integer> map){
        for(int i = 0; i < parser.size(); ++i){
            for(int j = 0; j < parser.get(i).length(); ++j){
                if(Character.isDigit(parser.get(i).charAt(j))){
                    int f = j;
                    int nb = parser.get(i).charAt(j) - '0';
                    ++f;
                    while(f < parser.size() && Character.isDigit(parser.get(i).charAt(f))){
                        nb *= 10;
                        nb += parser.get(i).charAt(f) - '0';
                        ++f;
                    }
                    for(int k = j; k < f; ++k){
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(i); t.add(k);
                        map.put(t, nb);
                    }
                    j = f;
                }
            }
        }
    }

    public static void part2(){

        List<String> parser = AOC.parser("/txt/jour3.txt", "\n");

        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();

        int res = 0;
        map(parser, map);


        for(int i = 0; i < parser.size(); ++i){
            for(int j = 0; j < parser.get(i).length(); ++j){
                int x = 0;
                int y = 0;
                int pris = 0;
                if(parser.get(i).charAt(j)!= '*'){
                    continue;
                }
                for(int p = 0; p <2; ++p){
                    if(i > 0){
                        if(pris != 1 && Character.isDigit(parser.get(i-1).charAt(j-1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i-1); t.add(j-1);
                            pris = 1;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }else if(pris != 2 && Character.isDigit(parser.get(i-1).charAt(j))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i-1); t.add(j);
                            pris = 2;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }else if(pris != 3 && Character.isDigit(parser.get(i-1).charAt(j+1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i-1); t.add(j+1);
                            pris = 3;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }
                    }
                    if(i+1 < parser.size()){
                        if(pris != 6 && Character.isDigit(parser.get(i+1).charAt(j-1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i+1); t.add(j-1);
                            pris = 6;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }else if(pris != 7 && Character.isDigit(parser.get(i+1).charAt(j))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i+1); t.add(j);
                            pris = 7;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }else if(pris != 8 && Character.isDigit(parser.get(i+1).charAt(j+1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i+1); t.add(j+1);
                            pris = 8;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }
                    }
                    if(j > 0 && j < parser.get(i).length()){
                        if(pris != 4 && Character.isDigit(parser.get(i).charAt(j-1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i); t.add(j-1);
                            pris = 4;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }else if(pris != 5 && Character.isDigit(parser.get(i).charAt(j+1))){
                            ArrayList<Integer> t = new ArrayList<>();
                            t.add(i); t.add(j+1);
                            pris = 5;
                            if(x == 0){
                                x = map.get(t);
                            }else if(map.get(t) != x){
                                y = map.get(t);
                            }
                        }
                    }
                }
                if(x != 0 && y != 0){
                    res += x*y;
                }
                    
                
            }
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
