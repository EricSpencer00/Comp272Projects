// URLShortener.java
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {
    private Map<String, String> urlMap;

    public URLShortener() {
        this.urlMap = new HashMap<>();
    }

    public String shortenURL(String originalURL) {
        String shortURL = generateShortURL();
        urlMap.put(shortURL, originalURL);
        return shortURL;
    }

    public String getOriginalURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    public class URLShortener {
        // Assuming this class has been declared with other methods

        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private static final int SHORT_URL_LENGTH = 6;

        private String generateShortURL() {
            StringBuilder shortURL = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < SHORT_URL_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                shortURL.append(CHARACTERS.charAt(randomIndex));
            }

            return shortURL.toString();
        }
    }
}
