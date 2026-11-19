import java.sql.*;
public class WalletTransfer{
 public static void transfer(Connection c,long from,long to,double amount)throws SQLException{
  if(amount<=0)throw new IllegalArgumentException("Amount must be positive");
  boolean old=c.getAutoCommit();c.setAutoCommit(false);
  try{
   try(PreparedStatement d=c.prepareStatement("UPDATE wallet SET balance=balance-? WHERE wallet_id=? AND balance>=?")){
    d.setDouble(1,amount);d.setLong(2,from);d.setDouble(3,amount);
    if(d.executeUpdate()!=1)throw new SQLException("Debit failed");
   }
   try(PreparedStatement cr=c.prepareStatement("UPDATE wallet SET balance=balance+? WHERE wallet_id=?")){
    cr.setDouble(1,amount);cr.setLong(2,to);if(cr.executeUpdate()!=1)throw new SQLException("Credit failed");
   }
   c.commit();
  }catch(SQLException|RuntimeException e){c.rollback();throw e;}
  finally{c.setAutoCommit(old);}
 }
}