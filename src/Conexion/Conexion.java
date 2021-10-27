package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection co;
    private static final String direccion = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String contra = "";
    private static final String enlace = "jdbc:mysql://localhost:3306/parcial";
    
    public Conexion(){
        co=null;
        try{
            Class.forName(direccion);
            co=DriverManager.getConnection(enlace, usuario, contra);
            if(co!=null){
                System.out.println("Se ha establecido conexion");
            }
        }catch (Exception e){
            System.err.println("Error de conexion: "+e.getMessage());
        }
    }
    public Connection getConnection(){
        return co;
    }
    
    public void desconectar(){
        co=null;
        if(co==null){
            System.out.println("Fin de la conexion");
        }
    }
}
