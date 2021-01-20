package il.co.migdal.ins.iterator.life;

import com.google.inject.Inject;
import il.co.migdal.ins.AbstractModelFlyweight;
import il.co.migdal.ins.personalaccidents.doctor.PersonalAccidentsDoctorDecisionController;
import il.co.migdal.ins.common.services.BusinessServiceException;
import il.co.migdal.ins.iterator.intiterator.Mapper;
import il.co.migdal.ins.iterator.intiterator.Taker;
import il.co.migdal.ins.model.BaseOutput;
import il.co.migdal.ins.personalaccidents.AbstractServiceStation;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractStationBusinessIterator extends AbstractServiceStation {

    AbstractModelFlyweight flyweight;

    public abstract AbstractStationsIterator createStationsIterator();
    public abstract AbstractStationsIterator getStationsIterator();

    public void setup(BaseOutput output) {
        // stationsIterator = createStationsIterator();
        // ApplicationInjector.instance().injectMembers(stationsIterator);
        // stationsIterator.setup(output);
        getStationsIterator().setup(output);
    }

    /*public AbstractStationsIterator getStationsIterator() {
        return stationsIterator;
    }*/

    @Override
    public BaseOutput handleService(AbstractModelFlyweight flyweight) throws BusinessServiceException {
        this.flyweight = flyweight;
        AbstractServiceStation finalStation = flyweight.toStation;
        this.flyweight.toStation = getStationsIterator().getToStation();

        List<BaseOutput> list =  executeAll(take(2, handleService(all())));
        flyweight.toStation = finalStation;
        // return list.get(list.size()-1);
        return getStationsIterator().getToStation().handleService(flyweight);
    }

    public Iterator<BaseOutput> all() {
        // return stationsIterator.iterator();
        return getStationsIterator().iterator();
    }

    private List<BaseOutput> executeAll(List<BaseOutput>list) {
        for ( BaseOutput output : list )
            System.out.println(output.ind + " station: " + output.station);
        return list;
    }

    private Iterator<BaseOutput> handleService(Iterator<BaseOutput> xs) {
        return new Mapper<BaseOutput>().map(output -> {
            flyweight.output.ind = output.ind;
            return getStationsIterator().getFromStation().handleService(flyweight);
        }, xs);
    }

    private List<BaseOutput> take(int n, Iterator<BaseOutput> xs) {
        return new Taker<BaseOutput>().take(n, xs);
    }

    public abstract static class AbstractStationsIterator implements Iterator<BaseOutput> {

        protected AbstractServiceStation fromStation;
        protected AbstractServiceStation toStation;
        // private int ind = 0;
        protected BaseOutput output = new BaseOutput();

        @Inject
        protected PersonalAccidentsDoctorDecisionController controller;

        public abstract void setupFromStation();
        public abstract void setupToStation();

        public void setup(BaseOutput output) {
            setupFromStation(); //fromStation = controller.fromStation("TransactionPreparator");
            setupToStation(); // toStation = controller.toStation("HistoryCreator");
            this.output = output;
        }

        @Override
        public boolean hasNext() {
            // return !station.equals(controller.toStation());
            return true;
        }

        @Override
        public BaseOutput next() {
            // station = station.getNextStation();
            // return (T) station;
            output.ind = output.ind + 1;
            return output;
        }

        public Iterator<BaseOutput> iterator() {
            return this;
        }

        public void remove() {
        }

        public AbstractServiceStation getFromStation() {
            return this.fromStation;
        }

        public AbstractServiceStation getToStation() {
            return toStation;
        }

    }

}
