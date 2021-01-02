package il.co.migdal.ins.iterator.lambda;

import il.co.migdal.ins.iterator.intiterator.Squint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SquintTest extends Squint {
    Squint classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Squint();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void runTest() throws Exception {
        List<Integer> list = classUnderTest.run(25);
        list.forEach(System.out::println);
        assertTrue(list.size() == 25);
    }

    private void assertNextValue(Iterator<Integer> list, int expectedValue) {
        assertTrue(list.hasNext());

    }

}

