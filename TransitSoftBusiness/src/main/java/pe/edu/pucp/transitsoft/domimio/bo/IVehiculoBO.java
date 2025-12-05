package pe.edu.pucp.transitsoft.domimio.bo;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.bo.IBaseBO;
import pe.pucp.transitsoft.model.VehiculoDTO;

public interface IVehiculoBO extends IBaseBO<VehiculoDTO>{
    ArrayList<VehiculoDTO> listarVehiculosXID(int id_propietario, int tipoBD);
}
