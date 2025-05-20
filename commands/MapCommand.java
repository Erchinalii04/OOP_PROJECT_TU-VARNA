package commands;

import main.java.core.GameContext;
import main.java.entities.Hero;
import main.java.map.GameMap;

/**
 * Команда, която отпечатва текущата карта с позицията на героя.
 */
public class MapCommand implements Command {
    private final GameContext context;

    /**
     * Конструктор, който приема общия контекст на играта.
     *
     * @param context контекстът, съдържащ карта и герой
     */
    public MapCommand(GameContext context) {
        this.context = context;
    }

    /**
     * Изпълнява командата за визуализиране на картата.
     *
     * @param args не се използват
     */
    @Override
    public void execute(String[] args) {
        GameMap map = context.getMap();
        Hero hero = context.getHero();

        if (map == null || hero == null) {
            System.out.println("No map or hero loaded.");
            return;
        }

        map.printWithHero(hero.getX(), hero.getY());
    }
}
