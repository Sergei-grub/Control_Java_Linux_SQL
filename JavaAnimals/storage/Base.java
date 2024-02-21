package JavaAnimals.storage;

import JavaAnimals.model.AbstractAnimal;

import java.util.List;

public interface Base {

    List<AbstractAnimal> getAllAnimals();


    AbstractAnimal getAnimalById(int animalId);


    boolean addAnimal(AbstractAnimal animal);


    int removeAnimal(AbstractAnimal animal);
}
