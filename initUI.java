import java.util.Scanner;

public class initUI {
    protected int idNum;
    protected String initial, date, skillLevel;
    
    public initUI() {
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
    }
}