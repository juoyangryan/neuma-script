import java.util.concurrent.TimeUnit;
import java.io.File; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Runs {

	private int idNum;
    private String initial, date, skillLevel;
	//0 - normal; 1 - Kinesthetic; 2 - Visual
	private int[] trialTypeArray = new int[24];
	private static final Random RAND = new Random();

	static File beep = new File("Censored_Beep.WAV");
		private static ArrayList<Integer> idList = new ArrayList<Integer>();
		private static ArrayList<String> initialList = new ArrayList<String>();
		private static ArrayList<String> dateList = new ArrayList<String>();
		private static ArrayList<String> skillList = new ArrayList<String>();
		private static ArrayList<Long> timeList = new ArrayList<Long>();


	public Runs() {
		Scanner input = new Scanner(System.in);

        //id
        System.out.print("ID: ");
        idNum = input.nextInt();
        idList.add(idNum);

        //initial
        System.out.print("Initial: ");
        initial = input.next();
        initialList.add(initial);

        //date
        System.out.print("Date (MM/DD/YYYY): ");
        date = input.next();
        dateList.add(date);

        //Skill level
        System.out.print("Skill level: ");
        skillLevel = input.next();
        skillList.add(skillLevel);

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


   public static ArrayList getIdList(){
       return idList;
   }
   public static ArrayList getInitialList(){
       return initialList;
   }
   public static ArrayList getDateList(){
       return dateList;
   }
   public static ArrayList getSkillList(){
       return skillList;
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

	//ArrayList<long> timeList = new ArrayList<long>();

	public void normalTrial() throws InterruptedException {

        //first beep sound indicating onset of the trial
        playSound(beep);
        long startTime = System.nanoTime();


		//position for 2 seconds
        TimeUnit.SECONDS.sleep(2);
		long posTime = System.nanoTime();
		timeList.add(posTime - startTime);

        //second beep sound ~0.5s
        playSound(beep);
        long beepTime = System.nanoTime();
        timeList.add(beepTime - startTime);

        //hit 1s
        TimeUnit.SECONDS.sleep(1);
        long hitTime = System.nanoTime();
        timeList.add(hitTime - startTime);


        //resting 1s
        TimeUnit.SECONDS.sleep(1);
        long restTime = System.nanoTime();
        timeList.add(restTime - startTime);

        //press key to next trial

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("The total time for trial in nanoseconds: " + timeElapsed);
        System.out.println("The total time for trial in milliseconds: " + timeElapsed / 1000000);

        System.out.println("End of Normal Experiment");
	}


	public void kineTrial() throws InterruptedException {
		//first beep sound indicating onset of the trial
		playSound(beep);
		long startTime = System.nanoTime();

		//position for 2 seconds
		TimeUnit.SECONDS.sleep(2);
		long posTime = System.nanoTime();
		timeList.add(posTime - startTime);


		//second beep sound ~0.5s
		playSound(beep);
        long beepTime = System.nanoTime();
        timeList.add(beepTime - startTime);
        runMotor();

		//vibration immediately after beep for 1s
		TimeUnit.SECONDS.sleep(1);
		turnOff();
        long restTime1 = System.nanoTime();
        timeList.add(restTime1 - startTime);


		//wait for vibration and hit ball
		TimeUnit.SECONDS.sleep(1);
        long hitTime1 = System.nanoTime();
        timeList.add(hitTime1 - startTime);


		System.out.println("Hit the ball after 2nd beep sound.");
		TimeUnit.SECONDS.sleep(1);
		long hitTime2 = System.nanoTime();
        timeList.add(hitTime2 - startTime);

		//resting 1s
		TimeUnit.SECONDS.sleep(1);
        long restTime2 = System.nanoTime();
        timeList.add(restTime2 - startTime);

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("The total time for trial in nanoseconds: " + timeElapsed);
        System.out.println("The total time for trial in milliseconds: " + timeElapsed / 1000000);

        System.out.println("End of Kinesthetic Experiment");
	}

	public void visualTrial() throws InterruptedException {
		//first beep sound indicating onset of the trial
		playSound(beep);
		long startTime = System.nanoTime();

		//position for 2 seconds
		TimeUnit.SECONDS.sleep(2);
		long posTime = System.nanoTime();
		timeList.add(posTime - startTime);


		//second beep sound ~0.5s
		playSound(beep);
        long beepTime = System.nanoTime();
        timeList.add(beepTime - startTime);
        runLight();
		//light immediately after beep for 1s
		TimeUnit.SECONDS.sleep(1);
		turnOff();

        long restTime1 = System.nanoTime();
        timeList.add(restTime1 - startTime);



		//wait for 2nd beep and hit ball
		TimeUnit.SECONDS.sleep(1);
        long hitTime1 = System.nanoTime();
        timeList.add(hitTime1 - startTime);


		System.out.println("Hit the ball after 2nd beep sound.");
		TimeUnit.SECONDS.sleep(1);
		long hitTime2 = System.nanoTime();
        timeList.add(hitTime2 - startTime);

		//resting 1s
		TimeUnit.SECONDS.sleep(1);
        long restTime2 = System.nanoTime();
        timeList.add(restTime2 - startTime);

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

    public void runMotor() {
    	try {
		new HC05().go(2);
		} catch (Exception ex) {
		Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    public void runLight() {
    	try {
		new HC05().go(1);
		} catch (Exception ex) {
		Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    public void turnOff() {
    	try {
		new HC05().go(0);
		} catch (Exception ex) {
		Logger.getLogger(HC05.class.getName()).log(Level.SEVERE, null, ex);
		}
    }    



    public static void main(String[] args) throws InterruptedException {
    	Runs run1 = new Runs();
    	run1.runTrials(run1);
    }
	
}
