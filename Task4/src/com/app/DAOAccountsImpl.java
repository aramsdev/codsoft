package com.app;
import com.interfaces.DAOAccounts;
import com.db.db;
import com.models.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOAccountsImpl extends db implements DAOAccounts{
    ResultSet rs = null;
    String fn, ln,user,pass, Query, Query2;
    @Override
    public void createAccount(Account account) throws Exception {
        try{
            this.Connect();
            String username = account.getUsername();
            String password = account.getPassword();
            Query = "INSERT INTO accounts(username, password) VALUES (?,?);";
            PreparedStatement st = this.connection.prepareStatement(Query);
            st.setString(1, account.getUsername());
            st.setString(2, account.getPassword());
            st.executeUpdate();
            Query = "INSERT INTO user_info (firstname, lastname, balance) VALUES (?,?, ?);";
            st = this.connection.prepareStatement(Query);
            st.setString(1, account.getFirstName());
            st.setString(2, account.getLastName());
            st.setFloat(3, account.getBalance());
            st.executeUpdate();
            st.close();
        } catch(Exception e){
            System.out.println(e);
        } finally {
            this.Close();
        }
    }
    @Override
    public Account login(String username, String password) throws Exception{
        Account account = new Account();
        try{
            this.Connect();
            Query = "SELECT id, firstname, lastname, balance FROM user_info WHERE id IN (SELECT id FROM accounts WHERE username = ? AND password = ?);";
            PreparedStatement st = this.connection.prepareStatement(Query);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            while(rs.next()){
                account.setId(rs.getInt("id"));
                account.setFirstName(rs.getString("firstname"));
                account.setLastName(rs.getString("lastname"));
                account.setBalance(rs.getFloat("balance"));
            }
            st.close();
            rs.close();
        } catch (Exception e){
            System.out.println(e);
        }   finally {
            this.Close();
        }
        return account;
    }
    @Override
    public Account Deposit_Withdraw(int id, String action, float amount) throws Exception {
        Account account = new Account();
        try{
            this.Connect();
            float balance = 0;
            int user_id = 0;
            Query = "SELECT * FROM user_info WHERE id = ?;";
            PreparedStatement st = this.connection.prepareStatement(Query);
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()){
                user_id = rs.getInt("id");
                balance = rs.getInt("balance");
            }
            if(action.equals("Withdraw")){
                balance = balance - amount;
            } else{
                balance = balance + amount;
            }

            Query2 = "UPDATE user_info SET balance = ? WHERE id = ?;";
            st = this.connection.prepareStatement(Query2);
            st.setFloat(1, balance);
            st.setInt(2, user_id);
            st.executeUpdate();
            
            st = this.connection.prepareStatement(Query);
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()){
                account.setBalance(rs.getFloat("balance"));
                account.setFirstName(rs.getString("firstname"));
                account.setLastName(rs.getString("lastname"));
                account.setId(rs.getInt("id"));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            System.out.println(e);
        } finally{
            this.Close();
        }
        return account;
    }
}
