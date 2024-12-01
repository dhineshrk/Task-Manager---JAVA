// Real Image class
class RealImage {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy class
class ImageProxy {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        // Lazy loading: Load image only when needed
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client Code
public class ProxyPattern {
    public static void main(String[] args) {
        // Using Proxy for Image
        ImageProxy image1 = new ImageProxy("image1.jpg");
        ImageProxy image2 = new ImageProxy("image2.jpg");

        // Image is loaded and displayed only when needed
        image1.display(); // Image is loaded here
        image1.display(); // No need to load again, since proxy handles it

        image2.display(); // Image is loaded here
    }
}
