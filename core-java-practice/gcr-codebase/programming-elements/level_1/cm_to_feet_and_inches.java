import java.util.Scanner;

public class cm_to_feet_and_inches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value.");
            sc.close();
            return;
        }

        double heightCm = sc.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches - feet * 12;

        System.out.println(
            "Your Height in cm is " + String.format("%.2f", heightCm) + " while in feet is " + feet + " and inches is " + String.format("%.2f", inches)
        );

        sc.close();
    }
}
