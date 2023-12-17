public class Animal {

    protected String type;        //using the protected modifier on this field will allow the subclass Dog to use it.
                                  //Protected conditionally will allow only subclasses to access this field.
                                  //It will also allow any classes in the same package to access the field.
    private String size;
    private double weight;

    public Animal(){

    }

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed){
        System.out.println(type + " moves " + speed);
    }

    public void makeNoise(){
        System.out.println(type + " makes some kind of noise");
    }
}
