
package org.silverolympics.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.Map;
import org.silverolympics.bean.UserAccount;

/**
 *
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 */
public class DataBaseDao {
    private String url="jdbc:mysql://localhost:3306/silver_schema";
    private String uname="root";
    private String pass="Silv3rQuestions42";
    public Connection con;
    /**
     * Constructor method 
     */
    public DataBaseDao() {
        super();
    }
    public Connection getCon(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection(url, uname,pass);
        } 
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        } 
        catch (SQLException e) {

        e.printStackTrace();
        }
        return con;
    }
    
    //for register user 

    /**
     * (For registration/ signing up)
     * Takes care of inserting a new user's credentials into the user database
     * @param user the current user account that is currently being created
     * @param con the connection instance to the database
     * @return boolean indicating whether inserting the new user's information into the database succeeded or not
     */
    public boolean saveregisteredUser(UserAccount user, Connection con){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(id,username,password) values(?,?,?)";
            //int id_user = DataBaseDao.number_users();
            //user.setId(id_user);
            PreparedStatement pt = con.prepareStatement(query);
            
            pt.setInt(1, user.getId());
            pt.setString(2, user.getUserName());
            pt.setString(3, user.getPassword());
            pt.executeUpdate();
            set = true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return set;
    }
    
    /**
     * Used by ScoreBoardServlet to display every users' name and current score in scoreboard.jsp
     * @param con connection instance to the database
     * @return users_score_info a map associating every existing accounts'name with its current score
     */
    public static List listusers() {
        ArrayList list=new ArrayList();
        String jdbcUrl = "jdbc:mysql://localhost:3306/silver_schema.user";
        String username = "root";
        String password = "Silv3rQuestions42";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Step 1 - Load driver
            // Class.forName("com.mysql.cj.jdbc.Driver"); //Class.forName() is not needed since JDBC 4.0

            // Step 2 - Open connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement pstmt=conn.prepareStatement("Select * from user");
            
            while (rs.next()) {
                UserAccount user=new UserAccount();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserScore(rs.getInt("score"));
                list.add(user);
            }
  }     catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
  }     finally {
            try {
                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }     
            catch (SQLException e) {
                e.printStackTrace();
            }
    }
  
        return list;
}
    
   
    
    
}

