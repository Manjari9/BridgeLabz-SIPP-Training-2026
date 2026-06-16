import java.util.Scanner;

class n_fibonacci_number {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            return;
        }
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
