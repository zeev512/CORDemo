package payroll;

import org.junit.Before;
import org.junit.Test;
import payroll.Employee.PayDeduction;
import payroll.Employee.PayDisposition;
import payroll.Employee.PaySchedule;
import payroll.Employee.PayType;
import payroll.station.PaycheckStation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static payroll.Employee.PaySchedule.MONTHLY;
import static payroll.Employee.PaySchedule.WEEKLY;

public class payrollTest {
  private String marks = "";
  private List<Employee> employees = new ArrayList<>();

  class Marker<T> extends PaycheckStation {
    private final String mark;
    private final T type;

    public Marker(String mark, T stationType, PaycheckStation nextStation) {
      super(nextStation);
      this.mark = mark;
      this.type = stationType;
    }

    protected boolean doPaycheck(Paycheck paycheck) {
      if (isForThisStation(paycheck.employee))
        marks = marks + mark;
      return true;
    }

    private boolean isForThisStation(Employee e) {
      return type instanceof PaySchedule && type == e.paySchedule ||
        type instanceof PayType && type == e.payType ||
        type instanceof PayDeduction && type == e.payDeduction ||
        type instanceof PayDisposition && type == e.payDisposition;
    }
  }

  @Before
  public void setup() {
  }

  @Test
  public void singleStation() throws Exception {
    Employee weekly = new Employee();
    weekly.paySchedule = WEEKLY;
    employees.add(weekly);

    Payroll payroll = new Payroll(employees);
    payroll.paycheckStations = new Marker<PaySchedule>("X", WEEKLY, null);
    payroll.payday();
    assertEquals("X", marks);
  }

  @Test
  public void twoStations() throws Exception {
    Employee weekly = new Employee();
    weekly.paySchedule = WEEKLY;
    Employee monthly = new Employee();
    monthly.paySchedule = MONTHLY;
    employees.add(weekly);
    employees.add(monthly);

    Payroll payroll = new Payroll(employees);
    payroll.paycheckStations =
      new Marker<PaySchedule>("W", WEEKLY,
        new Marker<PaySchedule>("M", MONTHLY, null));
    payroll.payday();
    assertEquals("WM", marks);
  }

}
