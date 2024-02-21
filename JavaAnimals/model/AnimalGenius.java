package JavaAnimals.model;


public enum AnimalGenius {
    DOG ("Собака"),
    CAT ("Кошка"),
    HAMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private final String title;
    AnimalGenius(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
