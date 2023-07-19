import java.security.spec.RSAOtherPrimeInfo;

public class SampleAnimals {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animalDog = new Dog();
        Animal animalCat = new Cat();

        animal.makeSound();
        animalDog.makeSound();
        animalCat.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}