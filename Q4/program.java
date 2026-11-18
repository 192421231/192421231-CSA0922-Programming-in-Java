
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        for (int n : sizes) {

            HashMap<Integer, String> hashMap = new HashMap<>();
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

            for (int i = 1; i <= n; i++) {
                String medicine = "Medicine" + i;

                hashMap.put(i, medicine);
                treeMap.put(i, medicine);
                linkedMap.put(i, medicine);
            }

            // Lookup test
            long start = System.nanoTime();

            for (int i = 0; i < 100000; i++) {
                hashMap.get((i % n) + 1);
            }

            long hashTime = System.nanoTime() - start;

            start = System.nanoTime();

            for (int i = 0; i < 100000; i++) {
                treeMap.get((i % n) + 1);
            }

            long treeTime = System.nanoTime() - start;

            start = System.nanoTime();

            for (int i = 0; i < 100000; i++) {
                linkedMap.get((i % n) + 1);
            }

            long linkedTime = System.nanoTime() - start;

            // Report generation
            start = System.nanoTime();
            String hashReport = hashMap.toString();
            long hashReportTime = System.nanoTime() - start;

            start = System.nanoTime();
            String treeReport = treeMap.toString();
            long treeReportTime = System.nanoTime() - start;

            start = System.nanoTime();
            String linkedReport = linkedMap.toString();
            long linkedReportTime = System.nanoTime() - start;

            System.out.println("\nNumber of Medicines: " + n);

            System.out.println("Lookup Time:");
            System.out.println("HashMap: " + hashTime);
            System.out.println("TreeMap: " + treeTime);
            System.out.println("LinkedHashMap: " + linkedTime);

            System.out.println("Report Time:");
            System.out.println("HashMap: " + hashReportTime);
            System.out.println("TreeMap: " + treeReportTime);
            System.out.println("LinkedHashMap: " + linkedReportTime);
        }

        // Display ordering
        HashMap<Integer, String> h = new HashMap<>();
        TreeMap<Integer, String> t = new TreeMap<>();
        LinkedHashMap<Integer, String> l = new LinkedHashMap<>();

        int[] codes = {103, 101, 102};

        for (int code : codes) {
            h.put(code, "Medicine" + code);
            t.put(code, "Medicine" + code);
            l.put(code, "Medicine" + code);
        }

        System.out.println("\nHashMap: " + h);
        System.out.println("TreeMap: " + t);
        System.out.println("LinkedHashMap: " + l);
    }
}
