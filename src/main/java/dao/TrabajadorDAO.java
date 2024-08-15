/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.Conexion;
import entidades.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author adrj
 */
public class TrabajadorDAO {
  private Conexion conexion = new Conexion();
  
  public boolean agregarTrabajador(Trabajador trabajador) throws SQLException{
    
    boolean fueAgregado = false;
    Connection conn = conexion.conectar();
    
    try {
      String sql = "insert into trabajador values(?,?,?,?,?,?,?)";
      // Preparamos la sentencia antes de enviarla
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, trabajador.getRut());
      stmt.setString(2, trabajador.getNombre());
      stmt.setString(3, trabajador.getApellido());
      stmt.setInt(4, trabajador.getEdad());
      stmt.setString(5, trabajador.getCargo());
      stmt.setBoolean(6, trabajador.isSexo());
      stmt.setBoolean(7, trabajador.isExtranjero());
      
      // ejecutamos la sentencia
      int cantidad = stmt.executeUpdate();
      
      fueAgregado = (cantidad > 0);
      
    } catch (Exception e) {
      System.out.println("Error al agregar el trabajador: " + e.getMessage());
    } finally {
      // siempre cierra la conexion, se agregue o no el trabajador
      conn.close();
    }
    return fueAgregado;
  }
  
  public ArrayList<Trabajador> listarTrabajadores() throws SQLException{
    
    ArrayList<Trabajador> trabajadores = new ArrayList<>();
    Connection conn = conexion.conectar();
    
    try{
      String sql = "select * from trabajador";
      
      PreparedStatement stmt = conn.prepareStatement(sql);
      
      ResultSet rs = stmt.executeQuery();
      
      while(rs.next()){
        // extraigo los datos
        Trabajador t = new Trabajador();
        t.setRut(rs.getString("rut"));
        t.setNombre(rs.getString("nombre"));
        t.setApellido(rs.getString("apellido"));
        t.setEdad(rs.getInt("edad"));
        t.setCargo(rs.getString("cargo"));
        t.setSexo(rs.getBoolean("sexo"));
        t.setExtranjero(rs.getBoolean("esExtranjero"));
        
        trabajadores.add(t);
      }
      
    } catch (Exception e){
      System.out.println("Error listado " + e.getMessage());
    }finally {
      conn.close();
    }
    
    return trabajadores;
    
  }
  
  public ArrayList<Trabajador> buscarPorRut(String rut) throws SQLException{
    
    ArrayList<Trabajador> trabajadores = new ArrayList<>();
    Connection conn = conexion.conectar();
    
    try{
      String sql = "select * from trabajador where rut = ?";
      
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, rut);
      
      ResultSet rs = stmt.executeQuery();
      
      while(rs.next()){
        // extraigo los datos
        Trabajador t = new Trabajador();
        t.setRut(rs.getString("rut"));
        t.setNombre(rs.getString("nombre"));
        t.setApellido(rs.getString("apellido"));
        t.setEdad(rs.getInt("edad"));
        t.setCargo(rs.getString("cargo"));
        t.setSexo(rs.getBoolean("sexo"));
        t.setExtranjero(rs.getBoolean("esExtranjero"));
        
        trabajadores.add(t);
      }
      
    } catch (Exception e){
      System.out.println("Error listado " + e.getMessage());
    }finally {
      conn.close();
    }
    
    return trabajadores;
    
  }
  
  public boolean eliminarTrabajador(String rut) throws SQLException{
    
    boolean fueEliminado = false;
    
    Connection conn = conexion.conectar();
    
    try {
      
      String sql = "delete from trabajador where rut = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, rut);
      
      fueEliminado = (stmt.executeUpdate() > 0);
      
    } catch (Exception e) {
      System.out.println("Error al eliminar trabajador " + e.getMessage());
    } finally {
        conn.close();
    }

    return fueEliminado;
  }
}
