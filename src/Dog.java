public class Dog extends Animal {       //Java created an implicit constructor since one wasn't specified (before we
                                        //added public Dog).

    private String earShape;   //These are our dog
    private String tailShape;  //specific fields.

    public Dog(){
        super("Mutt", "Big", 50);     //"super" is very similar to the "this" statement, in that it calls on the parent
    }                                                  //constructor (Or super class constructor).
                                                       //We added a default (No args) constructor to Animal in order to use this super().

    //Using six lines of code, including the opening and closing braces and white space, this code can now execute 3
    //methods and has 3 attributes we can set, all inherited from Animal.
    //Better yet, we can treat this Dog like any Animal, for any code that uses the Animal class.
    //Our doAnimalStuff method in the main class didn't have to change at all, even though we introduced a new class.


    public Dog(String type, double weight){                     //We are using constructor chaining here to call the other
        this(type, weight, "Perky", "Curled");//constructor with 4 parameters, which in turn calls the
    }                                                           //Animal constructor.

    public Dog(String type, double weight, String earShape, String tailShape) {    //If auto-generating the constructor,
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"),    //we now have an additional choice, which
                weight);                                                           //is which parent constructor we should use.
        this.earShape = earShape;
        this.tailShape = tailShape; //We have now created a constructor for Dog attributes.

        //This constructor has a combination of the Dog and Animal fields in its argument list.
        //We can pass it the type of the dog, the dog's weight, and the ear shape and tail shape.
        //We're calling the super constructor to set some of our fields, the Animal specific fields.
        //And we're using a nested ternary operator to derive the size of the dog from the weight: small, medium, or large.
        //We couldn't do this operation before the call to super(), since super needs to be the first statement, so instead
        //we use the expression in the argument list.
        //After the call to the super constructor, we set some of the Dog-specific attributes: the ear shape and tail shape.

    }

    //toString method created for the Dog class:
    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();

        //super.toString() call is different than the super(type, weight, etc). It's a lot like using the this keyword
        //with dot notation, to access a field on the current instance. This code lets us call a super class's method.

    }

    //By creating this makeNoise method, we've overridden Animals makeNoise method.
    //Overriding a method is when you create a method on a subclass, which has the same signature as a method on a super class.
    //You override a parent class method, when you want the child class to show different behavior for that method.
    public void makeNoise(){        //Since we want Dog to have different behavior than Animal, we can change that here
                                    //based on what we "mute" in this method override.
        if(type == "Wolf"){
            System.out.print("Ow Woooooooooo!");
        }
        bark();
        System.out.println();
    }

    //Created the override method below using Intellij's code generation.
    //There are some key differences between the code we manually created (makeNoise) and what Intellij created for us below.
    //Inteillij's generation tool adds the @Override symbol to remind us that we're overriding a method that's in the
    //superclass. In this case, it's in the Animal class.
    //The automatically generated code also makes a call to the parent class's method, move, using the keyword super.move.
    //What that means is we're calling the move method on the parent class, the Animal class.
    //This code kind of does the same thing as not having that overridden method at all.
    //It simply executes the Animal class's move method, which would have happened if we didn't create this method at all.
    //Why do this? Most likely it's because we want to change or extend our code here.
    //We changed the makeNoise method by having a method with no code at all.
    //This changed the behavior of makeNoise for all Dog objects. It made all our dogs silent for the moment.
    //We will add more code to the overridden move method to extend the method's function by adding print statements.
    @Override
    public void move(String speed) {
        super.move(speed);
        //System.out.println("Dogs walk, run and wag their tail"); (Commented to add methods below)

        if(speed == "slow"){
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
        System.out.println();
    }

    //Here we create a private method to add behavior to Dog. It is private since only the move method above will need it.
    private void bark(){
        System.out.print("Woof! ");
    }

    private void run(){
        System.out.print("Dog Running ");
    }

    private void walk(){
        System.out.print("Dog Walking ");
    }

    private void wagTail(){
        System.out.print("Tail wagging ");
    }
}

//Using "extends" specifies the superclass (Or the parent class) of the class we're declaring.

//We can say Dog is a subclass, or child class, of Animal.

//We can say Animal is a parent, or super class, of Dog.

//A class can specify one, and only one, class in its extends clause.

//"super" is a way to call a constructor on the super class, directly from the sub class's constructor.

//Like the "this" statement, it has to be the first statement of the constructor.

//Because of that rule, this() and super() can never be called from the same constructor.

//If you don't make a call to super(), then Java makes it for you, using the super's default constructor.

//If your super class doesn't have a default constructor, then you must explicitly call super() in all your constructors,
//passing the right arguments to that constructor.

//The overridden method can do one of three things:

//It can implement completely different behavior, overriding the behavior of the parent.
//It can simply call the parent class's method, which is somewhat redundant to do.
//Or the method can call the parent class's method, and include other code to run, so it can extend the functionality
//for the Dog, for that behavior.