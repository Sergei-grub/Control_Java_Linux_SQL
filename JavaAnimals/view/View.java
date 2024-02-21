package JavaAnimals.view;

import JavaAnimals.model.AbstractAnimal;

public interface View {

    enum MainMenuCommand {
        ADD_ANIMAL ("Добавить животное"),
        SHOW_SKILLS("Показать умения животного"),
        REMOVE_ANIMAL ("Удалить животное"),
        EXIT ("Выйти");

        private final String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    enum AddSkillMenuCommand {
        ADD_SKILL ("Обучить команде"),
        EXIT ("Выйти");

        private final String tag;

        AddSkillMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }


    void showNurseryRegistry();


    MainMenuCommand showMainMenuWithResult();


    boolean showAddAnimalDialog();


    int showRemoveAnimalDialog();


    void showDetailInfoAnimalDialog();


    void showAnimalInfo(AbstractAnimal animal);

    AddSkillMenuCommand showAddSkillMenu(AbstractAnimal animal);

    boolean showAddSkillDialog(AbstractAnimal animal);
}
