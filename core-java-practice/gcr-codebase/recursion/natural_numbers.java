class natural_numbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumNatural(n));
    }

    static int sumNatural(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumNatural(n - 1);
    }
}
