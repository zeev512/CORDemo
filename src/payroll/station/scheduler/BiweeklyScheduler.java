package payroll.station.scheduler;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PaySchedule.BIWEEKLY;

public class BiweeklyScheduler extends PaycheckStation {
  public BiweeklyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == BIWEEKLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if BIWEEKLY.
  }
}
