import java.sql.*;
import java.util.*;
interface Dao<T,K>{
 T insert(T v)throws SQLException; Optional<T> findById(K id)throws SQLException;
 List<T> findAll()throws SQLException; boolean update(T v)throws SQLException;
 boolean delete(K id)throws SQLException;
}
class Student{
 final String registerNo,name,email;
 Student(String r,String n,String e){registerNo=r;name=n;email=e;}
}
class StudentDao implements Dao<Student,String>{
 private final Connection con;
 StudentDao(Connection c){con=c;}
 public Student insert(Student s)throws SQLException{
  try(PreparedStatement p=con.prepareStatement("INSERT INTO student(register_no,name,email) VALUES(?,?,?)")){
   p.setString(1,s.registerNo);p.setString(2,s.name);p.setString(3,s.email);p.executeUpdate();return s;
  }
 }
 public Optional<Student> findById(String id)throws SQLException{
  try(PreparedStatement p=con.prepareStatement("SELECT register_no,name,email FROM student WHERE register_no=?")){
   p.setString(1,id);try(ResultSet r=p.executeQuery()){
    return r.next()?Optional.of(new Student(r.getString(1),r.getString(2),r.getString(3))):Optional.empty();
   }
  }
 }
 public List<Student> findAll()throws SQLException{
  List<Student> a=new ArrayList<>();
  try(Statement s=con.createStatement();ResultSet r=s.executeQuery("SELECT register_no,name,email FROM student")){
   while(r.next())a.add(new Student(r.getString(1),r.getString(2),r.getString(3)));
  }return a;
 }
 public boolean update(Student s)throws SQLException{
  try(PreparedStatement p=con.prepareStatement("UPDATE student SET name=?,email=? WHERE register_no=?")){
   p.setString(1,s.name);p.setString(2,s.email);p.setString(3,s.registerNo);return p.executeUpdate()==1;
  }
 }
 public boolean delete(String id)throws SQLException{
  try(PreparedStatement p=con.prepareStatement("DELETE FROM student WHERE register_no=?")){
   p.setString(1,id);return p.executeUpdate()==1;
  }
 }
}