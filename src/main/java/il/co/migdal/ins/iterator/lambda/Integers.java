package il.co.migdal.ins.iterator.lambda;

import java.util.Iterator;

public class Integers implements Iterable<Integer> {
    static public Integers listOfAll = new Integers();
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // private int i = 1;
            private int i = 0;

            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                // return i++;
                return i = i + 1;
            }

            public void remove() {
            }
        };
    }

    public static Iterator<Integer> all() {
        return new Integers().iterator();
    }

    public Iterator<Integer> getall() {
        return new Integers().iterator();
    }

}
