package authoring.view.inspector;

import game_object.acting.ActionName;
import game_object.core.ISprite;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionTypeKeyInput {
	
	private ActionName actionName;
	static String actionNameString;
	private KeyEvent keyEvent;
	private KeyCode keyInput;
	private ISprite sprite;
	
	/**
	 * constructor when key input has been given
	 * @param actionNameToSet
	 * @param key
	 */
	public ActionTypeKeyInput(ActionName actionNameToSet, KeyCode key, ISprite spriteToSet) {
		this.actionName = actionNameToSet;
		this.keyInput = key;
		this.sprite = spriteToSet;
		
		this.actionNameString = actionNameToSet.toString();
		
		setActionTrigger();
	}
	
	/**
	 * constructor for when no key input has been set
	 * @param actionNameToSet
	 */
	public ActionTypeKeyInput(ActionName actionNameToSet) {
		this.actionName = actionNameToSet;
		this.actionNameString = actionNameToSet.toString();
		this.keyInput = null;
	}
	
	private void setActionTrigger() {
		//
	}
}

