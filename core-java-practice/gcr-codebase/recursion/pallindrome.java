import java.util.Scanner;
class pallindrome {
    public static boolean isPalindrome(int num) {
        return isPalindromeHelper(num, 0);
    }
     
    private static boolean isPalindromeHelper(int num, int reversed) {
        if (num == 0) {
            return reversed == 0;
        }
        
        reversed = reversed * 10 + num % 10;
        return isPalindromeHelper(num / 10, reversed);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
        sc.close();
    }
}
  
