import java.io.*; import java.util.*;
class Resident implements Serializable{
 private static final long serialVersionUID=1L;
 String name,registerNo,phoneNumber;
 transient String password;
 transient Object liveConnection;
}
class Room implements Serializable{
 private static final long serialVersionUID=1L; List<Resident> residents=new ArrayList<>();
}
class Hostel implements Serializable{
 private static final long serialVersionUID=1L; List<Room> rooms=new ArrayList<>();
}
public class HostelSnapshot{
 public static void main(String[] a)throws Exception{
  Hostel h=new Hostel(); Room rm=new Room(); Resident r=new Resident();
  r.name="Asha";r.registerNo="192311001";r.password="not-persisted";rm.residents.add(r);h.rooms.add(rm);
  try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("hostel.bin"))){o.writeObject(h);}
  try(ObjectInputStream i=new ObjectInputStream(new FileInputStream("hostel.bin"))){
   Hostel copy=(Hostel)i.readObject();
   System.out.println("Residents: "+copy.rooms.get(0).residents.size());
   System.out.println("Password restored: "+copy.rooms.get(0).residents.get(0).password);
  }
 }
}