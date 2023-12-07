

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class jour5_2 {

    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/txt/jour5.txt"))){

            Map<String, Converter> converters = new HashMap<>();
            List<Long> seeds = new ArrayList<>();

            Converter currentConverter = null;

            for (String line : br.lines().toList()) {
                if (line.isBlank()) continue;
                if (line.startsWith("seeds:")) {
                    for (String seed : line.replace("seeds:", "").trim().split(" ")) {
                        seeds.add(Long.parseLong(seed));
                    }
                } else {
                    if(line.matches("^\\d.*")) {
                        currentConverter.addRange(line);
                    } else {
                        String[] parts = line.split("-");
                        currentConverter = new Converter(parts[0], parts[2].replace("map:", "").trim());
                        converters.put(parts[0], currentConverter);
                    }
                }
            }

            ExecutorService fixedPool = Executors.newFixedThreadPool(10);

            for (int i = 0; i < seeds.size(); i += 2) {
                long start = seeds.get(i);
                long len = seeds.get(i + 1);
                fixedPool.submit(new TestThread(start, len, converters));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}