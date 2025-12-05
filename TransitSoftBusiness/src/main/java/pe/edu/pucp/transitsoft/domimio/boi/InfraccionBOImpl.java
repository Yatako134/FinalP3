package pe.edu.pucp.transitsoft.domimio.boi;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.IinfraccionBO;
import pe.edu.pucp.transitsoft.dominio.impl.InfraccionImpl;
import pe.pucp.transitsoft.model.InfraccionDTO;

public class InfraccionBOImpl implements IinfraccionBO{
    private InfraccionImpl infraccionDA;
    
    public InfraccionBOImpl(){
        infraccionDA = new InfraccionImpl();
    }
    
    @Override
    public int insertar(InfraccionDTO objeto, int tipoBD) throws Exception {
        return infraccionDA.insertar(objeto, tipoBD);
    }

    @Override
    public int modificar(InfraccionDTO objeto, int tipoBD) throws Exception {
        return infraccionDA.modificar(objeto, tipoBD);
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) throws Exception {
        return infraccionDA.eliminar(idObjeto, tipoBD);
    }

    @Override
    public InfraccionDTO obtenerPorId(int idObjeto, int tipoBD) throws Exception {
        return infraccionDA.obtenerPorId(idObjeto, tipoBD);
    }

    @Override
    public ArrayList<InfraccionDTO> listarTodos(int tipoBD) throws Exception {
        return infraccionDA.listarTodos(tipoBD);
    }
    
}
