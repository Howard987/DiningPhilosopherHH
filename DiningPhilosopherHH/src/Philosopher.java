import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    Semaphore semaphore = new Semaphore(5);

    int nb;
    Fourchette fourchetteGauche;
    Fourchette fourchetteDroite;

    public Philosopher(int nb, Fourchette fourchetteGauche, Fourchette fourchetteDroite)
    {
        this.nb = nb;
        this.fourchetteGauche = fourchetteGauche;
        this.fourchetteDroite = fourchetteDroite;
    }

	public void run() {
        for (;;) {
            System.out.println("Philosophe " + nb + " pense");
            semaphore.acquireUninterruptibly();
            fourchetteGauche.prendre(nb);
            System.out.println("Philosophe " + nb + " prend la fourchette gauche");
            fourchetteDroite.prendre(nb);
            semaphore.release();
            System.out.println("Philosophe " + nb + " prend la fourchette droite");
            System.out.println("Philosophe " + nb + " mange");
            fourchetteGauche.deposer(nb);
            System.out.println("Philosophe" + nb + " depose la fourchette gauche");
            fourchetteDroite.deposer(nb);
            System.out.println("Philosophe " + nb + " depose la fourchette droite");
        }
    }
}
