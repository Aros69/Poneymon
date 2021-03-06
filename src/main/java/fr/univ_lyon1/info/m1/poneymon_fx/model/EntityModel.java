package fr.univ_lyon1.info.m1.poneymon_fx.model;

import java.io.Serializable;

import fr.univ_lyon1.info.m1.poneymon_fx.collision.Collider;
import fr.univ_lyon1.info.m1.poneymon_fx.collision.Transform;
import fr.univ_lyon1.info.m1.poneymon_fx.collision.Trigger;

public class EntityModel implements Model, Serializable, Transform {

    // Abscissa of the entity
    protected double x;
    // Entity's row
    protected final int row;

    /**
     * generic Constructor for entities.
     */
    public EntityModel(int r) {
        x = 0.0;
        row = r;
    }

    /**
     * Add self to transform.
     */
    public void addSelfToTransforms() {
        FieldModel.COLLISIONMANAGER.addToTransforms(this);
    }

    /**
     * Sets the poney abscissa.
     *
     * @param newValue
     *            the new poney abscissa
     */
    public void setX(double newValue) {
        x = newValue;
    }

    public EntityModel(EntityModel clone) {
        x = clone.getX();
        row = clone.getRow();
    }

    public void assign(EntityModel other) {
        x = other.x;
    }

    /**
     * Gets the entity abscissa.
     *
     * @return the entity abscissa
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the poney row.
     *
     * @return the poney row
     */
    public int getRow() {
        return row;
    }

    @Override
    public void update(double msElapsed) {
        // TODO Auto-generated method stub

    }

    /**
     * Teste l'egalitée entre l'EntityModel courante et une autre EntityModel.
     * @param entityToTest EntityModel a tester
     * @return boolean
     */
    public boolean entityModelEquals(EntityModel entityToTest) {
        return ((this.getRow() == entityToTest.getRow())
                && (this.getX() == entityToTest.getX()));
    }

    @Override
    public void onCollision(Collider col) {
        
    }

    @Override
    public void onTrigger(Collider col,Trigger tr) {
    }
}
