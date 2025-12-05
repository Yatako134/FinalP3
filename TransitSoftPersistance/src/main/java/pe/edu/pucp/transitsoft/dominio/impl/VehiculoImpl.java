package pe.edu.pucp.transitsoft.dominio.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transitsoft.dominio.dao.VehiculoDAO;
import pe.pucp.transitsoft.db.DBManager;
import pe.pucp.transitsoft.model.VehiculoDTO;


public class VehiculoImpl implements VehiculoDAO{
     private ResultSet rs;

    @Override
    public int insertar(VehiculoDTO objeto, int tipoBD) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, objeto.getPlaca());
        parametrosEntrada.put(3, objeto.getMarca());
        parametrosEntrada.put(4, objeto.getModelo());
        parametrosEntrada.put(5, objeto.getAnho());
        DBManager.getInstance().ejecutarProcedimiento("insertarVehiculo", parametrosEntrada, parametrosSalida,tipoBD);
        objeto.setId((int) parametrosSalida.get(1));

        return objeto.getId();
    }

    @Override
    public int modificar(VehiculoDTO objeto, int tipoBD) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, objeto.getId());
        parametrosEntrada.put(2, objeto.getPlaca());
        parametrosEntrada.put(3, objeto.getMarca());
        parametrosEntrada.put(4, objeto.getModelo());
        parametrosEntrada.put(5, objeto.getAnho());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("modificarVehiculo", parametrosEntrada, null,tipoBD);
        return resultado;
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idObjeto);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("eliminarVehiculo", parametrosEntrada, null,tipoBD);
        return resultado;
    }

    @Override
    public VehiculoDTO obtenerPorId(int idObjeto, int tipoBD) {
        VehiculoDTO vehiculo = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idObjeto);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerXIDVehiculo", parametrosEntrada,tipoBD);
        try{
            if(rs.next()){
                vehiculo = new VehiculoDTO();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnho(rs.getInt("anho"));
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return vehiculo;
    }

    @Override
    public ArrayList<VehiculoDTO> listarTodos(int tipoBD) {
        ArrayList<VehiculoDTO> vehiculos = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("ListarVehiculosTodos", null,tipoBD);
        try{
            while(rs.next()){
                if(vehiculos == null) vehiculos = new ArrayList<>();
                VehiculoDTO vehiculo = new VehiculoDTO();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnho(rs.getInt("anho"));
                vehiculos.add(vehiculo);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return vehiculos;
    }

    @Override
    public ArrayList<VehiculoDTO> listarVehiculosXID(int id_propietario, int tipoBD) {
        ArrayList<VehiculoDTO> vehiculos = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id_propietario);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_VEHICULOS_X_ID_PROPIETARIO", parametrosEntrada,tipoBD);
        try{
            while(rs.next()){
                if(vehiculos == null) vehiculos = new ArrayList<>();
                VehiculoDTO vehiculo = new VehiculoDTO();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnho(rs.getInt("anho"));
                vehiculos.add(vehiculo);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return vehiculos;
    }
     

    
}
