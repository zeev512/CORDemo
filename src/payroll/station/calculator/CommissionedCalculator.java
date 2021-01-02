package payroll.station.calculator;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayType.COMMISSIONED;

public class CommissionedCalculator extends PaycheckStation {
  public CommissionedCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == COMMISSIONED) {
      // do calculation
    }
    return true;
  }
}
