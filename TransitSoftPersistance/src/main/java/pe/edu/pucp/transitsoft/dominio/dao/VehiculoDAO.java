package pe.edu.pucp.transitsoft.dominio.dao;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dao.IDAO;
import pe.pucp.transitsoft.model.VehiculoDTO;

public interface VehiculoDAO extends IDAO<VehiculoDTO>{
   ArrayList<VehiculoDTO> listarVehiculosXID(int id_propietario,int tipoBD);
    
}
