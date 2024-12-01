// Subsystem 1: TV
class TV {
    public void on() {
        System.out.println("TV is now ON");
    }
}

// Subsystem 2: DVDPlayer
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is now ON");
    }
}

// Subsystem 3: SoundSystem
class SoundSystem {
    public void on() {
        System.out.println("Sound System is now ON");
    }
}

// Facade: Simplified Interface for the Client
class HomeTheaterFacade {
    private TV tv;
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;

    public HomeTheaterFacade() {
        tv = new TV();
        dvdPlayer = new DVDPlayer();
        soundSystem = new SoundSystem();
    }

    // Method to turn on all devices for a complete home theater experience
    public void startMovie() {
        System.out.println("Starting movie...");
        tv.on();
        dvdPlayer.on();
        soundSystem.on();
    }
}

// Client Code
public class FascadePattern {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.startMovie(); // Start movie with a single method call
    }
}
