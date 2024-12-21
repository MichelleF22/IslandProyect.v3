public class Boa extends Animal {
    public Boa(int x, int y, int vidaInicial, String especie, String nombre, EncuentroManager encuentroManager, String sexo) {
        super(
                x,
                y,
                vidaInicial,
                especie,
                nombre,
                encuentroManager,
                sexo);
    }

    @Override
    public void comer() {
        System.out.println(" \uD83C\uDF56 La boa abre sus mandíbulas y comienza a devorar a su presa en: (" + x + "- " + y + ")");
        vida++;

    }

    @Override
    public void reproducirse() {
        Thread nuevoHilo = new Thread(() -> {
            System.out.println(" \uD83C\uDF7C Nació una nueva cría de " + getNombre() + " en (" + x + " - " + y + ")");
        }, getNombre());

        nuevoHilo.start();
    }

    public void morir() {
        if (vida <= 0) {
            vivo = false;
        }
    }

    // IGNORAR - Poliformismo de planta
    @Override
    public boolean esPlanta() {
        return false;
    }
    @Override
    public void consumir() {
    }

}
