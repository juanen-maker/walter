/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql10112020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Campus FP
 */
public class Conexion {
 //ATRIBUTO DE LA CONEXION
    private static Connection conexion;

    //PARAMETRO DE LA CONEXION
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVERNAME = "localhost"; //"127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "BD0001";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //URL DE LA CONEXION
    private static final String URL = "jdbc:mysql://"
            + SERVERNAME + ":"
            + PORT + "/"
            + DATABASE + "?autoReconnect=true&useSSL=false";

    //CONSTRUCTOR DE LA CONEXION
    public Conexion() {
        setConexion(false);
    }

    public Conexion(boolean flag) {//true generar la conexion
        setConexion(flag);     //false cierra la conexion
    }
    
    //GET Y SET

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(boolean flag) {
        try {
            if(flag) { //Generar la conexion
                Class.forName(DRIVER);//Registrar el driver
                conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);//Genera la conexion
                String query = "use " + DATABASE;
                Statement sql = conexion.createStatement();//Crear un objeto para ejecutar query
                sql.executeUpdate(query);//Ejecutar la query
            }else { //Cerrar la conexion
                conexion.close();
                conexion = null;
            }
        }catch(ClassNotFoundException | SQLException e) {
            conexion = null;
        }
    }
}
