import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class stack {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        Stack<String> stack = new Stack<>();
        stack.addAll(list);

        System.out.println("List: " + list);
        System.out.println("Stack: " + stack);
    }
}
