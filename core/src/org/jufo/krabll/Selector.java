package org.jufo.krabll;


public class Selector {
    // population and elite
    private final int populationSize = 100;
    private final int eliteSize = 10;
    private Krabll[] population;
    private Krabll[] elite;
    
    // constructor
    public Selector() {
        this.population = new Krabll[populationSize];
        this.elite = new Krabll[eliteSize];
    }
    
    // getter and setter
    public Krabll[] getPopulation(){
        return population;
    }
    public Krabll[] getElite(){
        return elite;
    }
    
    // creates first generation of population
    public void createPopulation(){
        
    }
    
    // loops through the whole population, checks inputs and sets outputs
    public void checkPopulation(){
        if(!(population.length <= eliteSize)){
            for(int a = 0; a < population.length; a++){
                population[a].applyInputs();
            }
            for(int a = 0; a < population.length; a++){
                population[a].performOutputs();
            }
        }
        else {
            //copy the elite krablls to elite array
            int eliteIndex = 0;
            for (int i = 0; i < populationSize; i++)
                if (!population[i].isAlive())
                    elite[eliteIndex++] = population[i];
            
            Network eliteNetwork = findEliteNetwork();
            // TODO: create new population based on eliteNetwork
            // TODO: clear new population array
        }
    }
    
    // returns the mixed networks of the elite
    Network findEliteNetwork() {
        Network[] eliteNetworks = new Network[eliteSize];
        for(int a = 0; a < eliteSize; a++){
            eliteNetworks[a] = elite[a].getNetwork();
        }
        Network network = mixNetworks(eliteNetworks);
        return network;
    }
    
    // generates a random neural network
    Network randomNetwork() {
        boolean[] inputs = new boolean[14];
        boolean[] outputs = new boolean[14];
        Neuron[] neurons = new Neuron[28];
        for(int a = 0; a < neurons.length; a++){
            neurons[a].setThreshold((int) (Math.random() * 14 + 1));
        }
        // TODO: generate links randomly
        Network network = new Network(inputs, neurons, outputs);
        return network;
    }
    
    // mixes multiple neural networks
    Network mixNetworks(Network[] networks){
        // TODO: write mixing algorithm
        return null;
    }
}