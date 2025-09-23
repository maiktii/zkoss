package latihan.Controller;

import latihan.Model.EmployeeModel;
import latihan.Service.EmployeeService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import java.util.List;

public class ListController extends SelectorComposer<Component> {
    @Wire
    private Listbox employeeListbox;

    private final EmployeeService service = new EmployeeService();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        loadData();
    }

    private void loadData() {
        employeeListbox.getItems().clear(); // clear old
        List<EmployeeModel> employees = service.listData();

        for (EmployeeModel emp : employees) {
            Listitem item = new Listitem();
            item.appendChild(new org.zkoss.zul.Listcell(emp.getEmployeeName()));
            item.appendChild(new org.zkoss.zul.Listcell(emp.getEmployeeID()));
            item.appendChild(new org.zkoss.zul.Listcell(emp.getVehicleType()));
            item.appendChild(new org.zkoss.zul.Listcell(emp.getLicensePlate()));

            // Action buttons
            org.zkoss.zul.Listcell actionCell = new org.zkoss.zul.Listcell();
            actionCell.appendChild(new org.zkoss.zul.Button("Edit"));
            actionCell.appendChild(new org.zkoss.zul.Button("Delete"));
            item.appendChild(actionCell);

            employeeListbox.appendChild(item);
        }
    }
}
