/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Coneccion {

    private static Connection cnx = null;

    public static Connection conectar() {
        try {
            String user = "admin";
            String pwd = "";
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:h2:./base/base";
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Error de conección / conectar " + e.getMessage());
        }
        return cnx;
    }

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection aCnx) {
        cnx = aCnx;
    }

    public void Cerrar() throws Exception {
        if (cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        conectar();
        try {
            if (cnx != null) {
                System.out.println("CONEXIÓN EXITOSA");
                JOptionPane.showMessageDialog(null, "CONEXIÓN EXITOSA", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("SIN CONEXIÓN REVISA");
                JOptionPane.showMessageDialog(null, "SIN CONEXIÓN REVISA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error en " + e.getMessage());
        }

    }

    public Connection getCn() {
        return cnx;
    }

    public void setCn(Connection cnx) {
        this.cnx = cnx;
    }
}
