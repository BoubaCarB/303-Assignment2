import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Objects for testing
        SingleLinkedList<String> list = new SingleLinkedList<>();
        IntStack stack = new IntStack();

        int mainChoice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Test SingleLinkedList");
            System.out.println("2. Test IntStack");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            mainChoice = input.nextInt();
            input.nextLine();

            
            // LINKED LIST MENU
            if (mainChoice == 1) {

                int choice;

                do {
                    System.out.println("\nLinked List Menu");
                    System.out.println("1. addFirst");
                    System.out.println("2. addLast");
                    System.out.println("3. removeFirst");
                    System.out.println("4. removeLast");
                    System.out.println("5. getFirst");
                    System.out.println("6. getLast");
                    System.out.println("7. isEmpty");
                    System.out.println("8. insert at index");
                    System.out.println("9. remove at index");
                    System.out.println("10. find item");
                    System.out.println("11. display list");
                    System.out.println("12. size");
                    System.out.println("0. Back");

                    System.out.print("Choice: ");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter value: ");
                            String val1 = input.nextLine();
                            list.addFirst(val1);
                            System.out.println("List: " + list);
                            break;

                        case 2:
                            System.out.print("Enter value: ");
                            String val2 = input.nextLine();
                            list.addLast(val2);
                            System.out.println("List: " + list);
                            break;

                        case 3:
                            System.out.println("Removed: " + list.removeFirst());
                            System.out.println("List: " + list);
                            break;

                        case 4:
                            System.out.println("Removed: " + list.removeLast());
                            System.out.println("List: " + list);
                            break;

                        case 5:
                            System.out.println("First: " + list.getFirst());
                            break;

                        case 6:
                            System.out.println("Last: " + list.getLast());
                            break;

                        case 7:
                            System.out.println("isEmpty: " + list.isEmpty());
                            break;

                        case 8:
                            System.out.print("Enter index: ");
                            int idx = input.nextInt();
                            input.nextLine();

                            System.out.print("Enter value: ");
                            String item = input.nextLine();

                            list.insert(idx, item);
                            System.out.println("List: " + list);
                            break;

                        case 9:
                            System.out.print("Enter index: ");
                            int r = input.nextInt();
                            input.nextLine();

                            System.out.println("Removed: " + list.remove(r));
                            System.out.println("List: " + list);
                            break;

                        case 10:
                            System.out.print("Enter value to find: ");
                            String f = input.nextLine();
                            System.out.println("Index: " + list.find(f));
                            break;

                        case 11:
                            System.out.println("List: " + list);
                            break;

                        case 12:
                            System.out.println("Size: " + list.size());
                            break;

                    }

                } while (choice != 0);

            }

    
            // STACK MENU
    
            else if (mainChoice == 2) {

                int choice;

                do {
                    System.out.println("\n--- Stack Menu ---");
                    System.out.println("1. push");
                    System.out.println("2. pop");
                    System.out.println("3. peek");
                    System.out.println("4. isEmpty");
                    System.out.println("5. size");
                    System.out.println("6. average");
                    System.out.println("7. display stack");
                    System.out.println("0. Back");

                    System.out.print("Choice: ");
                    choice = input.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter integer: ");
                            int v = input.nextInt();
                            stack.push(v);
                            System.out.println("Stack: " + stack);
                            break;

                        case 2:
                            try {
                                System.out.println("Popped: " + stack.pop());
                            } catch (Exception e) {
                                System.out.println("Stack empty");
                            }
                            break;

                        case 3:
                            try {
                                System.out.println("Top: " + stack.peek());
                            } catch (Exception e) {
                                System.out.println("Stack empty");
                            }
                            break;

                        case 4:
                            System.out.println("isEmpty: " + stack.isEmpty());
                            break;

                        case 5:
                            System.out.println("Size: " + stack.size());
                            break;

                        case 6:
                            try {
                                System.out.println("Average: " + stack.average());
                            } catch (Exception e) {
                                System.out.println("Stack empty");
                            }
                            break;

                        case 7:
                            System.out.println("Stack: " + stack);
                            break;

                    }

                } while (choice != 0);

            }

        } while (mainChoice != 0);

        input.close();
    }

}


  // Singly Linked list class
class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void addFirst(T item) {

        Node<T> n = new Node<>(item);

        if (size == 0) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }

        size++;
    }

    public void addLast(T item) {

        Node<T> n = new Node<>(item);

        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }

        size++;
    }

    public T removeFirst() {

        if (size == 0) return null;

        T val = head.data;
        head = head.next;

        size--;

        if (size == 0) tail = null;

        return val;
    }

    public T removeLast() {

        if (size == 0) return null;

        if (size == 1) {
            T val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node<T> current = head;

        while (current.next != tail)
            current = current.next;

        T val = tail.data;

        tail = current;
        tail.next = null;

        size--;

        return val;
    }

    public T getFirst() {
        if (size == 0) return null;
        return head.data;
    }

    public T getLast() {
        if (size == 0) return null;
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, T item) {

        if (index <= 0) {
            addFirst(item);
            return;
        }

        if (index >= size) {
            addLast(item);
            return;
        }

        Node<T> newNode = new Node<>(item);
        Node<T> cur = head;

        for (int i = 0; i < index - 1; i++)
            cur = cur.next;

        newNode.next = cur.next;
        cur.next = newNode;

        size++;
    }

    public boolean remove(int index) {

        if (index < 0 || index >= size)
            return false;

        if (index == 0) {
            removeFirst();
            return true;
        }

        Node<T> cur = head;

        for (int i = 0; i < index - 1; i++)
            cur = cur.next;

        if (cur.next == tail)
            tail = cur;

        cur.next = cur.next.next;

        size--;

        return true;
    }

    public int find(T item) {

        Node<T> cur = head;
        int index = 0;

        while (cur != null) {

            if (cur.data.equals(item))
                return index;

            cur = cur.next;
            index++;
        }

        return size;
    }

    public int size() {
        return size;
    }

    public String toString() {

        StringBuilder s = new StringBuilder();

        Node<T> cur = head;

        while (cur != null) {

            s.append(cur.data);

            if (cur.next != null)
                s.append(" -> ");

            cur = cur.next;
        }

        return s.toString();
    }
}



   // IntStack Class 
class IntStack {

    private ArrayList<Integer> stack;

    public IntStack() {
        stack = new ArrayList<>();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {

        if (stack.isEmpty())
            throw new NoSuchElementException();

        return stack.remove(stack.size() - 1);
    }

    public int peek() {

        if (stack.isEmpty())
            throw new NoSuchElementException();

        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public double average() {

        if (stack.isEmpty())
            throw new NoSuchElementException();

        int sum = 0;

        for (int x : stack)
            sum += x;

        return (double) sum / stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}