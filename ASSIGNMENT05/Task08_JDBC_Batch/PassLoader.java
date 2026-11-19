import java.sql.*;import java.util.*;
public class PassLoader{
 public static int loadAll(Connection c,List<String[]> rows)throws SQLException{
  String q="INSERT INTO bus_pass(pass_id,reg_no,name,route_no,amount) VALUES(?,?,?,?,?)";
  boolean old=c.getAutoCommit();int count=0;c.setAutoCommit(false);
  try(PreparedStatement p=c.prepareStatement(q)){
   for(String[] x:rows){
    p.setString(1,x[0]);p.setString(2,x[1]);p.setString(3,x[2]);
    p.setInt(4,Integer.parseInt(x[3]));p.setDouble(5,Double.parseDouble(x[4]));
    p.addBatch();count++;if(count%1000==0)p.executeBatch();
   }
   if(count%1000!=0)p.executeBatch();c.commit();return count;
  }catch(SQLException|RuntimeException e){c.rollback();throw e;}
  finally{c.setAutoCommit(old);}
 }
}