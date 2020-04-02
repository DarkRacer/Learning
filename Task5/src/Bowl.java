public class Bowl {
    protected int Volume;
    protected int quantityFood;

    //Конструктор для миски
    public Bowl (int _Volume, int _quantityFood){
        this.Volume = _Volume;
        this.quantityFood = _quantityFood;
    }

    /**
     * Метод показывающий сколько еды осталось в миске
     */
    protected void printQuantityFood() {
        System.out.println("В миске осталось "+ quantityFood + " из " + Volume + " еды");
    }

    /**
     * Метод заполняющий миску
     */
    protected void fill(int kol){
        if (kol > 0 && kol <= Volume) {

            if ((quantityFood + kol) >= 1 && (quantityFood + kol) <= Volume) {
                quantityFood += kol;
                System.out.println("Миска успешно заполнена теперь в ней " + quantityFood + " из " + Volume + " еды");
            } else
                System.out.println("Миска не заполнена, введеное значение превышает объем миски");
        }
        else System.out.println("Было введено не корректное значение");
    }

}
