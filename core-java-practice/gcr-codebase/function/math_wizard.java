//build a "Math Wizard"utility class: isPrime(n),factorial(n) using iteration,fibonacci(n),gcd(a,b),lcm(a,b),power(base,exp).
//Overload factorial to also accept double.Demonstrate scope between local and iinstance variables.Also take user input.

class math_wizard{
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double factorial(double n) {
        double result = 1;
        for (double i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public long fibonacci(int n) {
        if (n <= 1) return n;
        long prev2 = 0, prev1 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public double power(double base, double exp) {
        return Math.pow(base, exp);
    }
    public static void main(String[] args) {
        math_wizard mw = new math_wizard();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int primeCheck = scanner.nextInt();
        System.out.println(primeCheck + " is prime: " + mw.isPrime(primeCheck));

        System.out.print("Enter a number to calculate factorial (int): ");
        int factInt = scanner.nextInt();
        System.out.println("Factorial of " + factInt + " is: " + mw.factorial(factInt));

        System.out.print("Enter a number to calculate factorial (double): ");
        double factDouble = scanner.nextDouble();
        System.out.println("Factorial of " + factDouble + " is: " + mw.factorial(factDouble));

        System.out.print("Enter a number to calculate fibonacci: ");
        int fibNum = scanner.nextInt();
        System.out.println("Fibonacci of " + fibNum + " is: " + mw.fibonacci(fibNum));

        System.out.print("Enter two numbers to calculate GCD and LCM: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + mw.gcd(num1, num2));
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + mw.lcm(num1, num2));

        System.out.print("Enter base and exponent for power calculation: ");
        double base = scanner.nextDouble();
        double exp = scanner.nextDouble();
        System.out.println(base + "^" + exp + " is: " + mw.power(base, exp));

        scanner.close();
    }
}