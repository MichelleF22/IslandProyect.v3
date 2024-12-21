
import java.util.List;

public class EncuentroManager {
    private final List<Animal> animales;
    private final List<Planta> plantas;
    static int encuentros;
    static int salvaciones;
    static int muertes;
    static int nacidos;

    public EncuentroManager(List<Animal> animales, List<Planta> plantas) {
        this.animales = animales;
        this.plantas = plantas;
    }

    private void verificarPlantas(Animal animalActual) {
        for (Planta planta : plantas) {
            if (animalActual.enLaMismaCasilla(planta) && planta.estaDisponible()) {
                animalActual.comer();
                planta.consumir();
            }
        }
    }

    public void verificarEncuentros(Animal animalActual) {
        synchronized (animales) {
            for (Animal otro : animales) {
                if (animalActual != otro && animalActual.enLaMismaCasilla(otro)) {
                    resolverEncuentro(animalActual, otro);
                }
            }

            // Verificar si hay una planta en la misma posición para herbívoros
            if (animalActual.esHerbivoro()) {
                verificarPlantas(animalActual);
            }
        }
    }

    private void resolverEncuentro(Animal a, Animal b) {
        System.out.println(" \uD83D\uDD25 " + "¡Encuentro! " + a.getNombre() + " se encontró con " + b.getNombre());
        encuentros++;

        // Ataques
        if (a.esCarnivoro() && b.esHerbivoro()) {
            System.out.println(" \u274C " + a.getNombre() + " atrapó a " + b.getNombre());
            b.morir();
            a.comer();
            muertes++;
        } else if (b.esCarnivoro() && a.esHerbivoro()) {
            System.out.println(" \u274C " + b.getNombre() + " atrapó a " + a.getNombre());
            a.morir();
            b.comer();
            muertes++;
        }

        // Interacción con plantas
        else if (b.esPlanta() && a.esHerbivoro()) {
            System.out.println(" \uD83C\uDF31 " + a.getNombre() + " comió una planta.");
            a.comer();
            b.consumir();
        } else if (a.esPlanta() && b.esHerbivoro()) {
            System.out.println(" \uD83C\uDF31 " + b.getNombre() + " comió una planta.");
            b.comer();
            a.consumir();
        }

        // Reproducciones
        else if (a.getNombre().equals(b.getNombre()) &&
                ((a.sexo.equals("\u2642") && b.sexo.equals("\u2640")) ||
                        (a.sexo.equals("\u2640") && b.sexo.equals("\u2642")))) {
            a.reproducirse();
            nacidos++;
        }

        // Salvaciones
        else {
            System.out.println(" \u2705 " + "No pasó nada entre " + a.getNombre() + " y " + b.getNombre());
            salvaciones++;
        }
    }

}
