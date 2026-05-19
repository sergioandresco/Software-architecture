public class Automovil {
    // Atributos inmutables
    private final String tipoMotor;
    private final String color;
    private final String tipoLlantas;
    private final String sistemaSonido;
    private final String interiores;
    private final boolean tieneTechoSolar;
    private final boolean tieneGPS;

    // Constructor
    public Automovil(String tipoMotor, String color, String tipoLlantas, 
                     String sistemaSonido, String interiores, 
                     boolean tieneTechoSolar, boolean tieneGPS) {
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.tipoLlantas = tipoLlantas;
        this.sistemaSonido = sistemaSonido;
        this.interiores = interiores;
        this.tieneTechoSolar = tieneTechoSolar;
        this.tieneGPS = tieneGPS;
    }

    // Solo métodos
    public String getTipoMotor() { return tipoMotor; }
    public String getColor() { return color; }
    public String getTipoLlantas() { return tipoLlantas; }
    public String getSistemaSonido() { return sistemaSonido; }
    public String getInteriores() { return interiores; }
    public boolean tieneTechoSolar() { return tieneTechoSolar; }
    public boolean tieneGPS() { return tieneGPS; }

    @Override
    public String toString() {
        return "Automovil [Motor=" + tipoMotor + ", Color=" + color + 
               ", Llantas=" + tipoLlantas + ", Sonido=" + sistemaSonido + 
               ", Interiores=" + interiores + ", Techo=" + tieneTechoSolar + 
               ", GPS=" + tieneGPS + "]";
    }
}