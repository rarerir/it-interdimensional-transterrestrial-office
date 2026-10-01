package wtf.itoff.base.engine.interactions;

public class Interaction {
    private Interactable obj1, obj2;
    private InteractionType type;

    Interaction(Interactable obj1, Interactable obj2, InteractionType type) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.type = type;
    }

    public Interactable getObj1() {
        return obj1;
    }

    public Interactable getObj2() {
        return obj2;
    }

    public InteractionType getType() {
        return type;
    }
}
