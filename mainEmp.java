public class mainEmp {
    public static void main(String[] args) {
        Employee first = new Employee("Jeffrey", "Smith", "it", 1000);
        Employee second = new Employee("Jeffrey", "Smith", "sales", 800);
        Employee third = new Employee("Elisa", "Bloom", "sales", 800);

        System.out.println(first.equals(second));
        System.out.println(second.equals(third));
    }
}
