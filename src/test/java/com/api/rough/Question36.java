package com.api.rough;

//Trick - Compiler changes Dog(String) constructor to: Dog(String breed) { super(); this.breed = breed; }.
//No-arg constructor is not available in Animal class and as another constructor is provided,
//java compiler doesn't add default constructor. Hence Dog(String) constructor gives compilation error.
abstract class Animal {
    private String name;

    Animal(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    private String breed;
    
    Dog(String breed) {
        this.breed = breed;
    }

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}

public class Question36 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Beagle");
        Dog dog2 = new Dog("Bubbly", "Poodle");
        System.out.println(dog1.getName() + ":" + dog1.getBreed() + ":" + 
                            dog2.getName() + ":" + dog2.getBreed());
    }
}