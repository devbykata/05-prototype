package co.sena.mercasena.prototype;

import java.util.HashMap;
import java.util.Map;

/** Registro de prototipos: entrega copias nuevas bajo demanda. */
public class RegistroPlantillas {

    private final Map<String, PlantillaProducto> plantillas = new HashMap<>();

    public void registrar(String clave, PlantillaProducto plantilla) {
        plantillas.put(clave, plantilla.copiar());
    }

    public PlantillaProducto crear(String clave) {
        PlantillaProducto prototipo = plantillas.get(clave);
        if (prototipo == null) {
            throw new IllegalArgumentException("No existe la plantilla: " + clave);
        }
        return prototipo.copiar();
    }
}
