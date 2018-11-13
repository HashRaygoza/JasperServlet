/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pydee.jasperservlet.vo;

/**
 *
 * @author David
 */
public class RegistroFacturaVO {
    private String codigo;
    private String nombreProducto;
    private Double precio;
    private Double impuesto;
    private Double cantidad;
    private Double total;
    private String serial;
    private Integer secuencial;
    private Double descuento=0.0;
    
    public RegistroFacturaVO() {
        
    }
    
    public RegistroFacturaVO(String cod, String nom, Double pre, Double tax, Double can, Double tot, String ser, Integer sec, Double dis) {
        codigo = cod;
        nombreProducto = nom;
        precio = pre;
        impuesto = tax;
        cantidad = can;
        total = tot;
        serial = ser;
        secuencial = sec;
        descuento = dis;
    }
    

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the impuesto
     */
    public Double getImpuesto() {
        return impuesto;
    }

    /**
     * @param impuesto the impuesto to set
     */
    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the secuencial
     */
    public Integer getSecuencial() {
        return secuencial;
    }

    /**
     * @param secuencial the secuencial to set
     */
    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }    

    /**
     * @return the descuento
     */
    public Double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
}
