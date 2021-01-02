package payroll.station.scheduler;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PaySchedule.MONTHLY;

public class MonthlyScheduler extends PaycheckStation {
  public MonthlyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == MONTHLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if Monthly.
  }
}
