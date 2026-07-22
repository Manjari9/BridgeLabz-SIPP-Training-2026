//1) Build a generic Pair<T, U> class and a generic Stack<T>. Write a
//generic method findMax(T[] arr) bounded to Comparable. Create a
//generic Repository<T> that stores any entity type. Demonstrate
//wildcard List<?> for a utility print method.
//Using Generics effectively ensures type safety, reusability, and maintainability in Java applications.

import java.util.*;

// Generic Pair<T, U> class
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }
}

// Generic Stack<T> class
class Stack<T> {
    private List<T> elements = new ArrayList<>();

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

// Generic Repository<T> class
class Repository<T> {
    private List<T> entities = new ArrayList<>();

    public void add(T entity) {
        entities.add(entity);
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    public int count() {
        return entities.size();
    }
}

// Utility class with generic methods
class GenericUtils {
    // Generic method with bounded type parameter
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    // Utility method demonstrating wildcard List<?>
    public static void printList(List<?> list) {
        System.out.println("List contents:");
        for (Object element : list) {
            System.out.println("  " + element);
        }
    }
}

// Main class to demonstrate generics
public class GenericsDemo {
    public static void main(String[] args) {
        // Demonstrate Pair<T, U>
        System.out.println("=== Pair<T, U> Demo ===");
        Pair<String, Integer> pair1 = new Pair<>("John", 25);
        Pair<Double, String> pair2 = new Pair<>(3.14, "Pi");
        System.out.println(pair1);
        System.out.println(pair2);

        // Demonstrate Stack<T>
        System.out.println("\n=== Stack<T> Demo ===");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Stack peek: " + intStack.peek());
        System.out.println("Stack pop: " + intStack.pop());
        System.out.println("Stack size: " + intStack.size());

        // Demonstrate findMax with bounded type
        System.out.println("\n=== findMax<T extends Comparable<T>> Demo ===");
        Integer[] numbers = {5, 15, 3, 42, 8};
        System.out.println("Max of integers: " + GenericUtils.findMax(numbers));

        String[] strings = {"apple", "banana", "cherry", "date"};
        System.out.println("Max of strings: " + GenericUtils.findMax(strings));

        // Demonstrate Repository<T>
        System.out.println("\n=== Repository<T> Demo ===");
        Repository<String> stringRepo = new Repository<>();
        stringRepo.add("Java");
        stringRepo.add("Python");
        stringRepo.add("C++");
        System.out.println("String Repository count: " + stringRepo.count());

        Repository<Double> doubleRepo = new Repository<>();
        doubleRepo.add(1.5);
        doubleRepo.add(2.7);
        System.out.println("Double Repository count: " + doubleRepo.count());

        // Demonstrate wildcard List<?> with printList method
        System.out.println("\n=== Wildcard List<?> Demo ===");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        GenericUtils.printList(intList);

        List<String> strList = Arrays.asList("Hello", "World", "Generics");
        GenericUtils.printList(strList);

        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        GenericUtils.printList(doubleList);
    }
}
