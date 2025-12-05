package pe.edu.pucp.transitsoft.services.dominio;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.ICapturaBO;
import pe.edu.pucp.transitsoft.domimio.boi.CapturaBOImpl;
import pe.pucp.transitsoft.model.CapturaDTO;

@Path("CapturaWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CapturaWR {
    private ICapturaBO bocaptura; 
    
    @GET
    @Path("listarTodas/{tipoBD}")
    public ArrayList<CapturaDTO> listarTodas(@PathParam("tipoBD") int tipoBD){
        ArrayList<CapturaDTO> capturas = null;
        try{
            bocaptura = new CapturaBOImpl();
            capturas = bocaptura.listarTodos(tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return capturas;
    }
}