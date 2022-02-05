
package org.silverolympics.dao;
import java.sql.*;
import org.silverolympics.bean.UserAccount;

/**
 *
 * @author Manon
 * @see org.silverolympics.bean.UserAccount
 */
public class DataBaseDao {
    
    Connection con ;

    /**
     * Constructor method 
     * @param con connection to the database server instance
     */
    public DataBaseDao(Connection con) {
        this.con = con;
    }
    
    //for register user 

    /**
     * (For registration/ signing up)
     * Takes care of inserting a new user's credentials into the user database
     * @param user the current user account that is currently being created
     * @return boolean indicating whether inserting the new user's information into the database succeeded or not
     */
    public boolean saveUser(UserAccount user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(username,password) values(?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getUserName());
           pt.setString(2, user.getPassword());
           
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
}

