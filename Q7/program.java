
public class Main {

    // Original solution using String
    static String usingString(int tickets) {

        String result = "";

        for (int i = 1; i <= tickets; i++) {
            result = result + "PNR" + i
                    + " Passenger" + i
                    + " Coach A1"
                    + " Berth 10"
                    + " Fare 500"
                    + " Journey Chennai";
        }

        return result;
    }

    // Redesigned solution using StringBuilder
    static String usingStringBuilder(int tickets) {

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= tickets; i++) {
            result.append("PNR").append(i)
                  .append(" Passenger").append(i)
                  .append(" Coach A1")
                  .append(" Berth 10")
                  .append(" Fare 500")
                  .append(" Journey Chennai");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int tickets = 10000;

        // Warm-up
        usingString(100);
        usingStringBuilder(100);

        // Original method
        long start = System.nanoTime();
        String oldResult = usingString(tickets);
        long oldTime = System.nanoTime() - start;

        // Redesigned method
        start = System.nanoTime();
        String newResult = usingStringBuilder(tickets);
        long newTime = System.nanoTime() - start;

        System.out.println("Total Tickets: " + tickets);

        System.out.println("\nOriginal String Method");
        System.out.println("Execution Time: " + oldTime + " ns");

        System.out.println("\nRedesigned StringBuilder Method");
        System.out.println("Execution Time: " + newTime + " ns");

        System.out.println("\nOriginal Output Length: "
                + oldResult.length());

        System.out.println("Redesigned Output Length: "
                + newResult.length());

        System.out.println("\nBoth outputs are equal: "
                + oldResult.equals(newResult));
    }
}
