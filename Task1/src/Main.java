import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner_double = new Scanner(System.in);
        Scanner scanner_string = new Scanner(System.in);

        System.out.println("Второй пункт задания");
        variables(); //Вызов функции отвечающей за создание переменных и вывод их на экран

        System.out.println('\n'+"Третий пункт задания");
        System.out.println(calculation(2, 5, 10, 2));//вывод на экран результата метода, вычисляющего выражение a * (b + (c / d))

        System.out.println('\n'+"Четвёртый пункт задания");
        System.out.print("Введите первое число:");
        double a = scanner_double.nextDouble();
        System.out.print("Введите второе число:");
        double b = scanner_double.nextDouble();
        System.out.println(check(a,b));//вывод на экран результата метода, который проверяет лежит ли сумма чисел в диапазоне от 10 до 20

        System.out.println('\n'+"Пятый пункт задания");
        System.out.print("Введите число:");
        double argument = scanner_double.nextDouble();
        check_two(argument);//вызов метода, выполняющего проверку введенного числа

        System.out.println('\n'+"Шестой пункт задания");
        System.out.println(check_three(-5));//вывод на экран результата метода, который проверяет передано положительное число или отрицательное

        System.out.println('\n'+"Седьмой пункт задания");
        System.out.print("Введите Ваше имя: ");
        String name = scanner_string.nextLine();
        greeting(name);//вывод на экран приветствия

        System.out.println('\n'+"Восьмой пункт задания");
        System.out.print("Введите год:");
        double year = scanner_double.nextDouble();
        leap_year(year);//Вызов метода проверяющего високосный ли год
    }

    private static void variables(){
        byte b = 15;
        short s = 1308;
        int i = 23434;
        long l = 1245L;
        float f = 85.5f;
        double d = 25.3446;
        boolean bool = false;
        char c = 'B';

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
        System.out.println(c);

    }

    private static double calculation (double a, double b, double c, double d){
        return  a * (b + (c / d));
    }

    private static boolean check(double a, double b){
        double c = a + b;
        if(c>=10 && c<=20){
            return true;
        }else return false;
    }

    private static void check_two(double argument) {
        if (argument>=0){
            System.out.println("Введенное число является положительным");
        } else System.out.println("Введено отрицательное число");
    }

    private static boolean check_three(double argument) {
        if (argument>=0){
            return false;
        } else return true;
    }

    private static void greeting(String name){
        System.out.println("Привет, " + name + "!");
    }

    private static void leap_year(double year){
        int year1 = (int) year;

        if (year1 > 0 && year1 <= 3000){
            if ((year1 % 4 == 0) && (year1 % 100 != 0)){
                System.out.println("Високосный год");

            }else if(year1 % 400 ==0){
                System.out.println("Високосный год");

            } else System.out.println("Не високосный год");

        }else System.err.println("Введено не корректное значение");
    }
}
