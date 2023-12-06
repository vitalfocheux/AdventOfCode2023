import java.util.*;
import java.util.Map.Entry;

public class jour5_1 {

    static void seeds(String line, List<Long> seeds){
        String[] split = line.split(":");
        String[] str = split[1].split(" ");
        for(String s : str){
            if(!s.trim().isEmpty()){
                seeds.add(Long.parseLong(s));
            }
           
        }
    }

    static void map(String line, Map<Integer, Map<Long, Map<Long, Long>>> map){
        String[] split = line.split(" ");
        Long soil = Long.parseLong(split[0]);
        Long seed = Long.parseLong(split[1]);
        Long plage = Long.parseLong(split[2]);
        /*for(long i = 0; i < plage; ++i){
            map.put(seed, soil);
            seed++;
            soil++;
        }*/
        int size = map.size();
        Map<Long, Map<Long, Long>> m = new HashMap<>();
        Map<Long, Long> ss = new HashMap<>();
        ss.put(seed, soil);
        m.put(plage, ss);
        map.put(size, m);
    }

    static void part1(){

        List<String> parser = AOC.parser("/txt/jour5.txt", "\n");
        
        List<Long> seeds = new ArrayList<>();
        boolean ss  = false;
        Map<Integer, Map<Long, Map<Long, Long>>> seedSoil = new LinkedHashMap<>();
        boolean sf =false;
        Map<Integer, Map<Long, Map<Long, Long>>> soilFerti = new LinkedHashMap<>();
        boolean fw = false;
        Map<Integer, Map<Long, Map<Long, Long>>> fertiWater = new LinkedHashMap<>();
        boolean wl = false;
        Map<Integer, Map<Long, Map<Long, Long>>> waterLight = new LinkedHashMap<>();
        boolean lt = false;
       Map<Integer, Map<Long, Map<Long, Long>>> lightTempe = new LinkedHashMap<>();
        boolean th = false;
        Map<Integer, Map<Long, Map<Long, Long>>> tempeHumidity = new LinkedHashMap<>();
        boolean hl = false;
        Map<Integer, Map<Long, Map<Long, Long>>> humidityLocation = new LinkedHashMap<>();
        seeds(parser.get(0), seeds);


        for(int i = 0; i < parser.size(); ++i){
            if(parser.get(i).equals("")){
                continue;
            }
            if(parser.get(i).equals("seed-to-soil map:")){
                ss = true;
                continue;
            }else if(parser.get(i).equals("soil-to-fertilizer map:")){
                sf = true;
                continue;
            }else if(parser.get(i).equals("fertilizer-to-water map:")){
                fw = true;
                continue;
            }else if(parser.get(i).equals("water-to-light map:")){
                wl = true;
                continue;
            }else if(parser.get(i).equals("light-to-temperature map:")){
                lt = true;
                continue;
            }else if(parser.get(i).equals("temperature-to-humidity map:")){
                th = true;
                continue;
            }else if(parser.get(i).equals("humidity-to-location map:")){
                hl  =true;
                continue;
            }
            if(hl){
                map(parser.get(i), humidityLocation);
            }else if(th){
                map(parser.get(i), tempeHumidity);
            }else if(lt){
                map(parser.get(i), lightTempe);
            }else if(wl){
                map(parser.get(i), waterLight);
            }else if(fw){
                map(parser.get(i), fertiWater);
            }else if(sf){
                map(parser.get(i), soilFerti);
            }else if(ss){
                map(parser.get(i), seedSoil);
            }
        }

        

        Long res = Long.MAX_VALUE;

        for(int i = 0; i < seeds.size(); ++i){
            Long curr = seeds.get(i);
       //     System.out.println("\n\n"+curr);
            boolean br = false;
            for(int j = 0; j < seedSoil.size(); ++j){
                Map<Long, Map<Long, Long>> ma = seedSoil.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }

            }
            br = false;
       //     System.out.println(curr);
            for(int j = 0; j < soilFerti.size(); ++j){
                Map<Long, Map<Long, Long>> ma = soilFerti.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }

            }
            br = false;
        //    System.out.println(curr);
            for(int j = 0; j < fertiWater.size(); ++j){
                Map<Long, Map<Long, Long>> ma = fertiWater.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }
            }
            br = false;
           // System.out.println(curr);
            for(int j = 0; j < waterLight.size(); ++j){
                Map<Long, Map<Long, Long>> ma = waterLight.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }
            }
            br = false;
            //System.out.println(curr);
            for(int j = 0; j < lightTempe.size(); ++j){
                Map<Long, Map<Long, Long>> ma = lightTempe.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }
            }
            br = false;
            //System.out.println(curr);
            for(int j = 0; j < tempeHumidity.size(); ++j){
                Map<Long, Map<Long, Long>> ma = tempeHumidity.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }
            }
            br = false;
            //System.out.println(curr);
            for(int j = 0; j < humidityLocation.size(); ++j){
                Map<Long, Map<Long, Long>> ma = humidityLocation.get(j);
                for(Entry<Long, Map<Long, Long>> p : ma.entrySet()){
                    Long plage  = p.getKey();
                    for(Entry<Long, Long> s : p.getValue().entrySet()){
                        if(curr >= s.getKey() && curr < s.getKey() + plage){
                            Long t = s.getKey() - s.getValue();
                            if(t > 0){
                                curr  = curr - t;
                            }else if(t < 0){
                                curr = curr - t;
                            }
                            br = true;
                            break;
                        }
                    }
                    if(br){
                        break;
                    }
                }
                if(br){
                    break;
                }
            }
           // System.out.println(curr);
            if(curr < res){
              //  System.out.print("petit");
                res = curr;
            }
        }


        System.out.println(res);
    }


   
    public static void main(String[] args) throws Exception{
        System.out.print("Première partie : ");
        part1();
    }
}
