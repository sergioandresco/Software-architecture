public class DirectorAutomotriz {
    
    public void armarPaqueteDeportivo(AutomovilBuilder builder) {
        builder.setTipoMotor("V8 Turbo");
        builder.setColor("Rojo Fuego");
        builder.setTipoLlantas("Aleación Deportivas 19 pulgadas");
        builder.setSistemaSonido("Estándar");
        builder.setInteriores("Asientos deportivos de tela");
        builder.setTechoSolar(true);
        builder.setNavegacionGPS(false);
    }

    public void armarPaquetePremium(AutomovilBuilder builder) {
        builder.setTipoMotor("V6 Híbrido");
        builder.setColor("Negro Obsidiana");
        builder.setTipoLlantas("Llantas Clásicas 18 pulgadas");
        builder.setSistemaSonido("Bose Surround Sound");
        builder.setInteriores("Cuero Italiano Premium");
        builder.setTechoSolar(true);
        builder.setNavegacionGPS(true);
    }
}