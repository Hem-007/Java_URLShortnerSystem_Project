import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        URLShortenerService urlShortenerService = new URLShortenerService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== URL Shortener System ====");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Retrieve Original URL");
            System.out.println("3. Check if Short URL Exists");
            System.out.println("4. Display All URLs");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a long URL to shorten: ");
                    String longURL = scanner.nextLine();
                    String shortURL = urlShortenerService.ShortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;

                case 2:
                    System.out.print("Enter the short URL to retrieve original: ");
                    String inputShortURL = scanner.nextLine();
                    String originalURL = urlShortenerService.getOriginalURL(inputShortURL);
                    if (originalURL != null) {
                        System.out.println("Original URL: " + originalURL);
                    } else {
                        System.out.println("Short URL not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter the short URL to check: ");
                    String checkShortURL = scanner.nextLine();
                    boolean exists = urlShortenerService.isShortURLExists(checkShortURL);
                    System.out.println(exists ? "Short URL exists!" : "Short URL does not exist.");
                    break;

                case 4:
                    System.out.println("Displaying all stored URLs:");
                    urlShortenerService.displayAllURLs();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
