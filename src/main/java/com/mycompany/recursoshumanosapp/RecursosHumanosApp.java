/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recursoshumanosapp;

import entidades.Trabajador;
import dao.TrabajadorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrj
 */
public class RecursosHumanosApp {
  
  public static void main(String[] args) {
 // 1   
//    Trabajador t = new Trabajador("21-11661111-7", "Ernesto", "Lopez", 18, "Vendedor", true, false);
//    
//    TrabajadorDAO tDAO = new TrabajadorDAO();
//    
//    try {
//      if(tDAO.agregarTrabajador(t)){
//        System.out.println("Trabajador Agregado ");
//      }else{
//        System.out.println("Ha ocurrido un error al cargar el trabajador");
//      }
//    } catch (SQLException ex) {
//      Logger.getLogger(RecursosHumanosApp.class.getName()).log(Level.SEVERE, null, ex);
//    }
  
// ctrl + shift + C
// 

    TrabajadorDAO tDAO = new TrabajadorDAO();
//    
//    try {
//      ArrayList<Trabajador> trabajadores = tDAO.listarTrabajadores();
//      for(Trabajador trabajadore : trabajadores){
//        System.out.println(trabajadore);
//      }
//    } catch (SQLException ex) {
//      System.out.println(ex.getMessage());
//    }
    try {
      if(tDAO.eliminarTrabajador("20-11661111-7")){
        System.out.println("Eliminado");
      }else {
        System.out.println("Error al eliminar");
      }
              
              } catch (SQLException ex) {
      Logger.getLogger(RecursosHumanosApp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
  
}
