package uff.ic.lleme.view;

public interface Element {

    public abstract void accept(Visitor visitor);
}
