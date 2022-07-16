package com.coding.test;

import java.util.concurrent.Callable;

interface Reptile {
    ReptileEgg lay();
}

class FireDragon implements Reptile{
    public FireDragon() {
    }

    public static void main(String[] args) throws Exception {
        FireDragon fireDragon = new FireDragon();
        System.out.println(fireDragon instanceof Reptile);
    }

    public ReptileEgg lay() {
        return null;
    }
}

class ReptileEgg {

    private static Reptile reptile = null;

    public ReptileEgg(Callable<Reptile> createReptile) throws Exception {
        reptile = createReptile.call();
    }

    public Reptile hatch() throws Exception {

        if (reptile != null) {
            throw  new IllegalStateException();
        }
        return reptile;
    }
}
