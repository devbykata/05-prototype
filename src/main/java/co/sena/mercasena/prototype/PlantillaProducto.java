package co.sena.mercasena.prototype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Prototipo de producto. */
public class PlantillaProducto {

    private String nombre;
    private BigDecimal precio;
    private final List<String> etiquetas;
    private final Map<String, String> atributos;

    public PlantillaProducto(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.etiquetas = new ArrayList<>();
        this.atributos = new LinkedHashMap<>();
    }

    /** Constructor de copia usado por copiar(). */
    private PlantillaProducto(PlantillaProducto otro) {
        this.nombre = otro.nombre;
        this.etiquetas = otro.etiquetas;
        this.atributos = new LinkedHashMap<>(otro.atributos);
    }

    public PlantillaProducto copiar() {
        return new PlantillaProducto(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<String> getEtiquetas() {
        return Collections.unmodifiableList(etiquetas);
    }

    public void agregarEtiqueta(String etiqueta) {
        etiquetas.add(etiqueta);
    }

    public Map<String, String> getAtributos() {
        return Collections.unmodifiableMap(atributos);
    }

    public void ponerAtributo(String clave, String valor) {
        atributos.put(clave, valor);
    }
}
