import java.util.*;

public class jour1 {

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour1.txt", "\n");

        int res = 0;

        for(String str : parser){
            char f = '\0';
            char l = '\0';
            for(int i = 0; i < str.length(); ++i){


                if(str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5'|| str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8'|| str.charAt(i) == '9'){
                    if(f == '\0'){
                        f = str.charAt(i);
                    }else{
                        l = str.charAt(i);
                    }
                }
            }
            
            StringBuilder builder = new StringBuilder("");


                builder.append(f);
            if(l == '\0'){
                builder.append(f);
            }else{
                builder.append(l);
            }
            res += Integer.parseInt(builder.toString());
        }


        System.out.println(res);
    }

    static void part2(){

        List<String> parser = AOC.parser("/txt/jour1.txt", "\n");

        int res = 0;

        for(String str : parser){
            char f = '\0';
            char l = '\0';
            for(int i = 0; i < str.length(); ++i){


                if(str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5'|| str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8'|| str.charAt(i) == '9'){
                    if(f == '\0'){
                        f = str.charAt(i);
                    }else{
                        l = str.charAt(i);
                    }

                }if(i+2 < str.length()){
                    if(str.charAt(i) == 'o' && str.charAt(i+1) == 'n' && str.charAt(i+2) == 'e'){
                        if(f == '\0'){
                            f = '1';
                        }else{
                            l = '1';
                        }
                    }
                    else if(str.charAt(i) == 't' && str.charAt(i+1) == 'w' && str.charAt(i+2) == 'o'){
                        if(f == '\0'){
                        f = '2';
                        }else{
                            l = '2';
                        }
                    }
                    
                    else if(str.charAt(i) == 's' && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'x'){
                        if(f == '\0'){
                        f = '6';
                        }else{
                            l = '6';
                        }
                    }
                }if(i+4 < str.length()){
                    if(str.charAt(i) == 't' && str.charAt(i+1) == 'h' && str.charAt(i+2) == 'r' && str.charAt(i+3) == 'e' && str.charAt(i+4) == 'e'){
                        if(f == '\0'){
                        f = '3';
                        }else{
                            l = '3';
                        }
                    }
                    else if(str.charAt(i) == 's' && str.charAt(i+1) == 'e' && str.charAt(i+2) == 'v' && str.charAt(i+3) == 'e' && str.charAt(i+4) == 'n'){
                        if(f == '\0'){
                        f = '7';
                        }else{
                            l = '7';
                        }
                    }
                    else if(str.charAt(i) == 'e' && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'g' && str.charAt(i+3) == 'h' && str.charAt(i+4) == 't'){
                        if(f == '\0'){
                        f = '8';
                        }else{
                            l = '8';
                        }
                    }
                }if(i+3 < str.length()){
                    if(str.charAt(i) == 'f' && str.charAt(i+1) == 'o' && str.charAt(i+2) == 'u'&& str.charAt(i+3) == 'r'){
                        if(f == '\0'){
                        f = '4';
                        }else{
                            l = '4';
                        }
                    }else if(str.charAt(i) == 'f' && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'v'&& str.charAt(i+3) == 'e'){
                        if(f == '\0'){
                        f = '5';
                        }else{
                            l = '5';
                        }
                    }else if(str.charAt(i) == 'n' && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'n'&& str.charAt(i+3) == 'e'){
                        if(f == '\0'){
                        f = '9';
                        }else{
                            l = '9';
                        }
                    }
                }
            }
            
            StringBuilder builder = new StringBuilder("");


                builder.append(f);
            if(l == '\0'){
                builder.append(f);
            }else{
                builder.append(l);
            }
            res += Integer.parseInt(builder.toString());
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
