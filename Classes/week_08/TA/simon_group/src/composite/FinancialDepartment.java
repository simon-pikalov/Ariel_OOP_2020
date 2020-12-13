package composite;

public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    public FinancialDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

// standard constructor, getters, setters
}
