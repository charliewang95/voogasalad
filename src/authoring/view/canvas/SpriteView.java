package authoring.view.canvas;

import authoring.AuthoringController;
import authoring.view.AbstractView;
import game_object.core.ISprite;
import game_object.core.Position;

/**
 * wrapper for Sprite in AuthEnv
 */
public class SpriteView extends AbstractView {
	
    private ISprite mySprite;
    private CanvasView myCanvas;
    private SpriteImageView mySpriteImageView;
    private SpriteResizeView mySpriteResizeView;
    private Position myMouseOffset;

    public SpriteView(AuthoringController controller) {
        super(controller);
    }

    public void setSprite(ISprite sprite) {
        mySprite = sprite;
        initUI();
    }

    public ISprite getSprite() {
        return mySprite;
    }

    public void setCanvasView(CanvasView canvas) {
        myCanvas = canvas;
    }

    public CanvasView getCanvasView() {
        return myCanvas;
    }

    public void setAbsolutePositionX(double x) {
        setPositionX(x);
        mySprite.getPosition().setX(x);
    }

    public void setAbsolutePositionY(double y) {
        setPositionY(y);
        mySprite.getPosition().setY(y);
    }

    public void setAbsolutePositionZ(double z) {
        mySprite.getPosition().setZ(z);
        getController().getCanvasController().reorderSpriteViewsWithPositionZ();
    }

    public Position getMouseOffset() {
        return myMouseOffset;
    }

    /**
     * @param width set width both frontend and backend mySprite
     */
    public void setDimensionWidth(double width) {
        setWidth(width);
        mySprite.getDimension().setWidth(width);
        updateLayout();
    }

    /**
     * @param height set height both frontend and backend mySprite
     */
    public void setDimensionHeight(double height) {
        setHeight(height);
        mySprite.getDimension().setHeight(height);
        updateLayout();
    }

    public void indicateSelection() {
        this.removeSubView(mySpriteResizeView);
        if (mySpriteResizeView != null) {
            removeUI(mySpriteResizeView.getUI());
        }
        mySpriteResizeView = new SpriteResizeView(this.getController());
        addUI(mySpriteResizeView.getUI());
        addSubView(mySpriteResizeView);
        updateLayout();
    }

    public void indicateDeselection() {
        this.removeSubView(mySpriteResizeView);
        if (mySpriteResizeView != null) {
            removeUI(mySpriteResizeView.getUI());
        }
    }

    @Override
    protected void initUI() {
        if (mySprite == null) return;

        mySpriteImageView = new SpriteImageView(this.getController());
        addUI(mySpriteImageView.getUI());
        addSubView(mySpriteImageView);
        this.setHeight(mySpriteImageView.getHeight());
        this.setWidth(mySpriteImageView.getWidth());

        setMouseClicked();
        mySpriteImageView.setDragMove();
        myMouseOffset = new Position(0, 0);
    }

    @Override
    protected void updateLayoutSelf() {
        mySpriteImageView.setWidth(getWidth());
        mySpriteImageView.setHeight(getHeight());
        if (mySpriteResizeView != null) {
            mySpriteResizeView.setWidth(getWidth());
            mySpriteResizeView.setHeight(getHeight());
        }
    }

    private void setMouseClicked() {
        getUI().setOnMouseClicked(e -> {
            getController().selectSpriteView(this);
            if (this.getController().getCanvasController().getSnapToGrid()) {
            	snapToGrid();
            }
        });
    }

    public void snapToGrid() {
        setAbsolutePositionX(getController().getCanvasController().convertToNearestBlockValue(getPositionX()));
        setAbsolutePositionY(getController().getCanvasController().convertToNearestBlockValue(getPositionY()));
        setDimensionWidth(getController().getCanvasController().convertToNearestBlockValue(getWidth()));
        setDimensionHeight(getController().getCanvasController().convertToNearestBlockValue(getHeight()));
    }
}
