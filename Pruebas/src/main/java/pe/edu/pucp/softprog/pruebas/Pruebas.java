package pe.edu.pucp.softprog.pruebas;

import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.transitsoft.domimio.boi.PropietarioBOImpl;
import pe.edu.pucp.transitsoft.domimio.boi.VehiculoBOImpl;
import pe.pucp.transitsoft.model.CamaraDTO;
import pe.pucp.transitsoft.model.CapturaDTO;
import pe.pucp.transitsoft.model.PropietarioDTO;
import pe.pucp.transitsoft.model.VehiculoDTO;

public class Pruebas {

    public static void main(String[] args) throws Exception {
        VehiculoBOImpl vehiculobo = new VehiculoBOImpl();
        ArrayList<VehiculoDTO> vehiculos = vehiculobo.listarVehiculosXID(1, 0);
        if (vehiculos == null || vehiculos.isEmpty()) {
            System.out.println("No hay vehículos para mostrar.");
        } else {
            System.out.println("=== LISTA DE VEHÍCULOS ===");
            for (VehiculoDTO v : vehiculos) {
                System.out.println("----------------------------");
                System.out.println("ID: " + v.getId());
                System.out.println("Placa: " + v.getPlaca());
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Año: " + v.getAnho());
            }
            System.out.println("===========================");
        }

    }
}
