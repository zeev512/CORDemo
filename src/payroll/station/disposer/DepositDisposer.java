package payroll.station.disposer;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayDisposition.DIRECT;

public class DepositDisposer extends PaycheckStation {
  public DepositDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == DIRECT) {
      // deposit paycheck
    }
    return true;
  }
}
