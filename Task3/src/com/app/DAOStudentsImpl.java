package com.app;
import com.interfaces.DAOStudents;
import com.models.Students;
import db.database;
import java.util.List;
import java.sql.PreparedStatement;

public class DAOStudentsImpl extends database implements DAOStudents{

    @Override
    public void upload(Students student) throws Exception {
        try{
            this.Connect();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO Students(FirstName, LastName, Age, Grade, RollNumber) VALUES(?,?,?,?,?)");
            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setInt(3, student.getAge());
            st.setString(4, student.getGrade());
            st.setString(5, student.getRollNumber());
            st.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }   finally {
            this.Close();
        }
    }

    @Override
    public void edit(Students student) throws Exception {
        try{
            
        } catch (Exception e){
            System.out.println(e);
        } 
    }

    @Override
    public void delete(Students student) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Students> showall() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
