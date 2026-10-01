package wtf.itoff.base.engine.interactions;

import wtf.itoff.base.engine.Scene;

import java.awt.geom.Point2D;
import java.util.function.Consumer;

public abstract class Interactable {

    public Scene parentScene;
    public Point2D pos;
    public String name;
    private InteractionZone interZone;
    protected Consumer<Interaction> onCollision;
    protected Consumer<Interaction> onClick;
    protected Consumer<Interaction> onHover;
    protected Consumer<Interaction> onHold;
    protected Consumer<Interaction> onLeave;
    protected Consumer<Interaction> onTrigger;

    public Interactable(Point2D pos,
                        String name,
                        Consumer<Interaction> onCollision,
                        Consumer<Interaction> onClick,
                        Consumer<Interaction> onHover,
                        Consumer<Interaction> onHold,
                        Consumer<Interaction> onLeave,
                        Consumer<Interaction> onTrigger
    ) {
        this.pos = pos;
        this.name = name;
        this.parentScene = null;
        this.onCollision = onCollision;
        this.onClick = onClick;
        this.onHover = onHover;
        this.onHold = onHold;
        this.onTrigger = onTrigger;
        this.onLeave = onLeave;
    }

    public Interactable(Point2D pos, String name) {
        this.pos = pos;
        this.name = name;
        this.parentScene = null;
        this.onCollision = null;
        this.onClick = null;
        this.onHover = null;
        this.onHold = null;
        this.onTrigger = null;
        this.onLeave = null;
    }

    public void onInteraction(Interaction inter) {
        switch (inter.getType()) {
            case COLLISION:
                if (this.onCollision != null) {
                    this.onCollision.accept(inter);
                }
                break;
            case HOVER:
                if (this.onHover != null) {
                    this.onHover.accept(inter);
                }
                break;
            case CLICK:
                if (this.onClick != null) {
                    this.onClick.accept(inter);
                }
                break;
            case LEAVE:
                if (this.onLeave != null) {
                    this.onLeave.accept(inter);
                }
                break;
            case TRIGGER:
                if (this.onTrigger != null) {
                    this.onTrigger.accept(inter);
                }
                break;
        }
    }

    public abstract void update();

}
