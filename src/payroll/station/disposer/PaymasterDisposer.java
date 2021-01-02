package payroll.station.disposer;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayDisposition.PAYMASTER;

public class PaymasterDisposer extends PaycheckStation {
  public PaymasterDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == PAYMASTER) {
      // Send paycheck to paymaster.
    }
    return true;
  }
}
