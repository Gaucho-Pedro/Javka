package zoo;

public class Main {

    public static void main(String[] argv) {

        String filePath = argv[1];

//        // Create zoo
        Zoo zoo = new Zoo();
        // Add animals to the zoo
        if (argv[0].equals("json")) {
            zoo.addAnimalsJson(filePath);
        } else if (argv[0].equals("xml")) {
            zoo.addAnimalsXml(filePath);
        }
        //zoo.addAnimalsXml(filePath);

        // Create user action trigger
        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
//        trigger.visit(carnivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setRain();
        zoo.printAllStates();
        
    }
}