package com.app;
import com.interfaces.DAOStudents;
import com.models.Students;
import db.database;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class DAOStudentsImpl extends database implements DAOStudents{
    ResultSet rs = null;
    String fn,ln,grade,rn;
    int id;
    
    @Override
    public void upload(Students student) throws Exception {
        try{
            this.Connect();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO students(FirstName, LastName, Grade, RollNumber) VALUES(?,?,?,?)");
            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setString(3, student.getGrade());
            st.setString(4, student.getRollNumber());
            st.executeUpdate();
            st.close();
        } catch (Exception e){
            System.out.println(e);
        }   finally {
            this.Close();
        }
    }
    
    @Override
    public Students search(int i) throws Exception {
        Students student = new Students();
        try{
            this.Connect();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM students WHERE id = " + i);
            rs = st.executeQuery();
            student.setId(rs.getInt(1));
            student.setFirstName(rs.getString(2));
            student.setLastName(rs.getString(3));
            student.setGrade(rs.getString(4));
            student.setRollNumber(rs.getString(5));
            rs.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        } finally{
            this.Close();
        }
        return student;
    }

    @Override
    public void edit(Students student) throws Exception {
        try{
            
        } catch (Exception e){
            System.out.println(e);
        } 
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.Connect();
            String Query = "DELETE FROM students WHERE id = ?;";
            PreparedStatement st = this.connection.prepareStatement(Query);
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        } catch(Exception e){
            System.out.println(e);
        } finally{
            this.Close();
        }
    }

    @Override
    public List<Students> showAll(String name) throws Exception {
        List<Students> students = null;
        try{
            this.Connect();
            String Query = name.isEmpty() ? "SELECT * FROM students;" : "SELECT * FROM students WHERE FirstName LIKE '%" + name+"%';";
            PreparedStatement st = this.connection.prepareStatement(Query);
            students = new ArrayList();
            rs = st.executeQuery();
                        
            while(rs.next()){
                Students student = new Students();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setGrade(rs.getString("Grade"));
                student.setRollNumber(rs.getString("RollNumber"));
                students.add(student);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            System.out.println(e);
        } finally{
            this.Close();
        }
        return students;
    }
    
}
