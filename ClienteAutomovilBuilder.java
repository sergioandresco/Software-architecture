public class ClienteAutomovilBuilder implements AutomovilBuilder {
  
    private String tipoMotor;
    private String color;
    private String tipoLlantas;
    private String sistemaSonido;
    private String interiores;
    private boolean tieneTechoSolar;
    private boolean tieneGPS;

    @Override
    public void setTipoMotor(String tipoMotor) { this.tipoMotor = tipoMotor; }

    @Override
    public void setColor(String color) { this.color = color; }

    @Override
    public void setTipoLlantas(String tipoLlantas) { this.tipoLlantas = tipoLlantas; }

    @Override
    public void setSistemaSonido(String sistemaSonido) { this.sistemaSonido = sistemaSonido; }

    @Override
    public void setInteriores(String interiores) { this.interiores = interiores; }

    @Override
    public void setTechoSolar(boolean tieneTechoSolar) { this.tieneTechoSolar = tieneTechoSolar; }

    @Override
    public void setNavegacionGPS(boolean tieneGPS) { this.tieneGPS = tieneGPS; }

    // Método de creación (<<create>> en el diagrama UML)
    public Automovil obtenerResultado() {
        return new Automovil(tipoMotor, color, tipoLlantas, sistemaSonido, 
                             interiores, tieneTechoSolar, tieneGPS);
    }
}