package payroll.station.deductor;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayDeduction.UNION;

public class UnionDeductor extends PaycheckStation {
  public UnionDeductor(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDeduction == UNION) {
      // do calculation
    }    return true;
  }
}
