package JavaAnimals;

import JavaAnimals.controller.NurseryAccounting;
import JavaAnimals.storage.NurseryBase;
import JavaAnimals.view.ConsoleView;
import JavaAnimals.view.View;

public class App {

    public static void run() {
        NurseryAccounting nurseryAccounting = new NurseryAccounting(new NurseryBase());
        View view = new ConsoleView(nurseryAccounting);

        while (true) {
            view.showNurseryRegistry();
            View.MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    System.out.println("--------------------");
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> view.showDetailInfoAnimalDialog();
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1  ? "Удалено животное № " + removeId : "Не удалось удалить животное";
                    System.out.println(resMessage);
                }
                case EXIT -> {
                    System.out.println("До новый встреч!");
                    return;
                }
            }
        }
    }
}
