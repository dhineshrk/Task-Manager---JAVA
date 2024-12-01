// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee
class VlcPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter
class VlcPlayerAdapter implements MediaPlayer {
    private VlcPlayer vlcPlayer;

    public VlcPlayerAdapter(VlcPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else {
            System.out.println("Error: Unsupported audio type.");
        }
    }
}

// Client Code
public class AdapterPattern {
    public static void main(String[] args) {
        VlcPlayer vlcPlayer = new VlcPlayer();
        MediaPlayer mediaPlayer = new VlcPlayerAdapter(vlcPlayer);

        mediaPlayer.play("vlc", "example.vlc"); // Output: Playing VLC file: example.vlc
    }
}
