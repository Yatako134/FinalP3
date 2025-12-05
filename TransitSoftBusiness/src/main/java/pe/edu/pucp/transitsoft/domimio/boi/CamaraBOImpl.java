package pe.edu.pucp.transitsoft.domimio.boi;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.ICamaraBO;
import pe.edu.pucp.transitsoft.dominio.impl.CamaraImpl;
import pe.pucp.transitsoft.model.CamaraDTO;

public class CamaraBOImpl implements ICamaraBO{

    private CamaraImpl camaraDA;
    
    public CamaraBOImpl(){
        camaraDA = new CamaraImpl();
    }
    
    @Override
    public int insertar(CamaraDTO objeto, int tipoBD) throws Exception {
        return camaraDA.insertar(objeto, tipoBD);
    }

    @Override
    public int modificar(CamaraDTO objeto, int tipoBD) throws Exception {
        return camaraDA.modificar(objeto, tipoBD);
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) throws Exception {
        return camaraDA.eliminar(idObjeto, tipoBD);
    }

    @Override
    public CamaraDTO obtenerPorId(int idObjeto, int tipoBD) throws Exception {
        return camaraDA.obtenerPorId(idObjeto, tipoBD);
    }

    @Override
    public ArrayList<CamaraDTO> listarTodos(int tipoBD) throws Exception {
        return camaraDA.listarTodos(tipoBD);
    }
    
}
