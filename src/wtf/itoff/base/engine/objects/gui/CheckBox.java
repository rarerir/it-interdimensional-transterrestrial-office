package wtf.itoff.base.engine.objects.gui;

import wtf.itoff.base.engine.interactions.Interactable;
import wtf.itoff.base.engine.value.Value;

import java.awt.geom.Point2D;
import java.lang.reflect.Field;

public class CheckBox extends Interactable {

    private Field attachedField;
    private Value<Boolean> attachedValue;
    private Object fieldHolder;

    public CheckBox(Point2D pos, String name, Object fieldHolder, Field targetField) {
        super(pos, name);
        if (targetField.getType() == Boolean.class && targetField.canAccess(fieldHolder)) {
            this.attachedField = targetField;
            this.fieldHolder = fieldHolder;
            this.onClick = inter -> {
                try {
                    boolean prevValue = this.attachedField.getBoolean(this.fieldHolder);
                    this.attachedField.setBoolean(fieldHolder, !prevValue);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        } else {
            throw new RuntimeException("Failed to create CheckBox!");
        }
    }

    public CheckBox(Point2D pos, String name, Value<Boolean> targetValue) {
        super(pos, name);
        this.attachedField = null;
        this.fieldHolder = null;
        this.attachedValue = targetValue;
        this.onClick = inter -> {
            attachedValue.setValue(!attachedValue.getValue());
        };

    }

    @Override
    public void update() {

    }
}
