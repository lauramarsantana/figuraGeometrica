/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Estudiantes
 */
public class Cuadrado implements IArea, IPerimetro{
    private double lado;
    private double area;
    private double perimetro;
    
    public Cuadrado(){}
    
    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        area = lado*lado;
        return area;
    }
    
    public double obtenerLado(){
        return this.lado;
    }
    
    public int cambiarLado(double lado){
        if(lado > 0){
            this.lado = lado;
            return 1;}
        else
            return 0;
    }

    @Override
    public double calcularPerimetro() {
        perimetro = lado*4;
        return perimetro;
    }
    
    
}
