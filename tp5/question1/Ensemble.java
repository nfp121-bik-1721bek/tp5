package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        if (table == null)
            return 0;
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {

        if (table.contains(t)) {
            return false;
        }
        if (table == null) {
            table = new Vector<T>();
            table.add(t);
            return true;
        } else {
            table.add(t);
            return true;
        }
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        if (e.size() == 0 && this.table.size() == 0) {
            return null;
        }
        if (e.size() == 0 && this.table.size() != 0) {
            return table;
        }
        if (e.size() != 0 && this.table.size() == 0) {
            return e;
        } else {
            Ensemble<T> unionTable = new Ensemble<T>();
            unionTable.addAll(table);
            unionTable.addAll(e);
            return unionTable;

        }


    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        if (e.size() == 0 && this.table.size() == 0) {
            return null;
        }
        if (e.size() == 0 && this.table.size() != 0) {
            return null;
        }
        if (e.size() != 0 && this.table.size() == 0) {
            return null;
        } else {
            Ensemble<T> interTable = new Ensemble<T>();
            interTable.addAll(table);
            interTable.retainAll(e);
            return interTable;
        }
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        if (e.size() == 0 && this.table.size() == 0) {
            return null;
        }
        if (e.size() == 0 && this.table.size() != 0) {
            return null;
        }
        if (e.size() != 0 && this.table.size() == 0) {
            return null;
        } else {
            Ensemble<T> diff = new Ensemble<T>();
            interTable.addAll(table);
            diff.removeAll(e);
            return interTable;
        }
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble union = this.union(e);
        if (union == null) {
            return null;
        }
        Ensemble diffSym = this.union(e).diff(this.inter(e));
        return diffSym;
    }
}

}
