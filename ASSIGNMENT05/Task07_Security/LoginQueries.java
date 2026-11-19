import java.sql.*;
public class LoginQueries{
 // Intentionally vulnerable: run only against a disposable local test database.
 static boolean unsafe(Connection c,String id,String pwd)throws SQLException{
  String q="SELECT COUNT(*) FROM users WHERE id='"+id+"' AND pwd='"+pwd+"'";
  try(Statement s=c.createStatement();ResultSet r=s.executeQuery(q)){r.next();return r.getInt(1)>0;}
 }
 static boolean safe(Connection c,String id,String suppliedPassword)throws SQLException{
  try(PreparedStatement p=c.prepareStatement("SELECT pwd_hash FROM users WHERE id=?")){
   p.setString(1,id);try(ResultSet r=p.executeQuery()){
    if(!r.next())return false;
    // Replace with a real Argon2id/bcrypt/PBKDF2 verifier.
    return PasswordVerifier.verify(suppliedPassword,r.getString(1));
   }
  }
 }
 interface PasswordVerifier{static boolean verify(String raw,String hash){return false;}}
}