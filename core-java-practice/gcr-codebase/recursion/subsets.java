import java.util.ArrayList;
import java.util.List;

class subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = generateSubsets(arr);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        buildSubsets(arr, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    static void buildSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == arr.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        buildSubsets(arr, index + 1, current, subsets);
        current.add(arr[index]);
        buildSubsets(arr, index + 1, current, subsets);
        current.remove(current.size() - 1);
    }
}
