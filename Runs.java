import java.util.concurrent.TimeUnit;
import java.io.File; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.util.Scanner;


public class Runs {

	private int idNum;
    private String initial, date, skillLevel;
	//0 - normal; 1 - Kinesthetic; 2 - Visual
	private int[] trialTypeArray = new int[24];
	private static final Random RAND = new Random();

	static File beep = new File("Censored_Beep.WAV");

	public Runs() {
		Scanner input = new Scanner(System.in);

        //id
        System.out.print("ID: ");
        idNum = input.nextInt();

        //initial
        System.out.print("Initial: ");
        initial = input.next();

        //date
        System.out.print("Date (MM/DD/YYYY): ");
        date = input.next();

        //Skill level
        System.out.print("Skill level: ");
        skillLevel = input.next();

        //implements randomized kinesthetic and visual trials (4 of each)
        int kineSet = 0;
		int visualSet = 0;
		while (kineSet < 6) {
			int index = RAND.nextInt(24);
			if (trialTypeArray[index] == 0) {
				trialTypeArray[index] = 1;
				kineSet++;
			}
		}

		while (visualSet < 6) {
			int index = RAND.nextInt(24);
			if (trialTypeArray[index] == 0) {
				trialTypeArray[index] = 2;
				visualSet++;
			}
		}
	}

	public void runTrials(Runs run) throws InterruptedException {

		for (int i = 0; i < 25; i++) {
			if (trialTypeArray[i] == 0) {
				run.normalTrial();
			} else if (trialTypeArray[i] == 1) {
				run.kineTrial();
			} else {
				run.visualTrial();
			}
		}
	}

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

    public static void main(String[] args) throws InterruptedException {
    	Runs run1 = new Runs();
    	run1.runTrials(run1);
    }
	
}