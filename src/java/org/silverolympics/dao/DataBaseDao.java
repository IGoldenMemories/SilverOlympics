
package org.silverolympics.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.silverolympics.bean.UserAccount;

/**
 *
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 */
public class DataBaseDao {
    
    
    

    /**
     * Constructor method 
     * @param con connection to the database server instance
     */
    public DataBaseDao(Connection con) {
        super();
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
            int id_user = DataBaseDao.number_users();
            user.setId(id_user);
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
    public Map<String, Integer> getusersscore(Connection con){
        Map<String, Integer> users_score_info= new HashMap<>();

        try {
            PreparedStatement pstmt=con.prepareStatement("Select username,score from user");
            ResultSet rs= pstmt.executeQuery();
            
            while(rs.next()){
                String username = rs.getString("username");
                int score = rs.getInt("score");
                users_score_info.put(username,score);
            }
        }
        catch (SQLException e) {
            
            e.printStackTrace();
        }
        return users_score_info;
    }
    
    /**
     * Returns the number of current accounts in user database
     * @return the number of entries (rows) of the user database
     * @throws SQLException
     */
    public static int number_users() throws SQLException {
        
        try{
            // Setup the connection with the DB
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/silver_schema?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]" + "user=root&password=Silv3rQuestions42");
        
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from user");
        
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
        }
       catch(SQLException e){
               
               }
        return 0;
    }
    
    
}

