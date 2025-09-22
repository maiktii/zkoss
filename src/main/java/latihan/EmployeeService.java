package latihan;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService{

    private static final List<EmployeeModel> employees = new ArrayList<>();

    static {
        // Optional: add some dummy initial data
        employees.add(new EmployeeModel("EMP001", "John Doe", "Car", "B 1234 XYZ"));
        employees.add(new EmployeeModel("EMP002", "Jane Smith", "Motorcycle", "B 5678 ABC"));
    }

    public EmployeeModel getEmployeeById(String id) {
        return employees.stream()
                .filter(e -> e.getEmployeeID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<EmployeeModel> listData(){
        return employees;
    }

    public void createData(EmployeeModel employee) {
        employees.add(employee);
    }
}
