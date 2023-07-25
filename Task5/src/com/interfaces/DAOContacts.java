package com.interfaces;

import com.models.Contact;
import java.util.ArrayList;

public interface DAOContacts {
    public void addContact(Contact contact) throws Exception;
    public ArrayList<Contact> showContacts() throws Exception;
    public ArrayList<Contact> searchContact (String name) throws Exception;
    public void deleteContact(int id) throws Exception;
    public void editContact(Contact contact) throws Exception;
    public Contact searchById(int id) throws Exception;
}
