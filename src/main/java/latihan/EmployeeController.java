package latihan;

import org.w3c.dom.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class EmployeeController extends SelectorComposer<Component> {

    @Wire
    private Textbox employeeName;

    @Wire
    private Textbox employeeID;

    @Wire
    private Combobox vehicleType;

    @Wire
    private Textbox licenseNumber;

    private final EmployeeService es = new EmployeeService();

    @Listen("onClick = #btnSave")
    public void registerEmployee() {
        String id = employeeID.getValue();
        String name = employeeName.getValue();
        String vehicle = vehicleType.getValue();
        String license = licenseNumber.getValue();

        System.out.println("ID:::" + id + "NAME::" + name + "TYPE::"+ vehicle+ "LICENSE::"+license);

        EmployeeModel newEmployee = new EmployeeModel(id, name, vehicle, license);
        es.createData(newEmployee);

        System.out.println("DATA EMPLOYEE NEW: " + newEmployee);

        Executions.sendRedirect("list.zul");
    }


}
