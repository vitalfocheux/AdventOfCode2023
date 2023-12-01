import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AOC {

    public static List<String> parser(String path, String symbol){
        List<String> parser = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/" + path));
            String line;

            while ((line = br.readLine()) != null) {
                // Traitement de chaque ligne ici
                String[] parts = line.split(symbol); // Séparation avec '\n'
                for (String part : parts) {
                    parser.add(part);//System.out.println(part); // Affichage ou traitement de chaque partie séparée
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
