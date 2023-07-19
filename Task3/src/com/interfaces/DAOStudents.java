package com.interfaces;
import com.models.Students;
import java.util.ArrayList;
import java.util.List;

public interface DAOStudents {
    public void upload(Students student) throws Exception;
    public Students search(int i) throws Exception;
    public void edit(Students student) throws Exception;
    public void delete(int id) throws Exception;
    public List<Students> showAll(String name) throws Exception;
}
