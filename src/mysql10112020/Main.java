/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql10112020;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Campus FP
 */
public class Main {
    
    public static void main(String[] arg){
        Conexion.setConexion(true);
        Connection conexion = Conexion.getConexion();
        List<Alumno> alumnos_al;
        OperacionesCrud oc = new OperacionesCrud(conexion);
        
        if(conexion != null){
            if((alumnos_al = oc.obtenerTodosLosAlumnos()) != null){
                for (int i = 0; i < alumnos_al.size(); i++) {
                    Alumno alumno = alumnos_al.get(i);
                    System.out.println(alumno);                    
                }
            }
            
        }else{
            System.out.println("ERROR");
        }
        
    }
}
