package pe.edu.pucp.transitsoft.domimio.boi;

import java.util.ArrayList;
import pe.edu.pucp.transitsoft.domimio.bo.ICapturaBO;
import pe.edu.pucp.transitsoft.dominio.impl.CapturaImpl;
import pe.pucp.transitsoft.model.CapturaDTO;

public class CapturaBOImpl implements ICapturaBO{

    
    private CapturaImpl capturaDA;
    
    public CapturaBOImpl(){
        capturaDA = new CapturaImpl();
    }
    
    @Override
    public int insertar(CapturaDTO objeto, int tipoBD) throws Exception {
        return capturaDA.insertar(objeto, tipoBD);
    }

    @Override
    public int modificar(CapturaDTO objeto, int tipoBD) throws Exception {
        return capturaDA.modificar(objeto, tipoBD);
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) throws Exception {
        return capturaDA.eliminar(idObjeto, tipoBD);
    }

    @Override
    public CapturaDTO obtenerPorId(int idObjeto, int tipoBD) throws Exception {
        return capturaDA.obtenerPorId(idObjeto, tipoBD);
    }

    @Override
    public ArrayList<CapturaDTO> listarTodos(int tipoBD) throws Exception {
        return capturaDA.listarTodos(tipoBD);
    }
    
}
