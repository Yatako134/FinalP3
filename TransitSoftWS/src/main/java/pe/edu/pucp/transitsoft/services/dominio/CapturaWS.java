package pe.edu.pucp.transitsoft.services.dominio;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.services.base.HttpJsonClient;
import pe.pucp.transitsoft.model.CapturaDTO;

@WebService(serviceName = "CapturaWS", targetNamespace = "pe.edu.pucp.transitsoft.services")
public class CapturaWS {
    private static final String BASE_URL = "http://localhost:8080/TransitSoftWR/webresources/CapturaWR";
    
    @WebMethod(operationName = "listarCapturas")
    public ArrayList<CapturaDTO> listarCapturas(@WebParam(name = "tipoBD")String tipoBD) {
        ArrayList<CapturaDTO> capturas = null;
        
        try {
                capturas = HttpJsonClient.get(BASE_URL + "/listarTodas/" + tipoBD, new TypeReference<ArrayList<CapturaDTO>>() {
                });

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al listar las capturas " + ex.getMessage());
        }
        return capturas;
    }
    
}
