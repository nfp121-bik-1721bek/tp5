package question2;
import java.util.Stack;

public class Gardien {
    private Stack<Memento> mementoStack;

    public Gardien() {
        mementoStack = new Stack();
    }

    public Stack<Memento> getMemento() {
        return mementoStack;
    }

    public Memento popMemento() {
        return mementoStack.pop();
    }

}
