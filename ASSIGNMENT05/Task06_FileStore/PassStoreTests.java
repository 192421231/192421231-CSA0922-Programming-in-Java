import java.nio.file.*;import java.util.*;
// Helper test driver (added): exercises PassStore with the cases required in B1.1.
public class PassStoreTests{
 static void show(String label,String[] r){System.out.println(label+" -> "+(r==null?"null (not found)":Arrays.toString(r)));}
 public static void main(String[] a)throws Exception{
  Path missing=Path.of(System.getProperty("java.io.tmpdir"),"no-such-dir","none.csv");
  PassStore none=new PassStore(missing);
  System.out.println("TEST 0  missing file");
  show("  find(P1001)",none.find("P1001"));
  System.out.println("  listByRoute(7) size = "+none.listByRoute(7).size());
  Path f=Files.createTempFile("passes",".csv");PassStore s=new PassStore(f);
  s.add("P1001","192311001","Arun",12,4500);
  s.add("P1005","192311005","Asha, R.",7,3800);
  Files.writeString(f,"P1002,DAMAGED LINE\nP1004,192311004,Meera,7,not-a-number\n\n",StandardOpenOption.APPEND);
  s.add("P1003","192311003","Divya",7,3800);
  System.out.println("\nFile contents (cat):");
  for(String l:Files.readAllLines(f))System.out.println("  |"+l);
  System.out.println("\nTEST 1  normal find");show("  find(P1003)",s.find("P1003"));
  System.out.println("TEST 2  quoted comma name");show("  find(P1005)",s.find("P1005"));
  System.out.println("TEST 3  absent id");show("  find(P9999)",s.find("P9999"));
  System.out.println("TEST 4  damaged field count");show("  find(P1002)",s.find("P1002"));
  System.out.println("TEST 5  invalid amount");show("  find(P1004)",s.find("P1004"));
  System.out.println("TEST 6  route 7 listing");
  for(String[] r:s.listByRoute(7))System.out.println("  "+Arrays.toString(r));
  System.out.println("  count = "+s.listByRoute(7).size());
  Files.deleteIfExists(f);
 }
}
