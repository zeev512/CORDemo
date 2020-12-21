package il.co.migdal.ins.personalaccidents.model;

import java.util.Date;

public class Period {
    Date startPeriod = new Date();
    Date endPeriod = new Date();

    public Period(Date start, Date end) {
        this.startPeriod = start;
        this.endPeriod = end;
    }

}

