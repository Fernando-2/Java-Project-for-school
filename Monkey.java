 public class Monkey extends RescueAnimal {
    // Monkey-specific attributes
    private String species;
    private int tailLength;
    private int height;
    private int bodyLength;
    // Full constructor
    public Monkey(String name, String species, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceLocation,
                  int tailLength, int height, int bodyLength) {
        super(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceLocation);
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        setName(name);
        this.species = species;
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
    }

    
    // Accessors and mutators
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    public int getTailLength() { return tailLength; }
    public void setTailLength(int tailLength) { this.tailLength = tailLength; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getBodyLength() { return bodyLength; }
    public void setBodyLength(int bodyLength) { this.bodyLength = bodyLength; }

    public String getInServiceLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInServiceLocation'");
    }
}

