package latihan;

public class EmployeeModel {
    private String employeeName;
    private String employeeID;
    private String vehicleType;
    private String licensePlate;

    public EmployeeModel(String employeeName, String employeeID, String vehicleType, String licensePlate){
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public void setEmployeeID(String employeeID){
        this.employeeName = employeeID;
    }

    public String getEmployeeID(){
        return employeeID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
         this.licensePlate = licensePlate;
    }
}
