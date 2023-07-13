package com.interfaces;
import com.models.Students;
import java.util.List;

public interface DAOStudents {
    public void upload(Students student) throws Exception;
    public void edit(Students student) throws Exception;
    public void delete(Students student) throws Exception;
    public List<Students> showall() throws Exception;
}
