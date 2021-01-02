package payroll.station.disposer;

import payroll.Paycheck;
import payroll.station.PaycheckStation;

import static payroll.Employee.PayDisposition.MAIL;

public class MailDisposer extends PaycheckStation {
  public MailDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == MAIL) {
      // mail paycheck
    }
    return true;
  }
}
