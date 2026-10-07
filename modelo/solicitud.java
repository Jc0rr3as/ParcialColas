package modelo;
public class solicitud{
    private String nombre;
    private String id;
    private String origen;
    private String destino;
    private String mercancia;
    private double peso;
    private String prioridad;
    private String estado;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMercancia(String mercancia) {
        this.mercancia = mercancia;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public solicitud(){

    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getMercancia() {
        return mercancia;
    }

    public double getPeso() {
        return peso;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }
    
}