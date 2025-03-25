import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Pattern;

public class URLShortenerService {

    private static final String DOMAIN = "https://short.ly/";
    private static final String URL_REGEX = "^(http://|https://)[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)+(/[^\\s]*)?(\\?[^\\s]*)?(#\\S*)?$";
    private int counter = RandomNumberGenerator.generateRandomNumber();

    private int random ;
    Base62Encoder base62Encoder = new Base62Encoder();
    URLStorage urlStorage;
    Map<String ,String> shortToLongMap;
    Map<String ,String> longToShortMap;

    public URLShortenerService() throws IOException {
        urlStorage = new URLStorage();
        shortToLongMap = urlStorage.getShortToLongMap();
        longToShortMap = urlStorage.getLongToShortMap();
    }


    String ShortenURL(String longURL){

        if(!isValidURL(longURL)){
            return "Invalid URL !";
        }
        if(longToShortMap.containsKey(longURL)){
            return longToShortMap.get(longURL);
        }

        String shortCode = base62Encoder.encode(counter++);
        String shortURL = DOMAIN + shortCode;

        shortToLongMap.put(shortCode,longURL);
        longToShortMap.put(longURL,shortURL);
        LocalDateTime createdAt = URLData.getCreatesAt();
        LocalDateTime expiresAt = URLData.getExpiresAt(createdAt);
        urlStorage.URLWriter(shortURL,longURL,createdAt,expiresAt);
        return shortURL;

    }
    String getOriginalURL(String shortURL){
        String shortCode;
        if(isValidURL(shortURL)){
            shortCode = shortURL.substring(DOMAIN.length());
        }
        else {
            shortCode = shortURL;
        }
        return shortToLongMap.get(shortCode);
    }

    void displayAllURLs(){
        System.out.println("Long To Short Map");
        System.out.println(longToShortMap);
        System.out.println("Short To Long Map");
        System.out.println(shortToLongMap);
    }

    boolean isValidURL(String originalURL){
        Pattern pattern = Pattern.compile(URL_REGEX);
        return pattern.matcher(originalURL).matches();
    }

    boolean isShortURLExists(String shortURL){
        return  longToShortMap.containsValue(shortURL);
    }

    void redirect(String shortURL) {
        if (!isValidURL(shortURL)) {
            System.out.println("Invalid Short URL!");
            return;
        }
        String shortCode = shortURL.substring(DOMAIN.length());

        if (!shortToLongMap.containsKey(shortCode)) {
            System.out.println("Short URL not found!");
            return;
        }

        String originalURL = shortToLongMap.get(shortCode);
        System.out.println("Redirecting to: " + originalURL);
    }

}
