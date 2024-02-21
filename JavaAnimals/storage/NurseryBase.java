package JavaAnimals.storage;

import JavaAnimals.model.AbstractAnimal;
import JavaAnimals.model.AbstractPackAnimal;
import JavaAnimals.model.AbstractPet;
import JavaAnimals.model.implement.*;
import JavaAnimals.model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NurseryBase implements Base {
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public NurseryBase() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Гизма", LocalDate.of(2019, 1, 11));

        cat.learnSkill(new Skill("Ловить мышей"));
        cat.learnSkill(new Skill("Мурлыкать"));
        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Шаня", LocalDate.of(2016, 3, 14));
        dog.learnSkill(new Skill("Поймать фрисби"));
        dog.learnSkill(new Skill("Лежать"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Мелкий", LocalDate.of(2024, 1, 1));
        hamster.learnSkill(new Skill("Сделать норку"));
        hamster.learnSkill(new Skill("Спать"));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Айвенго", LocalDate.of(2021, 2, 4));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Skill("Бег"));
        horse.learnSkill(new Skill("Прыжок"));
        dbAnimals.put(horse.getId(), horse);

        AbstractPackAnimal horse2 = new Horse("Ванда", LocalDate.of(2022, 12, 1));
        horse2.setLoadCapacity(400);
        horse2.learnSkill(new Skill("Кусать"));
        horse2.learnSkill(new Skill("Прыгать"));
        dbAnimals.put(horse2.getId(), horse2);

        AbstractPackAnimal donkey = new Donkey("Иа", LocalDate.of(2018, 8, 24));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Skill("Идти быстро"));
        donkey.learnSkill(new Skill("Идти медленно"));
        donkey.learnSkill(new Skill("Упрямиться"));
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Боря", LocalDate.of(2023, 5, 20));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Skill("Плюнуть"));
        camel.learnSkill(new Skill("Присесть"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        return new ArrayList<>(dbAnimals.values());
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}