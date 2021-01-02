package il.co.migdal.ins.iterator.intiterator;

import java.util.Iterator;
import java.util.List;


public class Squint {
    public List<Integer> run(int size) throws Exception {
        return take(size, squaresOf(Integers.all()));
    }

    private Iterator<Integer> squaresOf(Iterator<Integer> xs) {
        return new Mapper<Integer>().map(x -> x * x, xs);
    }

    private List<Integer> take(int n, Iterator<Integer> xs) {
        return new Taker<Integer>().take(n, xs);
    }

}

