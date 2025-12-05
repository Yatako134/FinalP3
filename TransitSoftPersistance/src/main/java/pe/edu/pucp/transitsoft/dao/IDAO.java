package pe.edu.pucp.transitsoft.dao;

import java.util.ArrayList;

public interface IDAO <T> {
    int insertar(T objeto,int tipoBD);
    int modificar(T objeto,int tipoBD);
    int eliminar(int idObjeto,int tipoBD);
    T obtenerPorId(int idObjeto,int tipoBD);
    ArrayList<T> listarTodos(int tipoBD);
}
