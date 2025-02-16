/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4.StudentTeacher;

/**
 *
 * @author ADMIN
 */
public class Teacher extends Person {
//    Year in the profession, contract type, salary coefficient            

    private int yearProfession;
    private String contractType;
    private double salary;

    public Teacher() {
    }

    public Teacher(int id, String name, String phone, int yob, String major, int yearProfession, String contractType, double salary) {
        super(id, name, phone, yob, major);
        this.yearProfession = yearProfession;
        this.contractType = contractType;
        this.salary = salary;
    }

    public int getYearProfession() {
        return yearProfession;
    }

    public void setYearProfession(int yearProfession) {
        this.yearProfession = yearProfession;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.printf("%-25s %-15s %-20s", yearProfession, contractType, salary);
    }

//● Year in the profession is number from 0 to lower than age
//● Contract type is ‘Long’ or ‘Short’ value
//● Salary coefficient is number from 0
    @Override
    public void inputAll() {
        super.inputAll();
        this.yearProfession = v.getIntLimit("Enter Year in the profession:", 0, v.calcutelateAge(this.getYob()));
        this.contractType = v.getStringFromArray(new String[]{"Long", "Short"}, "Contract type");
        this.salary = v.getValidDoubleGreaterThan("Enter salary:", -1);
    }

}
