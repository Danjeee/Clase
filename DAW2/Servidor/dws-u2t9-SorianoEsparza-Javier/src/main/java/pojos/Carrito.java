package pojos;

import java.util.Enumeration;
import java.util.Hashtable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ciclom
 */
public class Carrito {

    private Hashtable ht = new Hashtable();

    public Hashtable getData() {
        return ht;
    }

    public Carrito() {
    }

    public void setData(Hashtable ht) {
        this.ht = ht;
    }

    public void remove(String a) {
        if (a != null) {
            String item = a.substring(7, a.length() - 1);
            item = item.substring(0, item.length() - 11);
            ht.remove(item);
        }
    }

    public void put(String a) {
        if (a != null) {
            String item = a.substring(8, a.length());
            if (ht.containsKey(item)) {
                ht.put(item, ((int) ht.get(item) + 1));
            } else {
                ht.put(item, 1);
            }
        }
    }
}
