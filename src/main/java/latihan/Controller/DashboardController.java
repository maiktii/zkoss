package latihan.Controller;

import latihan.Model.EmployeeModel;
import latihan.Service.EmployeeService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.List;

public class DashboardController extends SelectorComposer<Component> {
    @Wire
    private Label lblEmployees, lblCars, lblMotorcycles, lblSlots;

    @Wire
    private Listbox employeeListbox;

    private final EmployeeService employeeService = new EmployeeService();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        // Fetch employee list
        List<EmployeeModel> employees = employeeService.listData();

        // Top stats
        lblEmployees.setValue(String.valueOf(employees.size()));
        lblCars.setValue(String.valueOf(
                employees.stream()
                        .filter(e -> "Car".equalsIgnoreCase(e.getVehicleType()))
                        .count()
        ));
        lblMotorcycles.setValue(String.valueOf(
                employees.stream()
                        .filter(e -> "Motorcycle".equalsIgnoreCase(e.getVehicleType()))
                        .count()
        ));
        lblSlots.setValue(employees.size() + " / 200");

        // Set model instead of manual loop
        employeeListbox.setModel(new ListModelList<>(employees));
    }
}
