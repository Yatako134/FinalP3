package pe.edu.pucp.transitsoft.dominio.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.transitsoft.dominio.dao.CapturaDAO;
import pe.pucp.transitsoft.db.DBManager;
import pe.pucp.transitsoft.model.CamaraDTO;
import pe.pucp.transitsoft.model.CapturaDTO;
import pe.pucp.transitsoft.model.EstadoCapturaDTO;
import pe.pucp.transitsoft.model.PropietarioDTO;
import pe.pucp.transitsoft.model.VehiculoDTO;

public class CapturaImpl implements CapturaDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(CapturaDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(CapturaDTO objeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CapturaDTO obtenerPorId(int idObjeto, int tipoBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CapturaDTO> listarTodos(int tipoBD) {
        ArrayList<CapturaDTO> capturas = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarCapturas", null,tipoBD);
        try{
            while(rs.next()){
                if(capturas == null) capturas = new ArrayList<>();
                CapturaDTO captura = new CapturaDTO();
                captura.setId(rs.getInt("id"));
                captura.setPlaca(rs.getString("placa"));
                captura.setVelocidad(rs.getDouble("velocidad"));
                captura.setFechaCaptura(rs.getDate("fecha_captura"));
                captura.setEstado(EstadoCapturaDTO.valueOf(rs.getString("estado")));
                
                CamaraDTO camara = new CamaraDTO();
                camara.setId(rs.getInt("id_camara"));
                camara.setModelo(rs.getString("camara_modelo"));
                camara.setCodigoSerie(rs.getString("camara_codigo_serie"));
                camara.setLatitud(rs.getLong("camara_latitud"));
                camara.setLongitud(rs.getLong("camara_longitud"));
      
                PropietarioDTO propietario = new PropietarioDTO();
                propietario.setId(rs.getInt("id_propietario"));
                propietario.setDni(rs.getString("propietario_dni"));
                propietario.setNombres(rs.getString("propietario_nombres"));
                propietario.setApellidos(rs.getString("propietario_apellidos"));
                propietario.setDireccion(rs.getString("propietario_direccion"));
                
                VehiculoDTO vehiculo = new VehiculoDTO();
                vehiculo.setId(rs.getInt("id_vehiculo"));
                vehiculo.setPlaca(rs.getString("vehiculo_placa"));
                vehiculo.setMarca(rs.getString("vehiculo_marca"));
                vehiculo.setModelo(rs.getString("vehiculo_modelo"));
                vehiculo.setAnho(rs.getInt("vehiculo_anho"));
                
                captura.setCamara(camara);
                vehiculo.setPropietario(propietario);
                captura.setVehiculo(vehiculo);
                capturas.add(captura);                
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion(tipoBD);
        }
        return capturas;
    }
    
}
