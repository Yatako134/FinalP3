package pe.edu.pucp.transitsoft.domimio.bo;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.bo.IBaseBO;
import pe.pucp.transitsoft.model.PropietarioDTO;

public interface IPropietarioBO extends IBaseBO<PropietarioDTO>{
    ArrayList<PropietarioDTO> listarPropietarioConVehiculo(int tipoBD);
    ArrayList<PropietarioDTO> listarPropietarioSinVehiculo(int tipoBD);
}
