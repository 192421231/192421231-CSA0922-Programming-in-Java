import java.io.*;import java.nio.charset.StandardCharsets;import java.nio.file.*;import java.util.*;
public class PassStore{
 private final Path file; public PassStore(Path f){file=f;}
 private static String quote(String s){return s.matches(".*[,\"\n\\r].*")?"\""+s.replace("\"","\"\"")+"\"":s;}
 private static List<String> parse(String line)throws IOException{
  List<String> out=new ArrayList<>();StringBuilder b=new StringBuilder();boolean q=false;
  for(int i=0;i<line.length();i++){char c=line.charAt(i);
   if(q){if(c=='"'&&i+1<line.length()&&line.charAt(i+1)=='"'){b.append('"');i++;}
    else if(c=='"')q=false;else b.append(c);}
   else if(c==',' ){out.add(b.toString());b.setLength(0);}
   else if(c=='"'&&b.length()==0)q=true;else b.append(c);
  }if(q)throw new IOException("Unclosed quote");out.add(b.toString());return out;
 }
 public void add(String id,String reg,String name,int route,double amount)throws IOException{
  Path parent=file.toAbsolutePath().getParent();if(parent!=null)Files.createDirectories(parent);
  try(BufferedWriter w=Files.newBufferedWriter(file,StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
   w.write(String.join(",",quote(id),quote(reg),quote(name),""+route,""+amount));w.newLine();
  }
 }
 private static boolean valid(List<String> f){
  if(f.size()!=5||f.get(0).isBlank()||f.get(1).isBlank())return false;
  try{Integer.parseInt(f.get(3));double a=Double.parseDouble(f.get(4));return Double.isFinite(a)&&a>=0;}
  catch(NumberFormatException e){return false;}
 }
 public String[] find(String id)throws IOException{
  if(!Files.exists(file))return null;
  try(BufferedReader r=Files.newBufferedReader(file,StandardCharsets.UTF_8)){
   String line;while((line=r.readLine())!=null)try{List<String> f=parse(line);if(valid(f)&&f.get(0).equals(id))return f.toArray(new String[0]);}catch(IOException ignored){}
  }return null;
 }
 public List<String[]> listByRoute(int route)throws IOException{
  List<String[]> out=new ArrayList<>();if(!Files.exists(file))return out;
  try(BufferedReader r=Files.newBufferedReader(file,StandardCharsets.UTF_8)){
   String line;while((line=r.readLine())!=null)try{List<String> f=parse(line);if(valid(f)&&Integer.parseInt(f.get(3))==route)out.add(f.toArray(new String[0]));}catch(Exception ignored){}
  }return out;
 }
 public static void main(String[] a)throws Exception{
  Path f=Files.createTempFile("passes",".csv");PassStore s=new PassStore(f);
  s.add("P1001","192311001","Arun",12,4500);
  Files.writeString(f,"P1002,DAMAGED LINE\nP1004,192311004,Meera,7,bad\n",StandardOpenOption.APPEND);
  s.add("P1003","192311003","Divya",7,3800);
  System.out.println(Arrays.toString(s.find("P1003")));
  System.out.println(Arrays.toString(s.find("P1002")));
  System.out.println("Route 7 count: "+s.listByRoute(7).size());
  Files.deleteIfExists(f);
 }
}