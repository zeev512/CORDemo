package payroll.station.calculator;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayType.HOURLY;

public class HourlyCalculator extends PaycheckStation {
  public HourlyCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == HOURLY) {
      // do calculation
    }
    return true;
  }
}
