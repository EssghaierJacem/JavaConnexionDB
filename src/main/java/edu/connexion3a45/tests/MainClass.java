package edu.connexion3a45.tests;


import edu.connexion3a45.entities.User;
import edu.connexion3a45.services.UserServices;
import edu.connexion3a45.tools.MyConnection;

public class MainClass {
    public static void main(String[] args) {

       // MyConnection mc = new MyConnection();

            //User Add : Statement

        User user1 = new User("Jacem", "Sghaier");
        UserServices us = new UserServices();
        us.addUser(user1);

            //User Add  : Prepared Statement

        us.addUser2(user1);

            //Show All Data

        System.out.println(us.allData());
    }
}
