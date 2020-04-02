public class Cat {
    protected String name;
    protected String color;
    protected int age;
    protected int lengthRun;
    protected double heightJump;
    protected int appetit;
    protected boolean satiety;

    public Cat(String _name, String _color, int _age, int _lengthRun, double _heightJump, int _appetit) {
        this.name = _name;
        this.color = _color;
        this.age = _age;
        this.lengthRun = _lengthRun;
        this.heightJump = _heightJump;
        this.appetit = _appetit;
        this.satiety = false;
    }

    //Методы для проверки выполнения бега и прыжка из предыдущего дз(плавание убрал потому что они не умеют плавать)
    public void run(int _lengthRun) {
        if (_lengthRun <= lengthRun) {
            System.out.println("пробежал " + _lengthRun + " м");
        } else System.out.println("не пробежал " + _lengthRun + " м");
    }

    public void jump(double _heightJump) {
        if (_heightJump <= heightJump) {
            System.out.println("прыгнул на " + _heightJump + " м");
        } else System.out.println("не прыгнул на " + _heightJump + " м");
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nЦвет: " + color +
                "\nВозраст: " + age +
                "\nОграничение в беге(м): " + lengthRun +
                "\nОграничение в высоте прыжка(м): " + heightJump +
                "\nАппетит кота: " + appetit;
    }
}