package pe.edu.pucp.transitsoft.dominio.dao;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dao.IDAO;
import pe.pucp.transitsoft.model.PropietarioDTO;

public interface PropietarioDAO extends IDAO<PropietarioDTO>{
    ArrayList<PropietarioDTO> listarPropietarioConVehiculo(int tipoBD);
    ArrayList<PropietarioDTO> listarPropietarioSinVehiculo(int tipoBD);
}
