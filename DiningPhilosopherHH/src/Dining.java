public class Dining {

    public static Philosopher[] Philo(int p)
    {

        Fourchette[] fourchettes = new Fourchette[p];

        for (int x = 0; x < p; x++)
        {
            fourchettes[x] = new Fourchette(x);
        }

        Philosopher[] philosophers = new Philosopher[p];

        for (int x = 0; x < p; x++)
        {

            Fourchette fourchetteGauche = fourchettes[x];
            Fourchette fourchetteDroite = fourchettes[(x + 1) % p];

            philosophers[x] = new Philosopher(x, fourchetteGauche, fourchetteDroite);

        }

        return philosophers;
    }
        
        public static void main(String[] args)
        {

            Philosopher[] philosophers = Philo(5);

            for (Philosopher philosopher : philosophers)
            {
                philosopher.start();
            }
        }

    }