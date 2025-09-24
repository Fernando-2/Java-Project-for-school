public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
    String trainingStatus, boolean reserved, String inServiceCountry) {
        super(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, inServiceCountry, reserved, inServiceCountry);
        setBreed(breed);
        setAnimalType("dog"); // This line ensures animalType is set.
    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

    public String getInServiceLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInServiceLocation'");
    }

   

}
