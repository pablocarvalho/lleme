package patterns.command.framework;

public abstract class Command implements Cloneable {

    public abstract void execute();

    public abstract void desfazer();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
