import java.io.File; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BeepSound {
    File beep = new File("Censored_Beep.WAV");
    public static void main(String[] args) {
        File beep = new File("Censored_Beep.WAV");
        playSound(beep);
    }

    static void playSound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 200);
            System.out.print(clip.getMicrosecondLength());
        } catch(Exception e) {

        }
    }
    
}