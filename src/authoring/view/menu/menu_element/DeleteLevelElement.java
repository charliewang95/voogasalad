package authoring.view.menu.menu_element;

import authoring.AuthoringController;
import authoring.view.menu.AbstractGameMenuElement;
import game_object.LevelGenerator;

/**
 * Delete current level.
 *
 * @author Will Long
 * @version 11/17/16
 */
public class DeleteLevelElement extends AbstractGameMenuElement {
    private static final String MENU_NAME = "Delete Level";

    private DeleteLevelElement(AuthoringController controller) {
        super(MENU_NAME, controller);
    }

    @Override
    protected void setFunctionality() {
        myMenuItem.setOnAction(event -> {
            myController.getEnvironment().deleteCurrentLevel();
            myController.getCanvasViewController().refresh();
        });
    }
}
