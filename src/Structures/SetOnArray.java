package Structures;

public class SetOnArray extends Set {
    private final Pair elements[];
    private int indexer = -1;
    private final int size;

    public SetOnArray(int size) {
        this.size = size;
        this.elements = new Pair[size];
    }

    @Override
    public Pair search(String key) throws Exception {
        for(int i = 0; i <= indexer; i++)
        {
            if(elements[i].key == key)
                return elements[i];
        }
        throw new Exception("Element not found");
    }

    @Override
    public void push(Pair p) throws Exception {
        if(indexer > size - 2)
            throw new Exception("Set is full");
        try
        {
            search(p.key);
        }
        catch(Exception e)
        {
            indexer++;
            elements[indexer] = p;
            return;
        }
        throw new Exception("Element with key " + p.key + " already exists in the set");
    }

    @Override
    public double read(String key) throws Exception {
        return search(key).getValue();
    }

    @Override
    public void set(Pair p) throws Exception {
        for(int i = 0; i <= indexer; i++)
        {
            if(elements[i].key == p.key)
            {
                elements[i].setValue(p.getValue());
                return;
            }
        }
        if(indexer < size - 1)
        {
            indexer++;
            elements[indexer] = p;
            return;
        }
        throw new Exception("Set is full");
    }

    @Override
    public void purge() {
        indexer = -1;
        return;
    }

    @Override
    public int count() {
        return indexer + 1;
    }
}
