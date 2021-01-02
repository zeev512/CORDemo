package payroll.station.calculator;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayType.SALARIED;

public class SalariedCalculator extends PaycheckStation {
  public SalariedCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == SALARIED) {
      // do calculation
    }
    return true;
  }
}
