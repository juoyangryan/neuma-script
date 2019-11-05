import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test extends Runs{
	    public static void main(String[] args) throws InterruptedException {
    	Runs run1 = new Runs();
    	run1.runTrials(run1);
    	PrintWriter pw;
		try {
			pw = new PrintWriter(new File("Runs.csv"));
			StringBuffer csvHeader = new StringBuffer("");
			StringBuffer csvData = new StringBuffer("");
			csvHeader.append("ID, Initial, Date, Skill, Time \n");
			//pw.write(csvHeader.toString()); //write header

			int j = 0;
			for (int i = 0; i < getIdListSize(); i++) {
				csvData.append(getIdList().get(i));
				csvData.append(",");
				csvData.append(getInitialList().get(i));
				csvData.append(",");
				csvData.append(getDateList().get(i));
				csvData.append(",");
				csvData.append(getSkillList().get(i));
				// csvData.append(",");
				// csvData.append(timeList.get(i) / 1000000000);
				// csvData.append(",");
				// for (int m = 0; m < timeList.size(); m++) {
				// 	csvData.append(timeList.get(0) / 1000000000);
				// 	csvData.append(",");
				// 	timeList.remove(0);
				// 	if (m == 143) {
				// 		csvData.append(timeList.get(j));
				// 	}
				// }
			}
			csvData.append("\n\n"); //new row
			csvData.append("No., Type of Trial, Time \n");
			pw.write(csvHeader.toString()); //write header
			int l = 0;

			for (int m = 0; m < 24; m++) {
				if (run1.getTrialTypeArray()[m] == 0) {
					csvData.append(m+1);
					csvData.append(",");
					csvData.append("Normal");
					csvData.append(",");

					for (int n = 0; n < 5; n++) {
						csvData.append(timeList.get(0) / 1000000000.0);
						csvData.append(",");
						timeList.remove(0);
					}
					csvData.append("\n");
				} else if (run1.getTrialTypeArray()[m] == 1) {
					csvData.append(m+1);
					csvData.append(",");

					csvData.append("Kinesthetic");
					csvData.append(",");

					for (int n = 0; n < 7; n++) {
						csvData.append(timeList.get(0) / 1000000000.0);
						csvData.append(",");
						timeList.remove(0);
					}
					csvData.append("\n");
				} else {
					csvData.append(m+1);
					csvData.append(",");					
					csvData.append("Visual");
					csvData.append(",");

					for (int n = 0; n < 7; n++) {
						csvData.append(timeList.get(0) / 1000000000.0);
						csvData.append(",");
						timeList.remove(0);
					}
					csvData.append("\n");
				}
			}
			pw.write(csvData.toString());
			pw.close();
			System.out.println("Finished");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
