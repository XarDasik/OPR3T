package cz.ou;

import cz.ou.db.CarRepository;
import cz.ou.db.EmployeeRepository;
import db.entity.Car;
import db.entity.Employee;

import java.util.List;

public class App 
{
    public static void main( String[] args ){
        createCars();
        createEmployees();
        printAll();
    }
    private static void printAll() {
        List<Car> cars = new CarRepository().getAllCars();

        List<Employee> employees = new EmployeeRepository().getAllEmployees();
        for (Employee e: employees
             ) {
            System.out.print(e.getName());
            System.out.print(" ");
            System.out.print(e.getCarByCarId().getModel());
            System.out.println(" ");
        }
    }
    private static void createEmployees() {
        CarRepository carRepository =
                new CarRepository();
        Car car = carRepository.getCarById(8);

        EmployeeRepository employeeRepository =
                new EmployeeRepository();

        Employee employee = new Employee();
        employee.setName("Jan Rubeš");
        employee.setCarByCarId(car);
        employeeRepository.saveEmployee(employee);

        Employee employee2 = new Employee();
        employee2.setName("Karel Richter");
        employee2.setCarByCarId(car);
        employeeRepository.saveEmployee(employee2);

        Employee employee3 = new Employee();
        Car car2 = carRepository.getCarById(9);
        employee3.setName("Světlana Vrasovičová");
        employee3.setCarByCarId(car2);
        employeeRepository.saveEmployee(employee3);
    }

    private static void createCars() {
        CarRepository carRepository =
                new CarRepository();

        Car car = new Car();
        car.setModel("Škoda Octavia");
        carRepository.saveCar(car);

        Car car2 = new Car();
        car2.setModel("Škoda Superb");
        carRepository.saveCar(car2);
    }
}
