package payroll.station.deductor;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayDeduction.NONE;

public class NullDeductor extends PaycheckStation {
  public NullDeductor(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDeduction == NONE) {
      // do calculation
    }
    return true;
  }
}
