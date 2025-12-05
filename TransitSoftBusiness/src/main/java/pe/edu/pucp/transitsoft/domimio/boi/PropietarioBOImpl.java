package pe.edu.pucp.transitsoft.domimio.boi;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.IPropietarioBO;
import pe.edu.pucp.transitsoft.dominio.impl.PropietarioImpl;
import pe.pucp.transitsoft.model.PropietarioDTO;

public class PropietarioBOImpl implements IPropietarioBO{

    private PropietarioImpl propietarioDA;
    
    public PropietarioBOImpl(){
        this.propietarioDA = new PropietarioImpl();
    }
    @Override
    public int insertar(PropietarioDTO objeto, int tipoBD) throws Exception {
        return propietarioDA.insertar(objeto, tipoBD);
    }

    @Override
    public int modificar(PropietarioDTO objeto, int tipoBD) throws Exception {
        return propietarioDA.modificar(objeto, tipoBD);
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) throws Exception {
        return propietarioDA.eliminar(idObjeto, tipoBD);
    }

    @Override
    public PropietarioDTO obtenerPorId(int idObjeto, int tipoBD) throws Exception {
        return propietarioDA.obtenerPorId(idObjeto, tipoBD);
    }

    @Override
    public ArrayList<PropietarioDTO> listarTodos(int tipoBD) throws Exception {
        return propietarioDA.listarTodos(tipoBD);
    }

    @Override
    public ArrayList<PropietarioDTO> listarPropietarioConVehiculo(int tipoBD) {
        return propietarioDA.listarPropietarioConVehiculo(tipoBD);
    }

    @Override
    public ArrayList<PropietarioDTO> listarPropietarioSinVehiculo(int tipoBD) {
        return propietarioDA.listarPropietarioSinVehiculo(tipoBD);
    }
    
    
}
