package pe.edu.pucp.transitsoft.services.dominio;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.services.base.HttpJsonClient;
import pe.pucp.transitsoft.model.PropietarioDTO;


@WebService(serviceName = "PropietarioWS", targetNamespace = "pe.edu.pucp.transitsoft.services")
public class PropietarioWS {
    private static final String BASE_URL = "http://localhost:8080/TransitSoftWR/webresources/PropietarioWR";
    
    @WebMethod(operationName = "listarPropietarios")
    public ArrayList<PropietarioDTO> listarPropietarios(@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        try {
                propietarios = HttpJsonClient.get(BASE_URL + "/listarTodas/" + tipoBD, new TypeReference<ArrayList<PropietarioDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error a los propietarios " + ex.getMessage());
        }
        return propietarios;
    }
    
    @WebMethod(operationName = "listarPropietariosConVehiculo")
    public ArrayList<PropietarioDTO> listarPropietariosConVehiculo(@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        try {
                propietarios = HttpJsonClient.get(BASE_URL + "/listarPropietarioConVehiculo/" + tipoBD, new TypeReference<ArrayList<PropietarioDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error a los propietarios " + ex.getMessage());
        }
        return propietarios;
    }
    
    @WebMethod(operationName = "listarPropietariosSinVehiculo")
    public ArrayList<PropietarioDTO> listarPropietariosSinVehiculo(@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        try {
                propietarios = HttpJsonClient.get(BASE_URL + "/listarPropietarioSinVehiculo/" + tipoBD, new TypeReference<ArrayList<PropietarioDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error a los propietarios " + ex.getMessage());
        }
        return propietarios;
    }
    
}
