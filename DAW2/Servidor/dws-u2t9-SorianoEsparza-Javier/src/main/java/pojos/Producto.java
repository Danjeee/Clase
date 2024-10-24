package pojos;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ciclom
 */
public class Producto {
    private static int totalproductos = 0;
    private int id;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        Producto.totalproductos++;
        this.id = Producto.totalproductos;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    private static ArrayList<Producto> data;
    public static void loadAllProducts(){
        data = new ArrayList<Producto>();
        data.add(new Producto("Jersey", 10.00));
        data.add(new Producto("Chaqueta", 25.00));
        data.add(new Producto("Moto", 2000.00));
        data.add(new Producto("Iphone 69", 12220.00));
        data.add(new Producto("Yo", 9999999999.00));  
        data.add(new Producto("Loren apruebame", 00.00));
    }

    public static int getTotalproductos() {
        return totalproductos;
    }

    public static void setTotalproductos(int totalproductos) {
        Producto.totalproductos = totalproductos;
    }

    public static ArrayList<Producto> getAllProducts() {
        return data;
    }

    public static void setData(ArrayList<Producto> data) {
        Producto.data = data;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
