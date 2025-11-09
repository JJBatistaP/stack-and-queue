package Buffer;

import java.util.LinkedList;
import java.util.Queue;

public class BufferMensajes {
    private final Queue<Mensaje> colaNormal = new LinkedList<>();
    private final Queue<Mensaje> colaUrgente = new LinkedList<>();
    private final long tiempoExpiracionMs;

    public BufferMensajes(long tiempoExpiracionMs) {
        this.tiempoExpiracionMs = tiempoExpiracionMs;
    }

    public synchronized void agregarMensaje(Mensaje mensaje) {
        limpiarMensajesExpirados();
        if (mensaje.esUrgente()) {
            colaUrgente.add(mensaje);
        } else {
            colaNormal.add(mensaje);
        }
    }

    public synchronized Mensaje obtenerMensaje() {
        limpiarMensajesExpirados();
        return !colaUrgente.isEmpty() ? colaUrgente.poll() : colaNormal.poll();
    }

    public synchronized Mensaje consultarMensaje() {
        limpiarMensajesExpirados();
        return !colaUrgente.isEmpty() ? colaUrgente.peek() : colaNormal.peek();
    }

    public synchronized int tamañoTotal() {
        limpiarMensajesExpirados();
        return colaUrgente.size() + colaNormal.size();
    }

    private void limpiarMensajesExpirados() {
        long ahora = System.currentTimeMillis();
        colaUrgente.removeIf(m -> ahora - m.getTimestamp() > tiempoExpiracionMs);
        colaNormal.removeIf(m -> ahora - m.getTimestamp() > tiempoExpiracionMs);
    }
}
