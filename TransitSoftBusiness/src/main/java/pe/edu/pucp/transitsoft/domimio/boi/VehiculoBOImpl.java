package pe.edu.pucp.transitsoft.domimio.boi;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.IVehiculoBO;
import pe.edu.pucp.transitsoft.dominio.impl.VehiculoImpl;
import pe.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoBOImpl implements IVehiculoBO{

    private VehiculoImpl vehiculoDAO;
    
    public VehiculoBOImpl(){
        this.vehiculoDAO = new VehiculoImpl();
    }

    @Override
    public int insertar(VehiculoDTO objeto, int tipoBD) throws Exception {
        return vehiculoDAO.insertar(objeto, tipoBD);
    }

    @Override
    public int modificar(VehiculoDTO objeto, int tipoBD) throws Exception {
        return vehiculoDAO.modificar(objeto, tipoBD);
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) throws Exception {
        return vehiculoDAO.eliminar(idObjeto, tipoBD);
    }

    @Override
    public VehiculoDTO obtenerPorId(int idObjeto, int tipoBD) throws Exception {
        return vehiculoDAO.obtenerPorId(idObjeto, tipoBD);
    }

    @Override
    public ArrayList<VehiculoDTO> listarTodos(int tipoBD) throws Exception {
        return vehiculoDAO.listarTodos(tipoBD);
    }

    @Override
    public ArrayList<VehiculoDTO> listarVehiculosXID(int id_propietario, int tipoBD) {
        return vehiculoDAO.listarVehiculosXID(id_propietario,tipoBD);
    }
    
}
