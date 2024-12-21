
import java.util.ArrayList;
import java.util.List;
public class Simulacion {
    public static int[][] isla = new int[10][10]; //TAMAÑO DE LA ISLA (10x10 es un tamaño equilobrado para la cantidad de animales)

    public static void main(String[] args) {

        System.out.println(" \uD83D\uDC3E \uD83C\uDF38 ¡Bienvenido al simulador de animales! \uD83C\uDF38 \uD83D\uDC3E ");

        int conteo = 0;

        List<Thread> hilos = new ArrayList<>();
        List<Animal> animales = new ArrayList<>();
        List<Planta> plantas = new ArrayList<>();

        EncuentroManager manager = new EncuentroManager(animales, plantas);

        //HAY QUE AGREGAR MANUALMENTE DONDE INICIA CADA ANIMAL EN LA ISLA
        // Carnivoros machos
        animales.add(new Lobo(1, 1, 19, "Carnivoro", " \uD83D\uDC3A ", manager, "\u2642"));
        animales.add(new Boa(2, 2, 16, "Carnivoro", " \uD83D\uDC0D ", manager, "\u2642"));
        animales.add(new Oso(3, 3, 20, "Carnivoro", " \uD83D\uDC3B ", manager, "\u2642"));
        animales.add(new Zorro(4, 4, 17, "Carnivoro", " \uD83E\uDD8A ", manager, "\u2642"));
        animales.add(new Aguila(5, 5, 18, "Carnivoro", " \uD83E\uDD85 ", manager, "\u2642"));

        //Carnivoros hembras
        animales.add(new Lobo(1, 2, 19, "Carnivoro", " \uD83D\uDC3A ", manager, "\u2640"));
        animales.add(new Boa(2, 1, 16, "Carnivoro", " \uD83D\uDC0D ", manager, "\u2640"));
        animales.add(new Oso(3, 2, 20, "Carnivoro", " \uD83D\uDC3B ", manager, "\u2640"));
        animales.add(new Zorro(4, 2, 17, "Carnivoro", " \uD83E\uDD8A ", manager, "\u2640"));
        animales.add(new Aguila(5, 2, 18, "Carnivoro", " \uD83E\uDD85 ", manager, "\u2640"));

        // Herbivoros machos
        animales.add(new Conejo(9, 5, 6, "Herbivoro", " \uD83D\uDC07 ", manager, "\u2642"));
        animales.add(new Ciervo(8, 5, 8, "Herbivoro", " \uD83E\uDD8C ", manager, "\u2642"));
        animales.add(new Jabali(7, 5, 12, "Herbivoro", " \uD83D\uDC17 ", manager, "\u2642"));
        animales.add(new Caballo(6, 5, 11, "Herbivoro", " \uD83D\uDC0E ", manager, "\u2642"));
        animales.add(new Raton(5, 5, 4, "Herbivoro", " \uD83D\uDC01 ", manager, "\u2642"));
        animales.add(new Cabra(4, 5, 9, "Herbivoro", " \uD83D\uDC10 ", manager, "\u2642"));
        animales.add(new Oveja(3, 5, 5, "Herbivoro", " \uD83D\uDC11 ", manager, "\u2642"));
        animales.add(new Bufalo(2, 5, 13, "Herbivoro", " \uD83D\uDC03 ", manager, "\u2642"));
        animales.add(new Pato(1, 5, 7, "Herbivoro", " \uD83E\uDD86 ", manager, "\u2642"));

        //Herbivoros hembras
        animales.add(new Conejo(9, 7, 6, "Herbivoro", " \uD83D\uDC07 ", manager, "\u2640"));
        animales.add(new Ciervo(8, 7, 8, "Herbivoro", " \uD83E\uDD8C ", manager, "\u2640"));
        animales.add(new Jabali(7, 7, 12, "Herbivoro", " \uD83D\uDC17 ", manager, "\u2640"));
        animales.add(new Caballo(6, 7, 11, "Herbivoro", " \uD83D\uDC0E ", manager, "\u2640"));
        animales.add(new Raton(5, 7, 4, "Herbivoro", " \uD83D\uDC01 ", manager, "\u2640"));
        animales.add(new Cabra(4, 7, 9, "Herbivoro", " \uD83D\uDC10 ", manager, "\u2640"));
        animales.add(new Oveja(3, 7, 5, "Herbivoro", " \uD83D\uDC11 ", manager, "\u2640"));
        animales.add(new Bufalo(2, 7, 13, "Herbivoro", " \uD83D\uDC03 ", manager, "\u2640"));
        animales.add(new Pato(1, 7, 7, "Herbivoro", " \uD83E\uDD86 ", manager, "\u2640"));

        //Plantas
        plantas.add(new Planta(2, 4));
        System.out.println("\uD83C\uDF3F en 2 - 4 ");
        plantas.add(new Planta(4, 6));
        System.out.println("\uD83C\uDF3F en 4 - 6 ");
        plantas.add(new Planta(6, 8));
        System.out.println("\uD83C\uDF3F en 6 - 8");
        plantas.add(new Planta(8, 10));
        System.out.println("\uD83C\uDF3F en 8 - 10 ");
        plantas.add(new Planta(4, 2));
        System.out.println("\uD83C\uDF3F en 4 - 2 ");
        plantas.add(new Planta(6, 4));
        System.out.println("\uD83C\uDF3F en 6 - 4 ");
        plantas.add(new Planta(8, 6));
        System.out.println("\uD83C\uDF3F en 8 - 6 ");
        plantas.add(new Planta(10, 8));
        System.out.println("\uD83C\uDF3F en 10 - 8 ");
        plantas.add(new Planta(5, 9));
        System.out.println("\uD83C\uDF3F en 5 - 9  ");
        plantas.add(new Planta(8, 7));
        System.out.println("\uD83C\uDF3F en 8 - 7 ");
        plantas.add(new Planta(6, 3));
        System.out.println("\uD83C\uDF3F en 6 - 3 ");
        plantas.add(new Planta(8, 9));
        System.out.println("\uD83C\uDF3F en 8 - 9 ");


        // Iniciar
        for (Animal animal : animales) {
            Thread hilo = new Thread(animal);
            hilos.add(hilo);
            hilo.start();
        }

        try {
            Thread.sleep(10000); //TIEMPO DE DURACION
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener los hilos
        for (Animal animal : animales) {
            animal.vivo = false;
            conteo++;
        }

        //ESTADISTICAS
        System.out.println("\n\n \uD83D\uDCCA Resultados finales ");

        System.out.println("\n \uD83D\uDD25 Cantidad de Encuentros: " + EncuentroManager.encuentros);
        System.out.println(" \u274C Cantidad de Muertes: " + EncuentroManager.muertes);
        System.out.println(" \uD83D\uDC23 Cantidad de Nacidos: " + EncuentroManager.nacidos);
        System.out.println(" \u2705 Cantidad de Salvaciones: " + EncuentroManager.salvaciones);
    }
}
