package JavaAnimals.model.implement;

import JavaAnimals.model.AbstractPackAnimal;
import JavaAnimals.model.AnimalGenius;

import java.time.LocalDate;

public class Camel extends AbstractPackAnimal {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.CAMEL);
    }
}