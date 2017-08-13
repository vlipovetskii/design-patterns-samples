package sourcemaking;

interface ListVisitor {
    Object whenNonNullList(NonNullList host, Object param);
    Object whenNullList(NullList host, Object param);
}

abstract class List {
    public abstract List getTail();
    public abstract Object accept(ListVisitor visitor, Object param);
}

class NonNullList extends List {
    private Object head;
    private List tail;

    // Creates a list from a head and tail. Acts as "cons"
    public NonNullList(Object head, List tail) {
        this.head = head;
        this.tail = tail;
    }
    // for convenience we could add a constructor taking only the head to make 1 element lists.
    public Object getHead() {
        return head;
    }

    public List getTail() {
        return tail;
    }

    public Object accept(ListVisitor visitor, Object param) {
        return visitor.whenNonNullList(this, param);
    }
}

class NullList extends List {
    private static final NullList instance = new NullList();

    private NullList() {}

    public static NullList singleton() {
        return instance;
    }

    public List getTail() {
        return this;
    }

    public Object accept(ListVisitor visitor, Object param) {
        return visitor.whenNullList(this, param);
    }
}

public class NullListDemo {
}
