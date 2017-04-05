import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ricardo on 30/03/2017.
 */
public class Leitor {

    public static String read(String path) {
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null)
                builder.append(line + "\n");
            br.close();
        }catch(IOException ignored){
            ignored.printStackTrace();
        }
        return builder.toString();
    }

}
