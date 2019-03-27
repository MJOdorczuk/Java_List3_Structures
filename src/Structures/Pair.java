package Structures;


public class Pair {
    public final String key;
    private double value;

    public Pair(String key, double value) throws Exception {
        if(key == null || key == "") throw new Exception("Invalid key");
        this.key = key;
        this.value = value;
    }
    public void setValue(double value)
    {
        this.value = value;
    }
    public double getValue()
    {
        return this.value;
    }
    public String toString()
    {
        return key + Double.toString(value);
    }

    public int hashCode()
    {
        return key.hashCode() + new Double(value).hashCode();
    }

    public boolean equals(Object o)
    {
        if(o instanceof Pair)
        {
            return hashCode() == o.hashCode();
        }
        else return false;
    }
}
