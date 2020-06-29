package question2;

import java.util.List;

public class Memento {
    private List list;

    public Memento(List list) {
        this.list = list;
    }

    public List getList() {
        return this.list;
    }
}

