import java.io.*;
import java.nio.file.*;
public class LineCounter {
  static long count(Path p,boolean buffered)throws IOException {
    long lines=0; byte[] b=new byte[64*1024]; int n;
    try(InputStream raw=Files.newInputStream(p);
        InputStream in=buffered?new BufferedInputStream(raw,b.length):raw) {
      if(buffered) {
        while((n=in.read(b))!=-1) for(int i=0;i<n;i++) if(b[i]=='\n') lines++;
      } else {
        int c; while((c=in.read())!=-1) if(c=='\n') lines++;
      }
    } return lines;
  }
  public static void main(String[] a)throws Exception {
    if(a.length!=1){System.out.println("Usage: java LineCounter file");return;}
    Path p=Path.of(a[0]); long t=System.nanoTime(); long x=count(p,false); long u=System.nanoTime();
    long y=count(p,true); long v=System.nanoTime();
    System.out.printf("Unbuffered %d lines %.3f ms%n",x,(u-t)/1e6);
    System.out.printf("Buffered   %d lines %.3f ms%n",y,(v-u)/1e6);
  }
}