import java.util.concurrent.TimeUnit;
import java.io.File; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Runs{

	static File beep = new File("Censored_Beep.WAV");

	public void normalTrial() throws InterruptedException {

        long startTime = System.nanoTime();
        //first beep sound indicating onset of the trial
        playSound(beep);

		//position for 2 seconds
        TimeUnit.SECONDS.sleep(2);

        //second beep sound ~0.5s
        playSound(beep);

        //hit 1s
        TimeUnit.SECONDS.sleep(1);

        //resting 1s
        TimeUnit.SECONDS.sleep(1);

        //press key to next trial


        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("The total time for trial in nanoseconds: " + timeElapsed);
        System.out.println("The total time for trial in milliseconds: " + timeElapsed / 1000000);

        System.out.println("End of Normal Experiment");
	}


	public void kineTrial() throws InterruptedException {
		long startTime = System.nanoTime();
		//first beep sound indicating onset of the trial
		playSound(beep);

		//position for 2 seconds
		TimeUnit.SECONDS.sleep(2);

		//second beep sound ~0.5s
		playSound(beep);

		//vibration immediately after beep for 1s
		TimeUnit.SECONDS.sleep(1);

		//wait for 2nd beep and hit ball
		TimeUnit.SECONDS.sleep(1);

		System.out.println("Hit the ball after 2nd beep sound.");
		TimeUnit.SECONDS.sleep(1);

		//resting 1s
		TimeUnit.SECONDS.sleep(1);


		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;

		System.out.println("The total time for trial in nanoseconds: " + timeElapsed);
        System.out.println("The total time for trial in milliseconds: " + timeElapsed / 1000000);

        System.out.println("End of Kinesthetic Experiment");
	}

	public void visualTrial() throws InterruptedException {
		long startTime = System.nanoTime();
		//first beep sound indicating onset of the trial
		playSound(beep);

		//position for 2 seconds
		TimeUnit.SECONDS.sleep(2);

		//second beep sound ~0.5s
		playSound(beep);

		//vibration immediately after beep for 1s
		TimeUnit.SECONDS.sleep(1);

		//wait for 2nd beep and hit ball
		TimeUnit.SECONDS.sleep(1);

		System.out.println("Hit the ball after 2nd beep sound.");
		TimeUnit.SECONDS.sleep(1);

		//resting 1s
		TimeUnit.SECONDS.sleep(1);


		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;

		System.out.println("The total time for trial in nanoseconds: " + timeElapsed);
        System.out.println("The total time for trial in milliseconds: " + timeElapsed / 1000000);

        System.out.println("End of Visual Experiment");
	}

	static void playSound(File Sound) {
        try {
        	Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 200);
        } catch(Exception e) {

        }
    }

	
}