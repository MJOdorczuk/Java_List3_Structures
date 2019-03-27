package Structures;

public class SetOnDynamicArray extends Set {
    private Pair elements[] = new Pair[2];
    private int indexer = -1;
    private int size = 2;
    @Override
    public Pair search(String key) throws Exception {
        for(int i = 0; i < indexer; i++)
        {
            if(elements[i].key == key)
                return elements[i];
        }
        throw new Exception("Element not found");
    }

    @Override
    public void push(Pair p) throws Exception {
        try{
            search(p.key);
        }
        catch(Exception e)
        {
            if(indexer == size - 1)
            {
                Pair temp[] = new Pair[2*size];
                size *= 2;
                indexer++;
                for(int i = 0; i < indexer; i++)
                {
                    temp[i] = elements[i];
                }
                elements = temp;
                elements[indexer] = p;
                return;
            }
            indexer++;
            elements[indexer] = p;
            return;
        }
        throw new Exception("Element with key " + p.key + " already exists");
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
                elements[i] = p;
                return;
            }
        }
        if(indexer < size - 1)
        {
            indexer++;
            elements[indexer] = p;
            return;
        }
        Pair temp[] = new Pair[2*size];
        size *= 2;
        indexer++;
        for(int i = 0; i < indexer; i++)
        {
            temp[i] = elements[i];
        }
        elements = temp;
        elements[indexer] = p;
    }

    @Override
    public void purge() {
        elements = new Pair[2];
        indexer = -1;
        size = 2;
    }

    @Override
    public int count() {
        return indexer + 1;
    }
}
