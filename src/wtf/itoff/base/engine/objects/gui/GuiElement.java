package wtf.itoff.base.engine.objects.gui;

import wtf.itoff.base.engine.interactions.Interactable;
import wtf.itoff.base.engine.interactions.Interaction;

import java.awt.geom.Point2D;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class GuiElement extends Interactable {

    public GuiElement(Point2D pos, String name, Consumer<Interaction> onClick, Consumer<Interaction>  onHover, Consumer<Interaction> onHold, Consumer<Interaction> onLeave) {
        super(pos, name, null, onClick, onHover, onHold, onLeave, null);
    }

    public GuiElement(Point2D pos, String name) {
        super(pos, name);
    }

    @Override
    public void update() {

    }
}
