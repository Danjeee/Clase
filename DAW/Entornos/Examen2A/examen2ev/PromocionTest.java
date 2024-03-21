/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.promocion;

import com.mycompany.repaso_2ev.Promocion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author CicloM
 */
public class PromocionTest {

    /**
     * Test of calcularPromocion method, of class Promocion.
     */
    @Test
    public void testPromo0() {
        assertEquals("0%", Promocion.calcularPromocion(0));
    }
    @Test
    public void testPromo1() {
        assertEquals("5%", Promocion.calcularPromocion(1));
    }
    @Test
    public void testPromo2() {
        assertEquals("10%", Promocion.calcularPromocion(6));
    }
    @Test
    public void testPromo3() {
        assertEquals("15%", Promocion.calcularPromocion(7));
    }
    @ParameterizedTest
    @CsvSource({"0%, 0", "5%, 1", "10%, 6", "15%, 7" })
    public void testCsvSource(String a, int b){
        assertEquals(a, Promocion.calcularPromocion(b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv")
    public void testCsvFileSource(String a, int b){
        assertEquals(a, Promocion.calcularPromocion(b));
    }
}
