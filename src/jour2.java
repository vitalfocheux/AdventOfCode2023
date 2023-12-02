import java.util.*;

public class jour2 {

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour2.txt", "\n");

        int res = 0;

        for(String str : parser){
            String[] g = str.split(":");
            String[] game = g[1].split(";");
            boolean ok = true;
            for(String s : game){
                
                String[] couleur = s.split(" ");

                for(int i = 0; i < couleur.length;++i){
                    if((couleur[i].equals("red,")|| couleur[i].equals("red")) && Integer.parseInt(couleur[i-1]) > 12){
                        ok = false;
                        break;
                    }
                    if((couleur[i].equals("blue,") ||couleur[i].equals("blue")) && Integer.parseInt(couleur[i-1]) > 14){
                        ok = false;
                        break;
                    }
                    if((couleur[i].equals("green,") || couleur[i].equals("green")) && Integer.parseInt(couleur[i-1]) > 13){
                        ok = false;
                        break;
                    }
                }
                if(!ok){
                    break;
                }
                
            }
            if(ok){
                res += Integer.parseInt(g[0].split(" ")[1]);
            }
        }


        System.out.println(res);
    }

    static void part2(){

       List<String> parser = AOC.parser("/txt/jour2.txt", "\n");

        int res = 0;

        for(String str : parser){
            String[] g = str.split(":");
            String[] game = g[1].split(";");
            int r = 0;
            int gr = 0;
            int b = 0;
            for(String s : game){
                
                String[] couleur = s.split(" ");

                for(int i = 0; i < couleur.length;++i){
                    if((couleur[i].equals("red,")|| couleur[i].equals("red")) /*&& Integer.parseInt(couleur[i-1]) > 12*/){
                        if(r < Integer.parseInt(couleur[i-1])){
                            r = Integer.parseInt(couleur[i-1]);
                        }
                    }
                    if((couleur[i].equals("blue,") ||couleur[i].equals("blue"))/* && Integer.parseInt(couleur[i-1]) > 14*/){
                        if(b < Integer.parseInt(couleur[i-1])){
                            b = Integer.parseInt(couleur[i-1]);
                        }
                    }
                    if((couleur[i].equals("green,") || couleur[i].equals("green"))/*  && Integer.parseInt(couleur[i-1]) > 13*/){
                        if(gr < Integer.parseInt(couleur[i-1])){
                            gr = Integer.parseInt(couleur[i-1]);
                        }
                    }
                }                
            }
            res += r * b*gr;
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
