package DAO;

import java.util.List;

public interface DAO<T, K> {
    void insertar(T obj);
    T obtenerPorId(K id);
    List<T> obtenerTodos();
    void actualizar(T obj);
    void eliminar(K id);
}
