package pe.edu.pucp.transitsoft.bo;

import java.util.ArrayList;

public interface IBaseBO <T>{
    int insertar(T objeto,int tipoBD) throws Exception;
    int modificar(T objeto,int tipoBD) throws Exception;
    int eliminar(int idObjeto,int tipoBD) throws Exception;
    T obtenerPorId(int idObjeto,int tipoBD) throws Exception;
    ArrayList<T> listarTodos(int tipoBD) throws Exception;
}
