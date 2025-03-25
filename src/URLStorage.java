import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class URLStorage {

    private static final String DOMAIN = "https://short.ly/";
    Map<String ,String> shortToLongMap = new HashMap<>();
    Map<String ,String> longToShortMap = new HashMap<>();
    Map<String ,String> createdTimes = new HashMap<>();
    Map<String ,String> expiryTimes = new HashMap<>();
    File file = new File("urls.csv");

    public URLStorage() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            writeHeaders();
        } else if (file.length() == 0) {
            writeHeaders();
        }
        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                shortToLongMap.put(parts[0].substring(DOMAIN.length()),parts[1]);
                longToShortMap.put(parts[1],parts[0]);
                createdTimes.put(parts[1],parts[2]);
                expiryTimes.put(parts[1],parts[3]);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    Map<String,String> getShortToLongMap(){return shortToLongMap;}
    Map<String ,String> getLongToShortMap(){return longToShortMap;}

    void URLWriter(String shortURL, String longURL, LocalDateTime createAt,LocalDateTime expiresAt){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){

            bw.append(shortURL).append(",").append(longURL).append(",").append(createAt.toString()).append(",").append(expiresAt.toString());

            bw.newLine();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void writeHeaders() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.append("ShortURL,LongURL,CreatedAt,ExpiresAt");
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing headers: " + e.getMessage());
        }
    }


}
