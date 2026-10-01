package wtf.itoff.base.engine.objects.game;

import wtf.itoff.base.engine.interactions.Interactable;
import wtf.itoff.base.engine.interactions.Interaction;
import wtf.itoff.base.engine.value.Value;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.function.Consumer;

public class GameObject extends Interactable {

    public Point2D tilePos;
    public ArrayList<Value<?>> properties;

    public GameObject(Point2D pos,
                      String name,
                      Consumer<Interaction> onCollision,
                      Consumer<Interaction> onClick,
                      Consumer<Interaction> onHover,
                      Consumer<Interaction> onHold,
                      Consumer<Interaction> onLeave,
                      Consumer<Interaction> onTrigger
    ) {
        super(pos, name, onCollision, onClick, onHover, onHold, onLeave, onTrigger);
    }

    @Override
    public void update() {

    }
}
