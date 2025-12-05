package pe.edu.pucp.transitsoft.dominio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dominio.dao.CamaraDAO;
import pe.pucp.transitsoft.model.CamaraDTO;

public class CamaraImpl implements CamaraDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(CamaraDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(CamaraDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CamaraDTO obtenerPorId(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CamaraDTO> listarTodos(int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
