import java.security.SecureRandom;

public class RandomNumberGenerator {
    static SecureRandom random = new SecureRandom();
    static int generateRandomNumber(){
        return random.nextInt(Integer.MAX_VALUE);
    }
}
