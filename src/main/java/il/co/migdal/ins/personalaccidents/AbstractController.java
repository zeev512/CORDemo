package il.co.migdal.ins.personalaccidents;

import com.google.inject.Inject;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class AbstractController {

    protected Set<AbstractServiceStation> stations;
    protected Map<String, AbstractServiceStation> stationMap = new TreeMap<String, AbstractServiceStation>();
    protected AbstractServiceStation finalStation;

    public abstract void setupChain();
    public abstract boolean belongs(AbstractServiceStation station);

    @Inject
    public void setStations(Set<AbstractServiceStation> stations) {
        this.stations = stations;
        this.stations.stream()
                .filter(station -> belongs(station))
                .forEach(station -> stationMap.put(station.getClass().getSimpleName(), station));
        setupChain();
    }

    public AbstractServiceStation fromStation(String fromStation) {
        return stationMap.get(fromStation);
    }

    public AbstractServiceStation toStation(String toStation) {
        return stationMap.get(toStation);
    }

}



