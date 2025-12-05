package pe.edu.pucp.transitsoft.dominio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dominio.dao.InfraccionDAO;
import pe.pucp.transitsoft.model.InfraccionDTO;

public class InfraccionImpl implements InfraccionDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(InfraccionDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(InfraccionDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public InfraccionDTO obtenerPorId(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<InfraccionDTO> listarTodos(int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
