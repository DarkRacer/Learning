public class Main {
    public static void main(String[] args) {
        int [] arr = {0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0,1, 1, 1};//Массив для первого пункта задания
        int [] arr2 = new  int[8];//Массив для второго пункта задания
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};//Массив для третьего пункта задания
        int [][] arr4 = new int [5][5];//Массив для четвертого пункта задания
        int [] arr5 = {5, -6, 3, 6, -7, 1, -2, 9};//Массив для пятого пункта задания
        int [] arr6 = {1, 3, 5, 9};//Массив для третьего пункта задания
        int [] arr7 = {1, 2, 3, 4, 5, 6, 7, 8};//Массив для седьмого пункта задания
        int n = 2;//Переменная отвечающая за сдвиг в седьмом пункте задания

        System.out.println("Первый пункт задания");
        replacement(arr);//Вызов метода для изменения элементов массива(0 на 1; 1 на 0)
        System.out.println("\n");

        System.out.println("Второй пункт задания");
        filling(arr2);// Вызов метода заполняющего массив
        System.out.println("\n");

        System.out.println("Третий пункт задания");
        change(arr3);//Вызов метода, выполняющего умножение на 2, каждого элемента массива, который меньше 6
        System.out.println("\n");

        System.out.println("Четвертый пункт задания");
        diagonal(arr4);//Вызов метода, заполняющего диагональные элементы массива 1, остальные 0
        System.out.println("\n");

        System.out.println("Пятый пункт задания");
        search(arr5);//Вызов метода, выполняющего поиск максимального и минимального элемента
        System.out.println("\n");

        System.out.println("Шестой пункт задания");
        checkBalance(arr6);//Вызов метода, выполняющего поиск места, где сумма левой и правой части массива равны
        System.out.println("\n");

        System.out.println("Седьмой пункт задания");
        bias(arr7, n);//Вызов метода, выполняющего смещение элементов массива на n элементов
        System.out.println("\n");
    }

    private static void printArr(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.print("\n");
    } //Печать одномерного массива

    private static void printArr(int [][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }//Печать квадратного двумерного массива

    private static void replacement(int [] arr){
        System.out.println("Изначальный массив");
        printArr(arr);

        for (int i = 0; i < arr.length; i++){
            if (arr [i] == 0){
                arr[i]=1;
            } else arr[i]=0;
        }

        System.out.println("Измененный массив");
        printArr(arr);
    }

    private static void filling(int [] arr){
        for (int i = 0, j = 0; i<arr.length; i++, j+=3 ){
            arr[i]=j;
        }

        System.out.println("Заполненный массив");
        printArr(arr);
    }

    private static void change(int [] arr){
        System.out.println("Изначальный массив");
        printArr(arr);

        for (int i = 0; i < arr.length; i++){
            if (arr [i]< 6) arr[i] *=2;
        }

        System.out.println("Измененный массив");
        printArr(arr);
    }

    private  static void diagonal(int [][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (i == j) arr[i][j]=1;
            }
        }
        System.out.println("Полученный массив");
        printArr(arr);
    }

    private static void search(int [] arr){
        System.out.print("Mассив: ");
        printArr(arr);

        int max = arr[0], min = arr[0];

        for (int i = 0; i<arr.length; i++){
            if(arr[i] >= max) max = arr[i];
            else if(arr[i]<=min) min = arr[i];
        }

        System.out.println("Максимальное элемент массива: " + max);
        System.out.println("Минимальное элемент массива: "+ min);
    }

    private static void checkBalance(int [] arr){
        int rSum=0, lSum=0, g=0;

        for (int i = 0; i < arr.length-1; i++){
            rSum+=arr[i];

            for (int j = i+1; j < arr.length; j++){
                lSum += arr[j];
            }

            if (rSum == lSum) {
                g=1;
                System.out.println("true");
            }
            else lSum = 0;
        }

        if(g !=1) System.out.println("false");
    }

    private  static void bias(int [] arr, int n) {
        System.out.println("Изначальный массив");
        printArr(arr);

        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int buffer = arr[arr.length - 1];
                System.arraycopy(arr, 0, arr, 1, arr.length - 1);
                arr[0] = buffer;
            }
        }
        else {
            for (int i = 0; i > n; i--) {
                int buffer = arr[0];
                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
                arr[arr.length - 1] = buffer;
            }
        }
        System.out.println("Измененный массив");
        printArr(arr);
    }
}
