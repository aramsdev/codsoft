package com.app;
import com.interfaces.DAOStudents;
import com.models.Students;
import db.database;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

public class DAOStudentsImpl extends database implements DAOStudents{

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
    public ArrayList<Students> showall() throws Exception {
        ResultSet rs = null;
        String fn,ln,grade,rn;
        int id;
        ArrayList<Students> students = new ArrayList<Students>();
        try{
            this.Connect();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM students");
            rs = st.executeQuery();
                        
            while(rs.next()){
                id = rs.getInt(1);
                fn = rs.getString(2);
                ln = rs.getString(3);
                grade = rs.getString(4);
                rn = rs.getString(5);
                students.add(new Students(fn,ln,grade,rn));
            }
            return students;
        } catch(Exception e){
            System.out.println(e);
        } finally{
            this.Close();
        }
        return students;
    }
    
}
