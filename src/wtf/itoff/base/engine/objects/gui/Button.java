package wtf.itoff.base.engine.objects.gui;

import wtf.itoff.base.engine.interactions.Interactable;
import wtf.itoff.base.engine.interactions.Interaction;

import java.awt.geom.Point2D;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Button extends GuiElement {

    @Override
    public void update() {

    }

    public Button(Point2D pos, String name) {
        super(pos, name);
    }
}
