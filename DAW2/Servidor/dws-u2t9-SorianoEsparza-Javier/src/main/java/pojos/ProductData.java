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
public class ProductData {
    private static ArrayList<Producto> data;
    public static void load(){
        data = new ArrayList<Producto>();
        data.add(new Producto("Jersey", 10.00));
        data.add(new Producto("Chaqueta", 25.00));
        data.add(new Producto("Moto", 2000.00));
        data.add(new Producto("Iphone 69", 12220.00));
        data.add(new Producto("Yo", 9999999999.00));  
        data.add(new Producto("Loren apruebame", 00.00));
    }

    public static ArrayList<Producto> getData() {
        return data;
    }

    public static void setData(ArrayList<Producto> data) {
        ProductData.data = data;
    }
    
}
