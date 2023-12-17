public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(animal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");    //We're passing a dog object as the method argument, when the type was declared Animal.
                                             //This works because Dog inherits from Animal. This is important in this type of code.
                                             //We can pass a dog instance to any method that takes an animal.

        //Fields can be accessed directly on a subclass if they have a public or protected access modifier.
        //Java first looks on the subclass, for a method or a field with that name, then go up the inheritance tree looking
        //for a match. We can test this by creating the wolf object below.

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");

        //We used Animal's fields and behaviors, the ones we wanted to use, then added some more specific elements ot the Fish class.
        //We then passed Fish to a method, that never had to know a Fish class existed. This concept is known as polymorphism.
        //Polymorphism simply means "many forms". In these lessons, we have seen that Animal can take multiple forms, the base
        //class Animal, or a Dog, or a Fish.
        //As demonstrated, some advantages of polymorphism are:
        //Making code simpler and encouraging code extensibility.
        Fish goldie = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        Dog retriever = new Dog ("Labrador retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        //Up to now, we called methods on Animal, and were able to access the functionality that's part and parcel of the
        //Animal class, and we're able to use methods on, and through Dog, that were defined on Animal.
        //And even more importantly, we're doing this from a method, that really doesn't even know anything about the Dog class.
        //Dog can use methods on Animal, and print out its own object's values, in this case, both the move and makeNoise
        //methods printed the type field. This is how inheritance promotes code re-use.

        //All subclasses can execute methods, even though the code is declared on the parent class.
        //The code doesn't have to be duplicated in each subclass.
        //We can use code from the parent, or we can change that code for the subclass(We did this with the toString method).

        //The toString method that was called in the doAnimalStuff method (System.out.println(animal)), of the Main class,
        //didn't actually call the toString method.
        //It called the Dog toString method, when animal is an instance of a Dog.
        //We told the method doAnimalStuff that we were dealing with an Animal class, and we called the toString method,
        //which is declared as a method on Animal. At run time, Java figures out the Animal object is even more specific
        //than Animal, it's really a Dog, and it actually calls the toString method on Dog(if one exists on Dog).
        //If the toString method doesn't exist on Dog, then Java just uses the toString method on Animal.
}
    public static void doAnimalStuff(Animal animal, String speed){

        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }
}

//What is inheritance, and why is it so powerful?

//We can look at inheritance as a form of code re-use.

//It's a way to organise classes into a parent-child hierarchy, which lets the child inherit (Re-use) fields and methods
//from its parent.

//An analogy for inheritance would be that of the animal kingdom.

//The most generic class, or base class, starts at the top of the hierarchy, and every class below it is a subclass.

//So Animal is the base clas, and all other classes can be said to be subclasses of Animal.

//A parent can have multiple children, as we see with Mammal, which is the parent of Dog and Cat.

//A child can only have one direct parent in Java, but will inherit from its parent class's parent, and so on.
