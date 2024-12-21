
import java.util.Random;

public abstract class Animal implements Runnable {
    protected int x;
    protected int y;
    private String nombre;
    private EncuentroManager encuentroManager;
    protected boolean vivo = true;
    protected int vida;
    protected String especie;
    protected String sexo;

    public Animal(int x, int y, int vidaInicial, String especie, String nombre, EncuentroManager encuentroManager, String sexo) {
        this.x = x;
        this.y = y;
        this.vida = vidaInicial;
        this.especie = especie;
        this.nombre = nombre;
        this.encuentroManager = encuentroManager;
        this.sexo = sexo;
    }

    public Animal() { //Magic despues de poliformar plantas(me lo recomendo el mismo sistema y sin eso no compila)
    }


    public abstract void comer();

    public abstract void reproducirse();

    public abstract void morir();

    public boolean esCarnivoro() {
        return especie.equals("Carnivoro");
    }

    public boolean esHerbivoro() {
        return especie.equals("Herbivoro");
    }

    public String getNombre() {
        return nombre;
    }

    //Polimorfismo de animal a planta
    public boolean esPlanta(){
        return false;
    }
    public abstract void consumir();



    //Movimiento
    public boolean enLaMismaCasilla(Animal otro) {
        return this.x == otro.x && this.y == otro.y;
    }

    public int moverse(int[][] isla) {
        Random random = new Random();
        int nuevaX = x + random.nextInt(3) - 1; // -1, 0, 1
        int nuevaY = y + random.nextInt(3) - 1;

        // Verificar que no salga de los límites
        if (nuevaX >= 0 && nuevaX < isla.length && nuevaY >= 0 && nuevaY < isla[0].length) {
            x = nuevaX;
            y = nuevaY;
            System.out.println(this.nombre + this.sexo + "  se movio a la casilla " + this.x + " - " + this.y);
        }
        return nuevaX;
    }


    @Override
    public void run() {
        while (vivo) {
            moverse(Simulacion.isla);
            encuentroManager.verificarEncuentros(this);
            morir();

            try {
                Thread.sleep(1000); //los frena cuando hay algun evento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vida--; //Pierden vida cada que se encuentran
        }
    }

}

