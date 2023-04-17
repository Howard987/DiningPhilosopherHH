public class Fourchette {

    int nb;
    boolean fourchetteLibre = true;
    int fourchetteOccupe;

    public Fourchette(int nb) {
        this.nb = nb;
    }

    public synchronized void prendre(int philosophe) {

        while (!fourchetteLibre) {
            try {
                wait();
            }
            catch (InterruptedException ignored) {}
        }

        fourchetteOccupe = philosophe;

        fourchetteLibre = false;

    }

    public synchronized void deposer (int philosopher) {

        if (!fourchetteLibre && fourchetteOccupe == philosopher) {
            fourchetteLibre = true;
            notify();
        }
    }
}

