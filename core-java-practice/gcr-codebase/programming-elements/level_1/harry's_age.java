import java.util.Scanner;
class harrys_age {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int birthyear=2000;
        System.out.println("Enter the current year:");
        int currentyear=sc.nextInt();
        int age=currentyear-birthyear;
       
        System.out.println("Harry's age currently:"+age);
    }
}