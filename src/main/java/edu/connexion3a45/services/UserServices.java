package edu.connexion3a45.services;

import edu.connexion3a45.entities.User;
import edu.connexion3a45.interfaces.IService;
import edu.connexion3a45.tools.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServices implements IService<User> {


    // Add with the normal Statement ( Static )
    @Override
    public void addUser(User user) {
        String requete="INSERT INTO user(nom, prenom) " +
                        "VALUES ('"+user.getNom()+"','"+user.getPrenom()+"')";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajouté!");
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }

    // Add with the Prepared Statement  ( Dynamic )
    public void addUser2(User user) {
        String requete="INSERT INTO user(nom, prenom) " +
                "VALUES (?, ?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,user.getNom());
            pst.setString(2,user.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne ajouté avec PST");
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> allData() {
        List<User> data = new ArrayList<>();
        String requete="SELECT * FROM user";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString(3));
                data.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
}
