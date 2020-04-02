import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cat[] cat = new Cat[15];
    private static Bowl bowl = new Bowl(100, 0);

    public static void main(String[] args) {
        base(); // Заполнение базы котов и собак
        mainMenu(); //Запуск меню программы
    }

    /**
     * Метод отвечающий за заполнение базы
     */
    private static void base () {
        cat[0] = new Cat("Василий", "Чёрный", 4, 100, 1, 35);
        cat[1] = new Cat("Мурзик", "Белый", 1, 300, 2.5, 40);
        cat[2] = new Cat("Мур", "Серый", 2, 200, 2,  30);
    }

    /**
     * Метод отвечающий за запуск главного меню программы
     */
    private static void mainMenu() {
        while (true) {
            int n = 0;

            if (bowl.quantityFood == 0) {
                System.err.print("Миска была пуста и мы наполнили её на 20 единиц еды\n");
                bowl.quantityFood +=20;
            }

            System.out.println("___________________________________________________________");
            System.out.println("Выберете действие, которое хотите совершить \n1. Посмотреть базу котов " +
                    "\n2. Добавить кота в базу \n3. Покормить кота \n4. Покормить всех котов \n5. Посмотреть сколько еды осталось в миске" +
                    "\n6. Заполнить миску \n7. Посмотреть сытость котов " +
                    "\n8. Проверка выполнения котами бега \n9. Проверка выполнения котами прыжка" +
                    "\n10. Выход из программы");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    printBaseCat();
                    break;
                case 2:
                    addingCat();
                    break;
                case 3:
                    foodIntakeCat();
                    break;
                case 4:
                    foodIntakeAll();
                    break;
                case 5:
                    bowl.printQuantityFood();
                    break;
                case 6:
                    int kol;
                    System.out.println("Сейчас в миске "+ bowl.quantityFood + " из " + bowl.Volume + " еды");
                    System.out.println("Введите количество еды на которое хотите пополнить (от 1 до " + (bowl.Volume - bowl.quantityFood) +")");
                    kol = scanner.nextInt();
                    bowl.fill(kol);
                    break;
                case 7:
                    printSatiety();
                    break;
                case 8:
                    runCat();
                    break;
                case 9:
                    jumpCat();
                    break;
                case 10:
                    System.out.println("Программа завершила работу");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введенно не корректное значение");
            }
        }
    }

    /**
     * Метод печатающий базу котов
     */
    private static void printBaseCat (){
        System.out.println("Информация о котах");
        for (int i = 0; i < cat.length; i++){

            if (cat[i] != null) {
                System.out.println(cat[i].toString());
                System.out.print("Сытость кота: ");
                if (cat[i].satiety){
                    System.out.println("Сыт");
                }
                else System.out.println("Голоден");
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
        int appetit;
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

        System.out.print("Аппетит: ");
        appetit = scannerCat.nextInt();

        for (int i = 0; i < cat.length; i++) {

            if (cat[i] == null) {
                cat[i] = new Cat(name, color, age, lengthRun, heightJump, appetit);
                break;
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
     * Метод кормящий кота
     */
    private static void foodIntakeCat() {
        int c;
        System.out.println("Выберите кота, которого хотите накормить");
        for (int i = 0; i < cat.length; i++) {
            if (cat[i] != null) {
                System.out.println((i + 1) + " кот ");
                System.out.println(cat[i].toString());
                System.out.print("Сытость кота: ");
                if (cat[i].satiety) {
                    System.out.println("Сыт");
                } else System.out.println("Голоден");
                System.out.println("___________________________________________________");
            }
        }

        c = scanner.nextInt();
        //Кормление кота
        if (cat[c - 1] != null) {

            if (!cat[c - 1].satiety) {

                if (cat[c - 1].appetit <= bowl.quantityFood) {
                    cat[c - 1].satiety = true;
                    bowl.quantityFood -= cat[c - 1].appetit;
                    System.out.println(cat[c - 1].name + " успешно накормлен");
                }
                else System.out.println("В миске нет достаточного количества еды. "+ cat[c - 1].name + " не был накормлен");
            }
            else System.out.println(cat[c - 1].name + " сыт");
        }
        else System.out.println("Кота с таким номером нет в базе");

    }

    /**
     * Метод кормящий всех котов
     */
    private static void foodIntakeAll() {
        for (int i = 0; i < cat.length; i++) {
            if (cat[i] != null) {
                if (!cat[i].satiety) {

                    if (cat[i].appetit <= bowl.quantityFood) {
                        cat[i].satiety = true;
                        bowl.quantityFood -= cat[i].appetit;
                        System.out.println(cat[i].name + " успешно накормлен");
                    } else
                        System.out.println("В миске нет достаточного количества еды. " + cat[i].name + " не был накормлен");
                } else System.out.println(cat[i].name + " сыт");
            }
        }
    }

    /**
     * Метод показывающий сытость котов
     */
    private static void printSatiety() {
        System.out.println("Информация о сытости котов");
        for (int i = 0; i < cat.length; i++) {

            if (cat[i] != null) {
                System.out.println("Имя: " + cat[i].name);
                System.out.print("Сытость кота: ");
                if (cat[i].satiety) {
                    System.out.println("Сыт");
                } else System.out.println("Голоден");
                System.out.println("___________________________________________________");
            }
        }
    }

}
