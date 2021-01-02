package payroll.station.scheduler;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PaySchedule.WEEKLY;

public class WeeklyScheduler extends PaycheckStation {
  public WeeklyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == WEEKLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if WEEKLY.
  }
}
