import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class musicStuff {
    private static AudioInputStream audioInput;
    private static Clip clip;

    public static void playMusic(String loc)
    {


        try{
            File musicPath = new File(loc);
            if(musicPath.exists())
            {
                audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);




            }
            else {
                System.out.println("cant find");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }


    public static void stopPlaying()
    {
        clip.stop();
    }
}
