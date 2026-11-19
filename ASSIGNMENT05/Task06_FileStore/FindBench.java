import java.nio.file.*;import java.util.*;
// Helper benchmark (added): linear-scan find() time vs number of records (B1.4).
public class FindBench{
 public static void main(String[] a)throws Exception{
  int[] ns={1000,10000,100000};
  System.out.println("records  run1_ms  run2_ms  run3_ms  median_ms");
  for(int n:ns){
   Path f=Files.createTempFile("bench",".csv");
   try(var w=Files.newBufferedWriter(f)){for(int i=1;i<=n;i++)w.write("P"+i+",19231"+i+",Student "+i+","+(i%20)+","+(1000+i%5000)+".0\n");}
   PassStore s=new PassStore(f);String target="P"+(n-1); // near end
   for(int i=0;i<20;i++)s.find(target); // warm-up
   long[] t=new long[3];
   for(int r=0;r<3;r++){long t0=System.nanoTime();for(int k=0;k<20;k++)s.find(target);t[r]=(System.nanoTime()-t0)/20;}
   long[] c=t.clone();Arrays.sort(c);
   System.out.printf("%-8d %-8.3f %-8.3f %-8.3f %.3f%n",n,t[0]/1e6,t[1]/1e6,t[2]/1e6,c[1]/1e6);
   Files.delete(f);
  }
 }
}
