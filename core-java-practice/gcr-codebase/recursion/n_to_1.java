class n_1 {
    public static void printDescending(int n) {
        if (n <= 0) {
            return;
        }
        System.out.print(n);
        if (n > 1) {
            System.out.print(" ");
        }
        printDescending(n - 1);
    }

    public static void main(String[] args) {
        int n = 10; // example value
        printDescending(n);
    }
}
