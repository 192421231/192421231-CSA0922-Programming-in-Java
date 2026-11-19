
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000};

        for (int n : sizes) {

            System.out.println("\nPlaylist Size: " + n);

            ArrayList<Integer> a = new ArrayList<>();
            LinkedList<Integer> l = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                a.add(i);
                l.add(i);
            }

            int mid = n / 2;
            int k = n / 2;

            // Add at end
            long start = System.nanoTime();
            a.add(999);
            long arrayAdd = System.nanoTime() - start;

            start = System.nanoTime();
            l.add(999);
            long linkedAdd = System.nanoTime() - start;

            // Insert at front
            start = System.nanoTime();
            a.add(0, 100);
            long arrayFront = System.nanoTime() - start;

            start = System.nanoTime();
            l.add(0, 100);
            long linkedFront = System.nanoTime() - start;

            // Insert in middle
            start = System.nanoTime();
            a.add(mid, 200);
            long arrayMiddle = System.nanoTime() - start;

            start = System.nanoTime();
            l.add(mid, 200);
            long linkedMiddle = System.nanoTime() - start;

            // Access kth element
            start = System.nanoTime();
            a.get(k);
            long arrayAccess = System.nanoTime() - start;

            start = System.nanoTime();
            l.get(k);
            long linkedAccess = System.nanoTime() - start;

            // Iterate through list
            start = System.nanoTime();
            for (int x : a) {
                int temp = x;
            }
            long arrayIterate = System.nanoTime() - start;

            start = System.nanoTime();
            for (int x : l) {
                int temp = x;
            }
            long linkedIterate = System.nanoTime() - start;

            System.out.println("Operation       ArrayList(ns)  LinkedList(ns)");
            System.out.println("Add End         " + arrayAdd + "          " + linkedAdd);
            System.out.println("Insert Front    " + arrayFront + "          " + linkedFront);
            System.out.println("Insert Middle   " + arrayMiddle + "          " + linkedMiddle);
            System.out.println("Access Kth      " + arrayAccess + "          " + linkedAccess);
            System.out.println("Iteration       " + arrayIterate + "          " + linkedIterate);
        }

        // ArrayDeque for Up Next queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(10);
        queue.addLast(20);
        queue.addFirst(5);

        System.out.println("\nUp Next Queue: " + queue);

        queue.removeFirst();

        System.out.println("After removing first song: " + queue);
    }
}
