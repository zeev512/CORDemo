package il.co.migdal.ins.personalaccidents;

import com.google.inject.Inject;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class AbstractController {

    protected Set<AbstractServiceStation> stations;
    protected Map<String, AbstractServiceStation> stationMap = new TreeMap<String, AbstractServiceStation>();

    public abstract void setupChain();

    @Inject
    public void setStations(Set<AbstractServiceStation> stations) {
        this.stations = stations;
        this.stations.stream().forEach(station -> stationMap.put(station.getClass().getSimpleName(), station));
        setupChain();
    }

}



