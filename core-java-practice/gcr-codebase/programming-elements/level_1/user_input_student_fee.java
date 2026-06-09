import java.util.Scanner;

public class user_input_student_fee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input for fee
        System.out.print("Enter student fee: ");
        double fee = sc.nextDouble();
        
        // Take user input for discount percent
        System.out.print("Enter discount percent: ");
        double discountPercent = sc.nextDouble();
        
        // Compute the discount amount
        double discount = (fee * discountPercent) / 100;
        
        // Compute final discounted fee
        double finalFee = fee - discount;
        
        // Print the output
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        
        sc.close();
    }
}
