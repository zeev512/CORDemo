package il.co.migdal.ins.iterator.operative;

import com.google.inject.Inject;
import il.co.migdal.ins.iterator.life.AbstractStationBusinessIterator;
import il.co.migdal.ins.module.ApplicationInjector;

public class OperativeClaimBusinessIterator extends AbstractStationBusinessIterator {

    @Inject
    OperativeClaimStationsIterator stationsIterator;

    @Override
    public int index() {
        return 1;
    }

    @Override
    public AbstractStationsIterator getStationsIterator() {
        return stationsIterator;
    }

    @Override
    public AbstractStationsIterator createStationsIterator() {
        if ( stationsIterator == null ) {
            stationsIterator = ApplicationInjector.instance().getInstance(OperativeClaimStationsIterator.class);
        }
        return stationsIterator;
        // return new OperativeClaimStationsIterator();
    }

    public static class OperativeClaimStationsIterator extends AbstractStationsIterator {
        public void setupFromStation() {
            fromStation = controller.fromStation("TransactionPreparator");

        }
        public void setupToStation() {
            toStation = controller.toStation("TransactionStatus");
        }

    }
}
