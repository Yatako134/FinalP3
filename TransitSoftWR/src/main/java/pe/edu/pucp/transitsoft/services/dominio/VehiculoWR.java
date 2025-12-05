package pe.edu.pucp.transitsoft.services.dominio;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.IVehiculoBO;
import pe.edu.pucp.transitsoft.domimio.boi.VehiculoBOImpl;
import pe.pucp.transitsoft.model.VehiculoDTO;

@Path("VehiculoWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoWR {
    private IVehiculoBO bovehiculo; 
    
    @GET
    @Path("listarTodas/{tipoBD}")
    public ArrayList<VehiculoDTO> listarTodas(@PathParam("tipoBD") int tipoBD){
        ArrayList<VehiculoDTO> vehiculos = null;
        try{
            bovehiculo = new VehiculoBOImpl();
            vehiculos = bovehiculo.listarTodos(tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return vehiculos;
    }
    
    @GET
    @Path("listarVehiculosXID/{id_propietario}/{tipoBD}")
    public ArrayList<VehiculoDTO> listarVehiculosXID(@PathParam("id_propietario") int id_propietario,@PathParam("tipoBD") int tipoBD){
        ArrayList<VehiculoDTO> vehiculos = null;
        try{
            bovehiculo = new VehiculoBOImpl();
            vehiculos = bovehiculo.listarVehiculosXID(id_propietario,tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return vehiculos;
    }
}