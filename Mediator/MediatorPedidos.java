package Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorPedidos implements Mediator {
    private List<Colaborador> colaboradores = new ArrayList<>();

    @Override
    public void enviar(String mensaje, Colaborador emisor) {
        for (Colaborador c : colaboradores) {
            if (c != emisor) {
                c.recibirMensaje(mensaje);
            }
        }
    }

    @Override
    public void registrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }
}
