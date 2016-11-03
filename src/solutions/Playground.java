package solutions;

/**
 * Created by James on 10/19/16.
 */
public class Playground {
    public static class Animal{

    }

    public static class Mammal extends Animal{
    }

    public static class Dog extends Mammal{
    }

    public static void main(String args[]){

        Animal a = new Animal();
        Mammal m = new Mammal();
        Dog d = new Dog();

        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal);
    }
}
