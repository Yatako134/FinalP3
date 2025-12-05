package pe.edu.pucp.transitsoft.services.dominio;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.IPropietarioBO;
import pe.edu.pucp.transitsoft.domimio.boi.PropietarioBOImpl;
import pe.pucp.transitsoft.model.PropietarioDTO;

@Path("PropietarioWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropietarioWR {
    private IPropietarioBO bopropietario; 
    
    @GET
    @Path("listarTodas/{tipoBD}")
    public ArrayList<PropietarioDTO> listarTodas(@PathParam("tipoBD") int tipoBD){
        ArrayList<PropietarioDTO> propietarios = null;
        try{
            bopropietario = new PropietarioBOImpl();
            propietarios = bopropietario.listarTodos(tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return propietarios;
    }
    
    @GET
    @Path("listarPropietarioConVehiculo/{tipoBD}")
    public ArrayList<PropietarioDTO> listarPropietarioConVehiculo(@PathParam("tipoBD") int tipoBD){
        ArrayList<PropietarioDTO> propietarios = null;
        try{
            bopropietario = new PropietarioBOImpl();
            propietarios = bopropietario.listarPropietarioConVehiculo(tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return propietarios;
    }
    
    @GET
    @Path("listarPropietarioSinVehiculo/{tipoBD}")
    public ArrayList<PropietarioDTO> listarPropietarioSinVehiculo(@PathParam("tipoBD") int tipoBD){
        ArrayList<PropietarioDTO> propietarios = null;
        try{
            bopropietario = new PropietarioBOImpl();
            propietarios = bopropietario.listarPropietarioSinVehiculo(tipoBD); // elige entre MSSQL(1) O mysql(0)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return propietarios;
    }
    
    
}