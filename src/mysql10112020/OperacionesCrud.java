/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql10112020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Campus FP
 */
public class OperacionesCrud  implements Operaciones{
    private Connection conexion;

    public OperacionesCrud(Connection conexion) {
        super();
        this.conexion = conexion;
    }
    
    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        String query = "SELECT * FROM alumno";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = ps.executeQuery();
            List<Alumno> alumnos_al = new ArrayList<>();
            while(rs.next()){
                alumnos_al.add(new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getDate(5)));
                
            }
            return alumnos_al;
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
      
    }
    
}
