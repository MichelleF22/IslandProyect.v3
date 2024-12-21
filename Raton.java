public class Raton extends Animal {
    public Raton(int x, int y, int vidaInicial, String especie, String nombre, EncuentroManager encuentroManager, String sexo) {
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
        System.out.println(" \uD83C\uDF31 El ratón se lleva un pedazo de alimento a su boca en (" + x + ", " + y + ")");

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
