public class Animal {
     protected String name;
     protected String color;
     protected int age;
     protected int lengthRun;
     protected double heightJump;
     protected int lengthSwim;

     public Animal (String _name, String _color, int _age, int _lengthRun, double _heightJump, int _lengthSwim) {
         this.name = _name;
         this.color = _color;
         this.age = _age;
         this.lengthRun = _lengthRun;
         this.heightJump = _heightJump;
         this.lengthSwim = _lengthSwim;
     }

     //Методы для проверки выполнения бега, прыжка, плавания
    public void run(int _lengthRun){
        if (_lengthRun <= lengthRun){
            System.out.println("Run: true");
        } else System.out.println("Run: false");
     }

     public void jump(double _heightJump){
         if (_heightJump <= heightJump){
             System.out.println("Jump: true");
         } else System.out.println("Jump: false");
     }

     public void swim(int _lengthSwim){
         if (_lengthSwim <= lengthSwim){
             System.out.println("Swim: true");
         } else System.out.println("Swim: false");
     }
}
