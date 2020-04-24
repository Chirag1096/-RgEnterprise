/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgenterprise.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MOHAN
 */
public class ConnectionToDatabase {

    Connection conn = null;

    public Connection createConnection() {
        try {
//            System.setProperty("derby.system.home", System.getProperty("user.MOHAN", ".") + "/.rgenterprise");
//            System.setProperty("derby.system.home", "C:/Users/MOHAN/.ipynb_checkpoints/Documents/NetBeansProjects/RGEnterprise"+"/.rgenterprise");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
//            conn = DriverManager.getConnection("jdbc:derby:" + "C:/Users/MOHAN/.ipynb_checkpoints/Documents/NetBeansProjects/RGEnterprise/CMDatabase;create=true", "cm", "cm1096");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CMDatabase", "cm", "cm1096");
//            conn.setAutoCommit(false);

        } catch (Exception except) {
            except.printStackTrace();
        }
        return conn;
    }

    public void CloseConnection() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
