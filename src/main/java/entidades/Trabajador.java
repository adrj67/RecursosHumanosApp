/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author adrj
 */
public class Trabajador {
  private String rut;
  private String nombre;
  private String apellido;
  private int edad;
  private String cargo;
  private boolean sexo;
  private boolean extranjero;

  public Trabajador() {
  }

  public Trabajador(String rut, String nombre, String apellido, int edad, String cargo, boolean sexo, boolean extranjero) {
    this.setRut (rut);
    this.setNombre (nombre);
    this.setApellido (apellido);
    this.setEdad (edad);
    this.setCargo (cargo);
    this.setSexo (sexo);
    this.setExtranjero (extranjero);
  }

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    if (nombre.length()<3 || nombre.length()>100){
      throw new IllegalArgumentException("El largo debe estar entre 3 y 100 caracteres");
    }
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    if(edad < 18){
      // este mensaje se ve gracias al "catch (Exception e) {JOptionPane.showMessageDialog(this, e.getMessage());"
      //que tenemos en NuevoTrabajador
    
      throw new IllegalArgumentException("La persona debe ser mayor de edad");
    }
    this.edad = edad;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public boolean isSexo() {
    return sexo;
  }

  public void setSexo(boolean sexo) {
    this.sexo = sexo;
  }

  public boolean isExtranjero() {
    return extranjero;
  }

  public void setExtranjero(boolean extranjero) {
    this.extranjero = extranjero;
  }

  @Override
  public String toString() {
    return "Trabajador{" + "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cargo=" + cargo + ", sexo=" + sexo + ", extranjero=" + extranjero + '}';
  }
  
  
}
