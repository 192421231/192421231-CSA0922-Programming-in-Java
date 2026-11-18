
public class Main {

    // Using String
    static String usingString(int tickets, int fields) {
        String result = "";

        for (int i = 1; i <= tickets; i++) {
            String ticket = "";

            for (int j = 1; j <= fields; j++) {
                ticket = ticket + "Field" + j + "=" + j + ";";
            }

            result = result + ticket;
        }

        return result;
    }

    // Using StringBuilder
    static String usingStringBuilder(int tickets, int fields) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= tickets; i++) {
            StringBuilder ticket = new StringBuilder();

            for (int j = 1; j <= fields; j++) {
                ticket.append("Field").append(j)
                      .append("=").append(j).append(";");
            }

            result.append(ticket);
        }

        return result.toString();
    }

    // Using StringBuffer
    static String usingStringBuffer(int tickets, int fields) {
        StringBuffer result = new StringBuffer();

        for (int i = 1; i <= tickets; i++) {
            StringBuffer ticket = new StringBuffer();

            for (int j = 1; j <= fields; j++) {
                ticket.append("Field").append(j)
                      .append("=").append(j).append(";");
            }

            result.append(ticket);
        }

        return result.toString();
    }

    static void test(String name, int tickets, int fields) {

        long start = System.nanoTime();
        String a = usingString(tickets, fields);
        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        String b = usingStringBuilder(tickets, fields);
        long builderTime = System.nanoTime() - start;

        start = System.nanoTime();
        String c = usingStringBuffer(tickets, fields);
        long bufferTime = System.nanoTime() - start;

        System.out.println("\n" + name);
        System.out.println("Tickets: " + tickets);
        System.out.println("Fields: " + fields);

        System.out.println("String Time: " + stringTime + " ns");
        System.out.println("StringBuilder Time: " + builderTime + " ns");
        System.out.println("StringBuffer Time: " + bufferTime + " ns");

        System.out.println("All outputs equal: "
                + (a.equals(b) && b.equals(c)));
    }

    public static void main(String[] args) {

        test("Small Workload", 1, 10);

        test("Large Workload", 10000, 50);

        test("Additional Workload", 5000, 30);
    }
}
