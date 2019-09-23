import java.util.Scanner;

public class initUI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //id
        System.out.print("ID: ");
        int idNum = input.nextInt();

        //
        System.out.print("Initial: ");
        String initial = input.next();

        //date
        System.out.print("Date (MM/DD/YYYY): ");
        String date = input.next();

        //Skill level
        System.out.print("Skill level: ");
        String skillLevel = input.next();

    }
}