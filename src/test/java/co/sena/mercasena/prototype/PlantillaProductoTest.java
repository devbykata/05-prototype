package co.sena.mercasena.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PlantillaProductoTest {

    private PlantillaProducto cafe;

    @BeforeEach
    void preparar() {
        cafe = new PlantillaProducto("Café de origen", new BigDecimal("18000"));
        cafe.agregarEtiqueta("orgánico");
        cafe.ponerAtributo("presentación", "500 g");
    }

    @Test
    void laCopiaTieneLosMismosValores() {
        PlantillaProducto copia = cafe.copiar();
        assertNotSame(cafe, copia);
        assertEquals("Café de origen", copia.getNombre());
        assertEquals(cafe.getPrecio(), copia.getPrecio());
        assertEquals(cafe.getEtiquetas(), copia.getEtiquetas());
        assertEquals(cafe.getAtributos(), copia.getAtributos());
    }

    @Test
    void cambiarAtributosDeLaCopiaNoAfectaAlOriginal() {
        PlantillaProducto copia = cafe.copiar();
        copia.ponerAtributo("presentación", "250 g");
        assertEquals("500 g", cafe.getAtributos().get("presentación"));
    }

    @Test
    void plantillaInexistenteLanzaExcepcion() {
        RegistroPlantillas registro = new RegistroPlantillas();
        assertThrows(IllegalArgumentException.class, () -> registro.crear("no-existe"));
    }

    @Test
    void elRegistroEntregaProductosConLosDatosDeLaPlantilla() {
        RegistroPlantillas registro = new RegistroPlantillas();
        registro.registrar("cafe", cafe);
        assertEquals("Café de origen", registro.crear("cafe").getNombre());
    }

    @Test
    void crearDosVecesDebeDevolverObjetosDistintos() {
        RegistroPlantillas registro = new RegistroPlantillas();

        registro.registrar("cafe", cafe);

        PlantillaProducto primera = registro.crear("cafe");
        PlantillaProducto segunda = registro.crear("cafe");

        assertNotSame(primera, segunda);
    }


    @Test
    void cambiarEtiquetasDeLaCopiaNoAfectaAlOriginal() {
        PlantillaProducto copia = cafe.copiar();

        copia.agregarEtiqueta("nuevo");

        assertEquals(1, cafe.getEtiquetas().size());
        assertFalse(cafe.getEtiquetas().contains("nuevo"));
    }




}
