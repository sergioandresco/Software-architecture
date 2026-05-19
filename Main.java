public class Main {
    public static void main(String[] args) {
        DirectorAutomotriz director = new DirectorAutomotriz();
        
        ClienteAutomovilBuilder builderPremium = new ClienteAutomovilBuilder();
        director.armarPaquetePremium(builderPremium);
        
        Automovil autoPremium = builderPremium.obtenerResultado();
        System.out.println("Auto Premium fabricado:\n" + autoPremium.toString());

        System.out.println("\n-----------------------------------\n");

        ClienteAutomovilBuilder builderPersonalizado = new ClienteAutomovilBuilder();
        builderPersonalizado.setTipoMotor("Eléctrico Dual Motor");
        builderPersonalizado.setColor("Negro");
        builderPersonalizado.setTipoLlantas("Aerodinámicas 20 pulgadas");
        builderPersonalizado.setSistemaSonido("Harman Kardon");
        builderPersonalizado.setInteriores("Cuero Negro");
        builderPersonalizado.setTechoSolar(true);
        builderPersonalizado.setNavegacionGPS(true);
        
        Automovil autoPersonalizado = builderPersonalizado.obtenerResultado();
        System.out.println("Auto Personalizado fabricado:\n" + autoPersonalizado.toString());
    }
}