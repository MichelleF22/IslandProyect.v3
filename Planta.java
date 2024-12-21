
public class Planta extends Animal{
    int x;
    int y;
    boolean disponible = true;

    public Planta(int x, int y) {
        super(x, y, 0, "Planta", "\uD83C\uDF3F", null, "");
    }

    public boolean esPlanta() {
        return true;
    }

    public void consumir() {
        disponible = false;
        System.out.println(" \uD83C\uDF43 Una planta fue comida");
    }

    public boolean estaDisponible() {
        return disponible;
    }

    //Hice polimorfismo de un animal para implemenmtar planta por eso los metodos estan vacios
    @Override
    public void comer() {

    }

    @Override
    public void reproducirse() {

    }

    @Override
    public void morir() {

    }

    @Override
    public int moverse(int[][] isla) {
        return 0;
    }

}
