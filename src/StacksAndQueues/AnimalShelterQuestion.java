package StacksAndQueues;

import java.util.LinkedList;

// An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create a data structures to maintain this system and implement operations such as
// enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the built-in LinkedList.
public class AnimalShelterQuestion {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Animal a1 = new Animal("dog", 2); shelter.enqueue(a1);
        Animal a2 = new Animal("cat", 3); shelter.enqueue(a2);
        Animal a3 = new Animal("dog", 1); shelter.enqueue(a3);
        Animal a4 = new Animal("dog", 5); shelter.enqueue(a4);
        shelter.print();

        Animal dqAny = shelter.dequeueAny();
        System.out.println("Dequeue Any: " + dqAny.type + " index: " + dqAny.arrivedIndex);
        shelter.print();
        Animal dqDog = shelter.dequeueDog();
        System.out.println("Dequeue Dog: " + dqDog.type + " index: " + dqDog.arrivedIndex);
        shelter.print();
        Animal dqCat = shelter.dequeueCat();
        System.out.println("Dequeue Cat: " + dqCat.type + " index: " + dqCat.arrivedIndex);
        shelter.print();
    }
}

class AnimalShelter {
    LinkedList<Animal> animalList = new LinkedList<>();
    public void enqueue(Animal animal) {
        // insert first animal
        if(animalList.isEmpty()) {
            animalList.add(animal);
            return;
        }
        // insert animal if it comes before the first animal in the list
        Animal first = animalList.getFirst();
        if(animal.arrivedIndex < first.arrivedIndex) {
            animalList.add(0, animal);
            return;
        }
        // insert animal if it comes after the last animal in the list
        Animal last = animalList.getLast();
        if(animal.arrivedIndex > last.arrivedIndex) {
            animalList.add(animalList.size(), animal);
            return;
        }
        // insert the animal in the middle of the list based on its arrived index
        for(int i=1; i<animalList.size(); i++) {
            Animal temp = animalList.get(i);
            if(animal.arrivedIndex > animalList.get(i-1).arrivedIndex && animal.arrivedIndex < temp.arrivedIndex){
                animalList.add(i, animal);
            }
        }
    }
    public Animal dequeueAny() {
        return animalList.pop();
    }
    public Animal dequeueDog() {
        for(int in = 0; in < animalList.size(); in++) {
            Animal temp = animalList.get(in);
            if(temp.type.equalsIgnoreCase("dog")) {
                return animalList.remove(in);
            }
        }
        return null;
    }
    public Animal dequeueCat() {
        for(int in = 0; in < animalList.size(); in++) {
            Animal temp = animalList.get(in);
            if(temp.type.equalsIgnoreCase("cat")) {
                return animalList.remove(in);
            }
        }
        return null;
    }
    public void print() {
        System.out.println(animalList);
    }
}

class Animal {
    String type;
    int arrivedIndex;

    public Animal(String type, int arrived) {
        this.type = type;
        this.arrivedIndex = arrived;
    }

    public String toString() {
        return "Type: " + this.type + " Arrived Index: " + this.arrivedIndex;
    }
}
