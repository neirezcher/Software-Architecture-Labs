package com.directi.training.lsp.proposed_solution;

public class Pool {
    public void run()
    {
        IDuck donaldDuck = new RealDuck();
        IDuck electricDuck = new ElectronicDuck(); // Now follows LSP
        electricDuck.quack();
        donaldDuck.quack();
    }
    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
