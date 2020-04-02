import javax.swing.*;
import java.awt.*;

public class Pane {

    //Добавление TextField
    protected static JTextField expression1 = new JTextField(20);
    protected static JTextField expression2 = new JTextField(20);
    protected static JTextField answer = new JTextField(20);


    protected static JPanel getPane (){
        JPanel jPanel = new JPanel();

        //Создание JLabel
        JLabel labelOne = new JLabel("Первое число: ");
        JLabel labelTwo = new JLabel("Второе число (или степень): ");
        JLabel labelAnswer = new JLabel("Ответ:   ");

        //Добавление JLabel и JtextField
        jPanel.add(labelOne);
        jPanel.add(expression1);
        jPanel.add(labelTwo);
        jPanel.add(expression2);
        jPanel.add(labelAnswer);
        jPanel.add(answer);

        answer.setEditable(false);

        JPanel gridPane = new JPanel();
        GridLayout grid = new GridLayout(0, 5, 2, 10);
        gridPane.setLayout(grid);


        //Добавление кнопок на панель
        addButton(gridPane, new Addition(), "+");
        addButton(gridPane, new Subtraction(), "-");
        addButton(gridPane, new Multiplication(), "*");
        addButton(gridPane, new Division(), "/");
        addButton(gridPane, new Exponentiation(), "^");

        jPanel.add(gridPane);

        return jPanel;
    }

    /**
     * Метод для создания кнопки
     * @param jPanel - панель на которую добавляется кнопка
     * @param action - событие, которое происходит по нажатию на кнопку
     * @param name - Текс кнопки
     */
    private static void addButton (JPanel jPanel, Action action, String name){
        JButton jButton = new JButton(action);
        jButton.setText(name);
        jPanel.add(jButton);
    }
}