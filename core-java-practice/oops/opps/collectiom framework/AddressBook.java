import java.util.*;
class Contact implements Comparable<Contact> {
    String name;
    String phone;
    String email;
    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int compareTo(Contact c) {
        return this.name.compareToIgnoreCase(c.name);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> map = new HashMap<>();
    HashSet<String> phoneSet = new HashSet<>();
    public void addContact(String name, String phone, String email) {

        if (phoneSet.contains(phone)) {
            System.out.println("Phone number already exists.");
            return;
        }

        Contact c = new Contact(name, phone, email);

        contacts.add(c);
        map.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.");
    }
    public void searchContact(String name) {

        Contact c = map.get(name);

        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact not found.");
    }
    public void deleteContact(String name) {

        Contact c = map.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact Deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {

        Collections.sort(contacts);

        System.out.println("\nContacts:");

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        AddressBook book = new AddressBook();

        book.addContact("Rahul", "9876543210", "rahul@gmail.com");
        book.addContact("Aman", "9123456780", "aman@gmail.com");
        book.addContact("Priya", "9988776655", "priya@gmail.com");

        // Duplicate phone
        book.addContact("Riya", "9876543210", "riya@gmail.com");

        System.out.println();

        book.searchContact("Aman");

        System.out.println();

        book.deleteContact("Rahul");

        book.displayContacts();
    }
}

