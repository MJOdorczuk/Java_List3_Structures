package Structures;

import java.util.ArrayList;

public abstract class Set {
    public abstract Pair search(String key) throws Exception;
    public abstract void push(Pair p) throws Exception;
    public abstract double read(String key) throws Exception;
    public abstract void set(Pair p) throws Exception;
    public abstract void purge();
    public abstract int count();
}
