import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Dog[] dog = new Dog[15];
    private static Cat[] cat = new Cat[15];

    public static void main(String[] args) {
        base(); // Заполнение базы котов и собак
        mainMenu(); //Запуск меню программы
        }

    /**
     * Метод отвечающий за запуск главного меню программы
     */
    private static void mainMenu() {
        while (true) {
            int n = 0;
            System.out.println("Выберете действие, которое хотите совершить \n1. Посмотреть сотрудников старше 40 лет " +
                    "\n2. Посмотреть базу котов \n3. Посмотреть базу собак \n4. Добавить кота в базу \n5. Добавить собаку в базу" +
                    "\n6. Проверка выполнения собаками бега \n7. Проверка выполнения котами бега" +
                    "\n8. Проверка выполнения собаками прыжка \n9. Проверка выполнения котами прыжка" +
                    "\n10. Проверка выполнения собаками плавания \n11. Проверка выполнения котами плавания \n12. Выход из программы");

            n = scanner.nextInt();
            switch (n) {
                case 1:
                    infoEmployee();
                    break;
                case 2:
                    printBaseCat();
                    break;
                case 3:
                    printBaseDog();
                    break;
                case 4:
                    addingCat();
                    break;
                case 5:
                    addingDog();
                    break;
                case 6:
                    runDog();
                    break;
                case 7:
                    runCat();
                    break;
                case 8:
                    jumpDog();
                    break;
                case 9:
                    jumpCat();
                    break;
                case 10:
                    swimDog();
                    break;
                case 11:
                    swimCat();
                    break;
                case 12:
                    System.out.println("Программа завершила работу");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введенно не корректное значение");
            }
        }
    }

    /**
     * Метод отвечающий за вывод сотрудников старше 40 лет
     */
    private static void infoEmployee() {
        int g = 0; //Флаг на случай, если сотрудников старше 40 не будет найдено
        Employee[] employeeArray = new Employee[5]; //Объявление массива объектов

        //Заполнение массива объектов
        employeeArray[0] = new Employee("Иванов Иван Иванович", "Инженер", "ivivan@mailbox.com", "8923123145", 30000, 30);
        employeeArray[1] = new Employee("Петров Петр Петрович", "Менеджер", "ppetr@gmail.com", "89435646732", 65000, 45);
        employeeArray[2] = new Employee("Сергеев Сергей Сергеевич", "Водитель", "sergsergei@mailbox.com", "89223423423", 20000, 20);
        employeeArray[3] = new Employee("Васильев Василий Васильевич", "Инженер", "vasvasiliy@mailbox.com", "89233453712", 40000, 41);
        employeeArray[4] = new Employee("Максимов Максим Максимович", "Директор", "maxmaxim@mailbox.com", "89231576345", 80000, 50);

        //Поиск сотрудников старше 40
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                employeeArray[i].print();
                g = 1;
            }
        }
        if (g == 0) {
            System.out.println("Сотрудники старше 40 не найдены");
        }
    }

    /**
     * Метод отвечающий за заполнение базы
     */
    private static void base () {
        dog[0] = new Dog("Джек", "Чёрный", 2, 500, 0.5, 10);
        dog[1] = new Dog("Иван", "Белый", 3, 400, 1, 5);
        dog[2] = new Dog("Бублик", "Коричневый", 1, 600, 1.5, 15);


         cat[0] = new Cat("Василий", "Чёрный", 4, 100, 1, 0);
         cat[1] = new Cat("Мурзик", "Белый", 1, 300, 2.5, 3);
         cat[2] = new Cat("Мур", "Серый", 2, 200, 2, 1);
    }

    /**
     * Метод печатающий базу котов
     */
    private static void printBaseCat (){
        System.out.println("Информация о котах");
        for (int i = 0; i < cat.length; i++){

            if (cat[i] != null) {
                System.out.println("Имя: " + cat[i].name);
                System.out.println("Цвет: " + cat[i].color);
                System.out.println("Возраст: " + cat[i].age);
                System.out.println("Ограничение в беге(м): " + cat[i].lengthRun);
                System.out.println("Ограничение в высоте прыжка(м): " + cat[i].heightJump);
                System.out.println("Ограничение в плавании(м): " + cat[i].lengthSwim);
                System.out.println("___________________________________________________");
            }
        }
    }

    /**
     * Метод печатающий базу собак
     */
    private static void printBaseDog (){
        System.out.println("Информация о собаках");
        for (int i = 0; i < dog.length; i++){

            if (dog[i] != null) {
                System.out.println("Имя: " + dog[i].name);
                System.out.println("Цвет: " + dog[i].color);
                System.out.println("Возраст: " + dog[i].age);
                System.out.println("Ограничение в беге(м): " + dog[i].lengthRun);
                System.out.println("Ограничение в высоте прыжка(м): " + dog[i].heightJump);
                System.out.println("Ограничение в плавании(м): " + dog[i].lengthSwim);
                System.out.println("___________________________________________________");
            }
        }
    }

    /**
     * Метод добавляющий кота в базу
     */
    private static void addingCat () {
        String name;
        String color;
        int age;
        int lengthRun;
        double heightJump;
        int lengthSwim;
        Scanner scannerCat = new Scanner(System.in);

        System.out.println("Добавление кота в базу");

        System.out.print("Имя: ");
        name = scannerCat.nextLine();

        System.out.print("Цвет: ");
        color = scannerCat.nextLine();

        System.out.print("Возраст: ");
        age = scannerCat.nextInt();

        System.out.print("Ограничение в беге(м): ");
        lengthRun = scannerCat.nextInt();

        System.out.print("Ограничение в высоте прыжка(м): ");
        heightJump = scannerCat.nextInt();

        System.out.print("Ограничение в плавании(м): ");
        lengthSwim = scannerCat.nextInt();

        for (int i = 0; i < cat.length; i++) {

            if (cat[i] == null) {
                cat[i] = new Cat(name, color, age, lengthRun, heightJump, lengthSwim);
                break;
            }
        }
    }

    /**
     * Метод добавляющий собаку в базу
     */
    private static void addingDog () {
        String name;
        String color;
        int age;
        int lengthRun;
        double heightJump;
        int lengthSwim;
        Scanner scannerDog = new Scanner(System.in);

        System.out.println("Добавление кота в базу");

        System.out.print("Имя: ");
        name = scannerDog.nextLine();

        System.out.print("Цвет: ");
        color = scannerDog.nextLine();

        System.out.print("Возраст: ");
        age = scannerDog.nextInt();

        System.out.print("Ограничение в беге(м): ");
        lengthRun = scannerDog.nextInt();

        System.out.print("Ограничение в высоте прыжка(м): ");
        heightJump = scannerDog.nextInt();

        System.out.print("Ограничение в плавании(м): ");
        lengthSwim = scannerDog.nextInt();

        for (int i = 0; i < dog.length; i++) {

            if (dog[i] == null) {
                dog[i] = new Dog(name, color, age, lengthRun, heightJump, lengthSwim);
                break;
            }
        }
    }

    /**
     * Метод проверяющий выполнение бега собаками
     */
    private static void runDog (){
        int distance;
        Scanner scannerDog = new Scanner(System.in);

        System.out.println("Введите дистанцию(м): ");
        distance = scannerDog.nextInt();

        for (int i = 0; i < dog.length; i++){
            if (dog[i] != null){
                System.out.print(dog[i].name + "  ");
                dog[i].run(distance);
            }
        }
    }

    /**
     * Метод проверяющий выполнение бега котами
     */
    private static void runCat (){
        int distance;
        Scanner scannerCat = new Scanner(System.in);

        System.out.println("Введите дистанцию(м): ");
        distance = scannerCat.nextInt();

        for (int i = 0; i < cat.length; i++){
            if (cat[i] != null){
                System.out.print(cat[i].name + "  ");
                cat[i].run(distance);
            }
        }
    }

    /**
     * Метод проверяющий выполнение прыжка собаками
     */
    private static void jumpDog (){
        int distance;
        Scanner scannerDog = new Scanner(System.in);

        System.out.println("Введите высоту(м): ");
        distance = scannerDog.nextInt();

        for (int i = 0; i < dog.length; i++){
            if (dog[i] != null){
                System.out.print(dog[i].name + "  ");
                dog[i].jump(distance);
            }
        }
    }

    /**
     * Метод проверяющий выполнение прыжка котами
     */
    private static void jumpCat (){
        int distance;
        Scanner scannerCat = new Scanner(System.in);

        System.out.println("Введите высоту(м): ");
        distance = scannerCat.nextInt();

        for (int i = 0; i < cat.length; i++){
            if (cat[i] != null){
                System.out.print(cat[i].name + "  ");
                cat[i].jump(distance);
            }
        }
    }

    /**
     * Метод проверяющий выполнение плавания собаками
     */
    private static void swimDog (){
        int distance;
        Scanner scannerDog = new Scanner(System.in);

        System.out.println("Введите дистанцию(м): ");
        distance = scannerDog.nextInt();

        for (int i = 0; i < dog.length; i++){
            if (dog[i] != null){
                System.out.print(dog[i].name + "  ");
                dog[i].swim(distance);
            }
        }
    }

    /**
     * Метод проверяющий выполнение плавания котами
     */
    private static void swimCat (){
        int distance;
        Scanner scannerCat = new Scanner(System.in);

        System.out.println("Введите дистанцию(м): ");
        distance = scannerCat.nextInt();

        for (int i = 0; i < cat.length; i++){
            if (cat[i] != null){
                System.out.print(cat[i].name + "  ");
                cat[i].swim(distance);
            }
        }
    }

}

