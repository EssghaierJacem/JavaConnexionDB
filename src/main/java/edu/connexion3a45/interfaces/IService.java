package edu.connexion3a45.interfaces;

import java.util.List;

public interface IService<T> {

    public void addUser(T t);
    public void removeUser(T t);
    public void updateUser(T t);
    public List<T> allData();

}
