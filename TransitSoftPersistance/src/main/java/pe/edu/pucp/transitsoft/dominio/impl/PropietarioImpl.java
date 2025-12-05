package pe.edu.pucp.transitsoft.dominio.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transitsoft.dominio.dao.PropietarioDAO;
import pe.pucp.transitsoft.db.DBManager;
import pe.pucp.transitsoft.model.PropietarioDTO;


public class PropietarioImpl implements PropietarioDAO{
    
    private ResultSet rs;
    
    @Override
    public int insertar(PropietarioDTO propietario,int tipoBD) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, propietario.getDni());
        parametrosEntrada.put(3, propietario.getNombres());
        parametrosEntrada.put(4, propietario.getApellidos());
        parametrosEntrada.put(5, propietario.getDireccion());
        DBManager.getInstance().ejecutarProcedimiento("insertarPropietario", parametrosEntrada, parametrosSalida,tipoBD);
        propietario.setId((int) parametrosSalida.get(1));

        return propietario.getId();
    }

    @Override
    public int modificar(PropietarioDTO objeto, int tipoBD) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, objeto.getId());
        parametrosEntrada.put(2, objeto.getDni());
        parametrosEntrada.put(3, objeto.getNombres());
        parametrosEntrada.put(4, objeto.getApellidos());
        parametrosEntrada.put(5, objeto.getDireccion());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("modificarPropietario", parametrosEntrada, null,tipoBD);
        return resultado;
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idObjeto);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminarPropietario", parametrosEntrada, null,tipoBD);
        return resultado;
    }

    @Override
    public PropietarioDTO obtenerPorId(int idObjeto, int tipoBD) {
        PropietarioDTO propietario = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idObjeto);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerXIDPropietario", parametrosEntrada,tipoBD);
        try{
            if(rs.next()){
                propietario = new PropietarioDTO();
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return propietario;
    }

    @Override
    public ArrayList<PropietarioDTO> listarTodos(int tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("ListarPropietariosTodos", null,tipoBD);
        try{
            while(rs.next()){
                if(propietarios == null) propietarios = new ArrayList<>();
                PropietarioDTO propietario = new PropietarioDTO();
                
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
                propietarios.add(propietario);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return propietarios;
    }
    
    @Override
    public ArrayList<PropietarioDTO> listarPropietarioConVehiculo(int tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_PROPIETARIOS_CON_VEHICULO", null,tipoBD);
        try{
            while(rs.next()){
                if(propietarios == null) propietarios = new ArrayList<>();
                PropietarioDTO propietario = new PropietarioDTO();
                
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
                propietarios.add(propietario);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return propietarios;
    }
    
    @Override
    public ArrayList<PropietarioDTO> listarPropietarioSinVehiculo(int tipoBD) {
        ArrayList<PropietarioDTO> propietarios = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_PROPIETARIOS_SIN_VEHICULO", null,tipoBD);
        try{
            while(rs.next()){
                if(propietarios == null) propietarios = new ArrayList<>();
                PropietarioDTO propietario = new PropietarioDTO();
                
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
                propietarios.add(propietario);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return propietarios;
    }
    

}
