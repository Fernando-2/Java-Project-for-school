import java.util.ArrayList;
import java.util.Scanner;

// Main class to run the application
public class Driver {

    // Lists to keep track of dog and monkey objects
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add default animals to the lists
        initializeDogList();
        initializeMonkeyList();

        String choice;

        // Menu loop continues until user quits by entering 'q'
        do {
            displayMenu(); // Show menu options
            choice = scanner.nextLine().trim().toLowerCase(); // Read user input

            // Handle menu selection
            switch (choice) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (!choice.equals("q"));
    }

    // Displays the main menu to the user
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.print("Enter a menu selection: ");
    }

    // Adds sample dogs to the dog list
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds sample monkeys to the monkey list
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("George", "Capuchin", "male", 2, 15.4, "03-11-2021", "Brazil", "in service", false, "Brazil", "10", "2", "5");
        Monkey monkey2 = new Monkey("Coco", "Marmoset", "female", 3, 12.7, "06-08-2020", "Peru", "Phase I", false, "Peru", "8", "1.8", "4");
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    // Allows user to add a new dog (now fully implemented)
    public static void intakeNewDog(Scanner scanner) {
        System.out.print("Enter the dog's name: ");
        String name = scanner.nextLine();

        // Check if the dog already exists
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("This dog is already in our system.");
                return;
            }
        }

        // Input details for the new dog
        System.out.print("Enter the dog's breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter the dog's gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter the dog's age: ");
        String age = scanner.nextLine();
        System.out.print("Enter the dog's weight: ");
        String weight = scanner.nextLine();
        System.out.print("Enter the acquisition date: ");
        String acqDate = scanner.nextLine();
        System.out.print("Enter the acquisition country: ");
        String acqCountry = scanner.nextLine();
        System.out.print("Enter the training status: ");
        String training = scanner.nextLine();
        System.out.print("Is the dog reserved (true/false): ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter in service country: ");
        String serviceCountry = scanner.nextLine();

        // Create new Dog and add to list
        Dog dog = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, training, reserved, serviceCountry);
        dogList.add(dog);
        System.out.println("Dog added successfully.");
    }

    // Allows user to add a new monkey (already fully implemented)
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.print("Enter the monkey's name: ");
        String name = scanner.nextLine();

        // Check if monkey already exists
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("This monkey is already in our system.");
                return;
            }
        }

        // Input details for the new monkey
        System.out.print("Enter the monkey's species: ");
        String species = scanner.nextLine();
        if (!species.equalsIgnoreCase("Capuchin") && !species.equalsIgnoreCase("Guenon") &&
            !species.equalsIgnoreCase("Macaque") && !species.equalsIgnoreCase("Marmoset") &&
            !species.equalsIgnoreCase("Squirrel monkey") && !species.equalsIgnoreCase("Tamarin")) {
            System.out.println("Invalid species.");
            return;
        }

        System.out.print("Enter the monkey's gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter the monkey's age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the monkey's weight: ");
        String weight = scanner.nextLine();
        System.out.print("Enter the acquisition date: ");
        String acqDate = scanner.nextLine();
        System.out.print("Enter the acquisition country: ");
        String acqCountry = scanner.nextLine();
        System.out.print("Enter the training status: ");
        String training = scanner.nextLine();
        System.out.print("Enter in service country: ");
        String serviceCountry = scanner.nextLine();
        System.out.print("Is the monkey reserved (true/false): ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter tail length: ");
        int tailLength = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter height: ");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter body length: ");
        String bodyLength = scanner.nextLine();

        // Create new Monkey and add to list
        Monkey monkey = new Monkey(name, species, gender, bodyLength, weight, acqDate, acqCountry, training, reserved, serviceCountry, tailLength, height, age);
        monkeyList.add(monkey);
        System.out.println("Monkey added successfully.");
    }

    // Reserve an animal if it is "in service" and not yet reserved
    public static void reserveAnimal(Scanner scanner) {
        System.out.print("Enter animal type (dog or monkey): ");
        String type = scanner.nextLine();

        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        // Check for a matching dog
        if (type.equalsIgnoreCase("dog")) {
            for (int i = 0; i < dogList.size(); i++) {
                Dog dog = dogList.get(i);
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") &&
                    dog.getInServiceLocation().equalsIgnoreCase(country) &&
                    !dog.getReserved()) {

                    dog.setReserved(true);
                    System.out.println("Dog " + dog.getName() + " has been reserved.");
                    return;
                }
            }
            System.out.println("No available dogs found in " + country + ".");
        }

        // Check for a matching monkey
        else if (type.equalsIgnoreCase("monkey")) {
            for (int i = 0; i < monkeyList.size(); i++) {
                Monkey monkey = monkeyList.get(i);
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
                    monkey.getInServiceLocation().equalsIgnoreCase(country) &&
                    !monkey.getReserved()) {

                    monkey.setReserved(true);
                    System.out.println("Monkey " + monkey.getName() + " has been reserved.");
                    return;
                }
            }
            System.out.println("No available monkeys found in " + country + ".");
        }

        // Invalid type entered
        else {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
        }
    }

    // Print animals based on listType argument
    public static void printAnimals(String listType) {
        System.out.println("\n--- Animal List: " + listType.toUpperCase() + " ---");

        // Print all dogs
        if (listType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                System.out.printf("%-10s %-15s %-10s %-10s\n", dog.getName(), dog.getTrainingStatus(), dog.getAcquisitionLocation(), dog.getReserved());
            }
        }

        // Print all monkeys
        else if (listType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                System.out.printf("%-10s %-15s %-10s %-10s\n", monkey.getName(), monkey.getTrainingStatus(), monkey.getAcquisitionLocation(), monkey.getReserved());
            }
        }

        /*  Print animals that are "in service" and not reserved */
        else if (listType.equalsIgnoreCase("available")) {
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.printf("Dog: %-10s %-15s %-10s %-10s\n", dog.getName(), dog.getTrainingStatus(), dog.getAcquisitionLocation(), dog.getReserved());
                }
            }
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.printf("Monkey: %-10s %-15s %-10s %-10s\n", monkey.getName(), monkey.getTrainingStatus(), monkey.getAcquisitionLocation(), monkey.getReserved());
                }
            }
        }

        // Invalid input for list type
        else {
            System.out.println("Invalid list type.");
        }
    }
}
