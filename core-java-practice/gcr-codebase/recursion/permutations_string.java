class permutations_string {
    public static void main(String[] args) {
        String input = "ABC";
        if (args.length > 0) {
            input = args[0];
        }
        System.out.println("Permutations of " + input + ":");
        permute(input.toCharArray(), 0, input.length() - 1);
    }

    private static void permute(char[] chars, int left, int right) {
        if (left == right) {
            System.out.println(new String(chars));
            return;
        }
        for (int i = left; i <= right; i++) {
            swap(chars, left, i);
            permute(chars, left + 1, right);
            swap(chars, left, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
