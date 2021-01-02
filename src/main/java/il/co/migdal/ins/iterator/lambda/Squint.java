package il.co.migdal.ins.iterator.lambda;

import java.util.Iterator;
import java.util.List;


public class Squint {
    public List<Integer> run() throws Exception {
        // return printAll(take(25, squaresOf(Integers.all())));
        return printAll(take(4, squaresOf(Integers.all())));
    }

    private List<Integer> printAll(List<Integer>list) {
        for ( int i : list )
            System.out.println(i);
        return list;
    }

    private Iterator<Integer> squaresOf(Iterator<Integer> xs) {
        return new Mapper<Integer>().map(x -> x * x, xs);
    }

    private List<Integer> take(int n, Iterator<Integer> xs) {
        return new Taker<Integer>().take(n, xs);
    }

}

