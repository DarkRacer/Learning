public class Employee {
    //Поля класса
    private String FIO;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    //Конструктор класса "Сотрудник"
    public Employee(String _FIO, String _post, String _email, String _phone, int _salary, int _age){

        this.FIO = _FIO;
        this.post = _post;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;

    }

    //Метод, печатающий информацию о сотруднике
    public void print(){
        System.out.println(" ФИО: " + FIO);
        System.out.println(" Должность: " + post);
        System.out.println(" Email: " + email);
        System.out.println(" Телефон: " + phone);
        System.out.println(" Зарплата: " + salary);
        System.out.println(" Возраст: " + age);
        System.out.println("_______________________________________________________________________");

    }

    //Getter для поля возраста
    public int getAge() {
        return age;
    }

}
