/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author carla
 */
public class Circulo implements IArea, IPerimetro{
    private double radio;
    private double area;
    private double perimetro;
    
    public Circulo(){
    }
    public Circulo(double radio){
        this.radio = radio;
    }
    @Override
    public double calcularArea() {
        area = Math.PI*radio*radio;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        perimetro = 2*Math.PI*radio;
        return perimetro;
    }
    
    public double obtenerRadio(){
        return this.radio;
    }
    
    public void modificarRadio(double radio){
        this.radio = radio;
    }
    
    public double obtenerArea(){
        return this.area;
    }
    
    public double obtenerPerimetro(){
        return this.perimetro;
    }
}
