import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
public class BinaryPassFormat {
  static void writeString(DataOutputStream out,String s)throws IOException {
    byte[] b=s.getBytes(StandardCharsets.UTF_8); out.writeInt(b.length); out.write(b);
  }
  static String readString(DataInputStream in)throws IOException {
    int n=in.readInt(); if(n<0||n>1_000_000) throw new IOException("Bad field length");
    byte[] b=in.readNBytes(n); if(b.length!=n) throw new EOFException("Truncated field");
    return new String(b,StandardCharsets.UTF_8);
  }
  public static void main(String[] args)throws Exception {
    Path p=Path.of("pass-record.bin");
    try(DataOutputStream o=new DataOutputStream(Files.newOutputStream(p))) {
      o.writeInt(1); writeString(o,"P1001"); writeString(o,"192311001");
      writeString(o,"Asha, R."); o.writeInt(7); writeString(o,"Main Gate");
      o.writeLong(20000L); o.writeDouble(3800.0);
    }
    try(DataInputStream in=new DataInputStream(Files.newInputStream(p))) {
      System.out.println("Version "+in.readInt()+", pass "+readString(in));
    }
  }
}