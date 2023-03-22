import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class SoundGame {
    private Clip clip;

    public void play(String filename) {
        try {
            File file = new File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }



    public void stop() {
        clip.stop();
        clip.close();
    }
}
