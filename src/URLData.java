import java.time.LocalDateTime;
public class URLData {
    static LocalDateTime getCreatesAt(){return LocalDateTime.now();}

    static LocalDateTime getExpiresAt(LocalDateTime createAt){return createAt.plusSeconds(300);}

}
