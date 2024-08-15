/*
package bd;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
  
  private Connection conexion;
  
  private String host ="localhost";
  private String usuario ="root";
  private String password ="root";
  private String nombreBD = "recursos_humanos_app";
  
  private String url="jdbc:mysql://"+host+"/"+nombreBD;
  
  public Connection conectar(){
    
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      this.conexion = DriverManager.getConnection(this.url, this.usuario, this.password);
      
    } catch (Exception e) {
      System.out.println("Error de conexion: "+ e.getMessage());
    }
    return this.conexion;
  }
  
}
*/

package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
  
  private Connection conexion;
  
  private String host = "localhost";
  private String usuario = "root";
  private String password = "";
  private String nombreBD = "recursos_humanos_app";
  
  private String url = "jdbc:mysql://" + host + "/" + nombreBD;
  
  public Connection conectar() {
    try {
      // No es necesario invocar explícitamente a Class.forName() a menos que sea un driver muy antiguo.
      // Class.forName("com.mysql.cj.jdbc.Driver");
      this.conexion = DriverManager.getConnection(this.url, this.usuario, this.password);
    } catch (Exception e) {
      System.out.println("Error de conexion: " + e.getMessage());
    }
    return this.conexion;
  }
}
