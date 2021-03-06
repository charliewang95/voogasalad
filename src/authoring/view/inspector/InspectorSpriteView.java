package authoring.view.inspector;

import authoring.AuthoringController;
import authoring.view.canvas.SpriteView;
import authoring.view.inspector.settings.*;
import game_object.block.IBlock;
import game_object.character.Hero;
import game_object.constants.DefaultConstants;
import game_object.core.ISprite;
import game_object.level.Level;
import goal.position.ReachPointGoal;

import static resources.ResourceBundles.componentProperties;

public class InspectorSpriteView extends AbstractInspectorTabView {
    private SpriteView spriteView;
    private ISprite sprite;

    private ComponentPhysicsSettings componentPhysicsSettings;
    private TextInputBoxView myXBox, myYBox, myZBox, myWidthBox, myHeightBox;
    private CheckBoxView myHerosCollisionCheckBox, myEnemiesCollisionCheckBox, myBlockCollisionCheckBox,
            myApplyPhysicsCheckBox, myReachPointCheckBox;
    private SliderBoxView myMaxJumpSlider, myJumpUnitSlider;
    private ActionConfiguringView myActionView;
    private LivesConfiguringView myLivesConfiguringView;

    public InspectorSpriteView(AuthoringController controller) {
        super(controller);
    }

    @Override
    protected void initUI() {
        super.initUI();
        addSettingsView(new NullSettingsView(getController()));
    }

    private void updateUI() {
        clearSettingsView();
        if (spriteView == null || (sprite = spriteView.getSprite()) == null) {
            addSettingsView(new NullSettingsView(getController()));
            return;
        }

        myXBox = new TextInputBoxView(getController(), "Position X", sprite.getPosition().getX() + "",
                (newVal) -> spriteView.setAbsolutePositionX(Double.parseDouble(newVal)));
        myYBox = new TextInputBoxView(getController(), "Position Y", sprite.getPosition().getY() + "",
                (newVal) -> spriteView.setAbsolutePositionY(Double.parseDouble(newVal)));
        myZBox = new TextInputBoxView(getController(), "Position Z", sprite.getPosition().getZ() + "",
                (newVal) -> spriteView.setAbsolutePositionZ(Double.parseDouble(newVal)));
        myWidthBox = new TextInputBoxView(getController(), "Width", sprite.getDimension().getWidth() + "",
                (newVal) -> spriteView.setDimensionWidth(Double.parseDouble(newVal)));
        myHeightBox = new TextInputBoxView(getController(), "Height", sprite.getDimension().getHeight() + "",
                (newVal) -> spriteView.setDimensionHeight(Double.parseDouble(newVal)));


        componentPhysicsSettings = new ComponentPhysicsSettings(sprite);
        myHerosCollisionCheckBox = new CheckBoxView(getController(), "Collide with Heros",
                (sprite.getCollisionBitMask() & DefaultConstants.HERO_CATEGORY_BIT_MASK) != 0,
                (obv, old_val, new_val) -> componentPhysicsSettings.setCollisionSettingWithHeros(new_val));
        myEnemiesCollisionCheckBox = new CheckBoxView(getController(), "Collide with Enemies",
                (sprite.getCollisionBitMask() & DefaultConstants.ENEMY_CATEGORY_BIT_MASK) != 0,
                (obv, old_val, new_val) -> componentPhysicsSettings.setCollisionSettingWithEnemies(new_val));
        myBlockCollisionCheckBox = new CheckBoxView(getController(), "Collide with Blocks",
                (sprite.getCollisionBitMask() & DefaultConstants.BLOCK_CATEGORY_BIT_MASK) != 0,
                (obv, old_val, new_val) -> componentPhysicsSettings.setCollisionSettingWithBlock(new_val));
        myApplyPhysicsCheckBox = new CheckBoxView(getController(), "Apply Physics",
                sprite.getAffectedByPhysics(),
                (obv, old_val, new_val) -> componentPhysicsSettings.makePhysicsApplicable(new_val));

        addSettingsViews(myXBox, myYBox, myZBox, myWidthBox, myHeightBox, myHerosCollisionCheckBox, myEnemiesCollisionCheckBox, myBlockCollisionCheckBox,
                myApplyPhysicsCheckBox);

        if (sprite instanceof IBlock) {
            myReachPointCheckBox = new CheckBoxView(getController(), "Assign sprite as goal point of level", false,
                    (obv, oldVal, newVal) -> {
                        Level currentLevel = getController().getEnvironment().getCurrentLevel();
                        currentLevel.getHeros().forEach(hero -> {
                            ReachPointGoal reachGoal = new ReachPointGoal(hero, sprite);
                            currentLevel.getAllGoals().add(reachGoal);
                        });
                    });
            addSettingsView(myReachPointCheckBox);
        }

        if (sprite instanceof Hero) {
            myActionView = new ActionConfiguringView(getController(), sprite);
            myMaxJumpSlider = new SliderBoxView(
                    getController(),
                    "Number of Jumps",
                    Double.parseDouble(componentProperties.getString("MIN_NUMBER_JUMPS")),
                    Double.parseDouble(componentProperties.getString("MAX_NUMBER_JUMPS")),
                    ((Hero) sprite).getMaxNumberOfJumps(),
                    Double.parseDouble(componentProperties.getString("JUMP_INCREMENT")),
                    (obv, oldVal, newVal) -> ((Hero) sprite).setMaxNumberOfJumps(newVal.intValue()));
            myJumpUnitSlider = new SliderBoxView(
                    getController(),
                    "Jump Unit",
                    Double.parseDouble(componentProperties.getString("MIN_JUMP_UNIT")),
                    Double.parseDouble(componentProperties.getString("MAX_JUMP_UNIT")),
                    ((Hero) sprite).getJumpingUnit(),
                    Double.parseDouble(componentProperties.getString("JUMP_UNIT_INCREMENT")),
                    (obv, oldVal, newVal) -> ((Hero) sprite).setJumpingUnit(newVal.doubleValue()));
            myLivesConfiguringView = new LivesConfiguringView(getController(), (Hero) sprite);
            addSettingsViews(myActionView, myMaxJumpSlider, myJumpUnitSlider, myLivesConfiguringView);
        }
        updateLayout();
    }

    public void setSpriteView(SpriteView spView) {
        spriteView = spView;
        updateUI();
    }
}