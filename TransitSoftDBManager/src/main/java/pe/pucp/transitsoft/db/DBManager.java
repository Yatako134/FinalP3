package pe.pucp.transitsoft.db;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Properties;
import pe.pucp.transitsoft.db.Encriptamiento;

public class DBManager {
    
    private static DBManager dbManager;
    private Properties datos;
    
    private final String user;
    private final String password;
    private final String database;
    private Connection conMysql;
    private Connection conMSSQL;
    
    private final String cadenaMySQL;
    private final String cadenaMSSQL;
    
    private ResultSet rs;
    
    private String ruta = "db.properties";
    
    private DBManager(){
        datos = new Properties();
        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ruta);
            datos.load(inputStream);
        }catch(IOException ex){
            System.out.println("Error leyendo el archivo de datos de conexion: " + ex.getMessage());
        }
        
        this.database = datos.getProperty("database");
        // MSSQL
        
        cadenaMSSQL ="jdbc:sqlserver://"+ datos.getProperty("hostnamemssql") + ";databaseName=" + this.database +
                ";encrypt=false;trustServerCertificate=" + "true;integratedSecurity=false;";
        // MYSQL
        cadenaMySQL = "jdbc:mysql://" + datos.getProperty("hostnamemysql") + "/" + this.database + "?useSSL=false";
               
        
        this.user = datos.getProperty("usuario");
        this.password = Encriptamiento.desencriptar(datos.getProperty("passwordEncriptado"),datos.getProperty("key"));
        
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            dbManager = new DBManager();
        return dbManager;
    }
    
    public Connection getConnection(int tipoBD) {
    try {
        if (tipoBD == 0) {
            // MySQL
            if (conMysql == null || conMysql.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conMysql = DriverManager.getConnection(cadenaMySQL, user, password);
                System.out.println("Conexión MySQL establecida.");
            }
            return conMysql;

        } else if (tipoBD == 1) {
            // MSSQL
            if (conMSSQL == null || conMSSQL.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conMSSQL = DriverManager.getConnection(cadenaMSSQL, user, password);
                System.out.println("Conexión MSSQL establecida.");
            }
            return conMSSQL;
        }

    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("Error al intentar conectar con la base de datos: " + ex.getMessage());
    }

    return null;
}
    
    public void cerrarConexion(int tipoBD) {
    try {
        if (tipoBD == 0) {  // MySQL
            if (conMysql != null && !conMysql.isClosed()) {
                conMysql.close();
                System.out.println("Conexión MySQL cerrada.");
            }
        } else if (tipoBD == 1) { // MSSQL
            if (conMSSQL != null && !conMSSQL.isClosed()) {
                conMSSQL.close();
                System.out.println("Conexión MSSQL cerrada.");
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al cerrar la conexión: " + ex.getMessage());
    }
}
    
    //Métodos para llamadas a Procedimientos Almacenados
    public int ejecutarProcedimiento(String nombreProcedimiento, Map<Integer, Object> parametrosEntrada, Map<Integer, Object> parametrosSalida,int tipoBD) {
        int resultado = 0;
        try{
            CallableStatement cst = formarLlamadaProcedimiento(nombreProcedimiento, parametrosEntrada, parametrosSalida,tipoBD);
            if(parametrosEntrada != null)
                registrarParametrosEntrada(cst, parametrosEntrada);
            if(parametrosSalida != null)
                registrarParametrosSalida(cst, parametrosSalida);
        
            resultado = cst.executeUpdate();
        
            if(parametrosSalida != null)
                obtenerValoresSalida(cst, parametrosSalida);
        }catch(SQLException ex){
            System.out.println("Error ejecutando procedimiento almacenado: " + ex.getMessage());
        }finally{
            cerrarConexion(tipoBD);
        }
        return resultado;
    }
    
    public ResultSet ejecutarProcedimientoLectura(String nombreProcedimiento, Map<Integer,Object> parametrosEntrada,int tipoBD){
        try{
            CallableStatement cs = formarLlamadaProcedimiento(nombreProcedimiento, parametrosEntrada, null,tipoBD);
            if(parametrosEntrada!=null)
                registrarParametrosEntrada(cs,parametrosEntrada);
            rs = cs.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error ejecutando procedimiento almacenado de lectura: " + ex.getMessage());
        }
        return rs;
    }
    
    public CallableStatement formarLlamadaProcedimiento(String nombreProcedimiento, Map<Integer, Object> parametrosEntrada, Map<Integer, Object> parametrosSalida,int tipoBD) throws SQLException{
        Connection con = getConnection(tipoBD);
        StringBuilder call = new StringBuilder("{call " + nombreProcedimiento + "(");
        int cantParametrosEntrada = 0;
        int cantParametrosSalida = 0;
        if(parametrosEntrada!=null) cantParametrosEntrada = parametrosEntrada.size();
        if(parametrosSalida!=null) cantParametrosSalida = parametrosSalida.size();
        int numParams =  cantParametrosEntrada + cantParametrosSalida;
        for (int i = 0; i < numParams; i++) {
            call.append("?");
            if (i < numParams - 1) {
                call.append(",");
            }
        }
        call.append(")}");
        return con.prepareCall(call.toString());
    }
    
    private void registrarParametrosEntrada(CallableStatement cs, Map<Integer, Object> parametros) throws SQLException {
        for (Map.Entry<Integer, Object> entry : parametros.entrySet()) {
            Integer key = entry.getKey();
            Object value = entry.getValue();
            switch (value) {
                case Integer entero -> cs.setInt(key, entero);
                case String cadena -> cs.setString(key, cadena);
                case Double decimal -> cs.setDouble(key, decimal);
                case Boolean booleano -> cs.setBoolean(key, booleano);
                case java.util.Date fecha -> cs.setDate(key, new java.sql.Date(fecha.getTime()));
                case Character caracter -> cs.setString(key, String.valueOf(caracter));
                case byte[] archivo -> cs.setBytes(key, archivo);
                default -> {
                }
                // Agregar más tipos según sea necesario
            }
        }
    }
    
    private void registrarParametrosSalida(CallableStatement cst, Map<Integer, Object> params) throws SQLException {
        for (Map.Entry<Integer, Object> entry : params.entrySet()) {
            Integer posicion = entry.getKey();
            int sqlType = (int) entry.getValue();
            cst.registerOutParameter(posicion, sqlType);
        }
    }
    
    private void obtenerValoresSalida(CallableStatement cst, Map<Integer, Object> parametrosSalida) throws SQLException {
        for (Map.Entry<Integer, Object> entry : parametrosSalida.entrySet()) {
            Integer posicion = entry.getKey();
            int sqlType = (int) entry.getValue();
            Object value = null;
            switch (sqlType) {
                case Types.INTEGER -> value = cst.getInt(posicion);
                case Types.VARCHAR -> value = cst.getString(posicion);
                case Types.DOUBLE -> value = cst.getDouble(posicion);
                case Types.BOOLEAN -> value = cst.getBoolean(posicion);
                case Types.DATE -> value = cst.getDate(posicion);
                case Types.BLOB -> value = cst.getBytes(posicion);
                // Agregar más tipos según sea necesario
            }
            parametrosSalida.put(posicion, value);
        }
    }
}