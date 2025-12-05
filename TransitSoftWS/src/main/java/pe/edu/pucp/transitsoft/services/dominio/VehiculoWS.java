package pe.edu.pucp.transitsoft.services.dominio;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.services.base.HttpJsonClient;
import pe.pucp.transitsoft.model.VehiculoDTO;


@WebService(serviceName = "VehiculoWS", targetNamespace = "pe.edu.pucp.transitsoft.services")
public class VehiculoWS {
    private static final String BASE_URL = "http://localhost:8080/TransitSoftWR/webresources/VehiculoWR";
    
    @WebMethod(operationName = "listarVehiculos")
    public ArrayList<VehiculoDTO> listarVehiculos(@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<VehiculoDTO> vehiculos = null;
        try {
                vehiculos = HttpJsonClient.get(BASE_URL + "/listarTodas/" + tipoBD, new TypeReference<ArrayList<VehiculoDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error a los propietarios " + ex.getMessage());
        }
        return vehiculos;
    }
    
    @WebMethod(operationName = "listarVehiculosXID")
    public ArrayList<VehiculoDTO> listarVehiculosXID(@WebParam(name = "id")String id,@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<VehiculoDTO> vehiculos = null;
        try {
                vehiculos = HttpJsonClient.get(BASE_URL + "/listarVehiculosXID/" + id + "/"+ tipoBD, new TypeReference<ArrayList<VehiculoDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error a los propietarios " + ex.getMessage());
        }
        return vehiculos;
    }
}
