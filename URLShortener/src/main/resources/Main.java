public class Main {
    public static void main(String[] args) {
        // Instantiate URLShortener
        URLShortener urlShortener = new URLShortener();

        // Generate a short URL for a sample original URL
        String originalURL = "https://www.example.com";
        String shortURL = urlShortener.shortenURL(originalURL);

        // Print the original and short URLs
        System.out.println("Original URL: " + originalURL);
        System.out.println("Shortened URL: " + shortURL);

        // Get the original URL from the short URL
        String retrievedURL = urlShortener.getOriginalURL(shortURL);
        System.out.println("Retrieved URL: " + retrievedURL);
    }
}