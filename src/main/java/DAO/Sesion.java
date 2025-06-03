package DAO;

import POJOS.Cliente;

public class Sesion {

    private static Cliente clienteActual;

    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }
}
