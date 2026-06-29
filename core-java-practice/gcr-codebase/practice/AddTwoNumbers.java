import java.util.Scanner;
public class AddTwoNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("the first number is:"+a);
        int b = scanner.nextInt();
        System.out.println("the second number is:"+b);
        int sum = a + b;
        System.out.println("the sum of add two numbers is:"+sum);
        scanner.close();
    }
}