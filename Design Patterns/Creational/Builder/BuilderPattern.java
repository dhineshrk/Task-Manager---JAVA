// Product: Computer
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // Constructor with all parameters
    public Computer(String CPU, String RAM, String storage, String GPU) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.GPU = GPU;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + "]";
    }
}

// Builder: ComputerBuilder
class ComputerBuilder {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // Setters for each component
    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder setRAM(String RAM) {
        this.RAM = RAM;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGPU(String GPU) {
        this.GPU = GPU;
        return this;
    }

    // Build method to return the final object
    public Computer build() {
        return new Computer(CPU, RAM, storage, GPU);
    }
}

// Director: ComputerDirector (optional)
class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Construct different types of computers using the builder
    public Computer buildGamingPC() {
        return builder.setCPU("Intel i9")
                      .setRAM("32GB")
                      .setStorage("1TB SSD")
                      .setGPU("NVIDIA RTX 3080")
                      .build();
    }

    public Computer buildOfficePC() {
        return builder.setCPU("Intel i5")
                      .setRAM("16GB")
                      .setStorage("512GB SSD")
                      .setGPU("Integrated Graphics")
                      .build();
    }
}

// Client code
public class BuilderPattern {
    public static void main(String[] args) {
        // Create a builder instance
        ComputerBuilder builder = new ComputerBuilder();
        
        // Create a Director to manage the construction of different types of computers
        ComputerDirector director = new ComputerDirector(builder);

        // Build a gaming PC
        Computer gamingPC = director.buildGamingPC();
        System.out.println("Gaming PC: " + gamingPC);

        // Build an office PC
        Computer officePC = director.buildOfficePC();
        System.out.println("Office PC: " + officePC);
    }
}
