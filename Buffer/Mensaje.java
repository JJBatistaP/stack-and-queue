public class Mensaje {
    private final String contenido;
    private final boolean urgente;
    private final long timestamp;

    public Mensaje(String contenido, boolean urgente) {
        this.contenido = contenido;
        this.urgente = urgente;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContenido() { return contenido; }
    public boolean esUrgente() { return urgente; }
    public long getTimestamp() { return timestamp; }
}
