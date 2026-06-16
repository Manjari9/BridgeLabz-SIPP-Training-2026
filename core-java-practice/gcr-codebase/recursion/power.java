class power {
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / power(x, -n);
        }
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(power(x, n));
    }
}
