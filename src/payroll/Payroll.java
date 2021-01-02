package payroll;

import payroll.station.PaycheckStation;
import payroll.station.calculator.*;
import payroll.station.deductor.*;
import payroll.station.disposer.*;
import payroll.station.scheduler.*;

import java.util.List;

public class Payroll {
  private List<Employee> employees;
  public PaycheckStation paycheckStations;

  public Payroll(List<Employee> employees) {
    this.employees = employees;
  }

  public void setupPaycheckStations() {
    paycheckStations =
      new WeeklyScheduler(
        new MonthlyScheduler(
          new BiweeklyScheduler(
            new HourlyCalculator(
              new SalariedCalculator(
                new CommissionedCalculator(
                  new NullDeductor(
                    new UnionDeductor(
                      new DepositDisposer(
                        new MailDisposer(
                          new PaymasterDisposer(null)
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      );
  }

  public void payday() {
    for (Employee e : employees) {
      Paycheck pc = new Paycheck(e);
      paycheckStations.handlePaycheck(pc);
    }
  }
}
