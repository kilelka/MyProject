package components;

public abstract class LoadablePage<T> {

    protected LoadablePage() {
        checkLoad();
    }

    protected abstract void checkLoad();
}
