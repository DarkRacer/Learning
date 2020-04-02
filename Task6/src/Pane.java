import javax.swing.*;
import java.awt.*;

public class Pane {

    //Добавление TextArea
    protected static JTextArea expression = new JTextArea(10, 35);
    protected static JTextField answer = new JTextField(30);


    protected static JPanel getPane (){
        JPanel jPanel = new JPanel();

        JLabel labelAnswer = new JLabel("Ответ:   ");

        JScrollPane jScrollPane = new JScrollPane(expression);
        jPanel.add(jScrollPane);
        jPanel.add(labelAnswer);
        jPanel.add(answer);

        answer.setEditable(false);

        JPanel gridPane = new JPanel();
        GridLayout grid = new GridLayout(2, 0, 2, 10);
        gridPane.setLayout(grid);


        //Добавление кнопок на панель
        addButton(gridPane, new One(), "1");
        addButton(gridPane, new Two(), "2");
        addButton(gridPane, new Three(), "3");
        addButton(gridPane, new Four(), "4");
        addButton(gridPane, new Five(), "5");
        addButton(gridPane, new Six(), "6");
        addButton(gridPane, new Seven(), "7");
        addButton(gridPane, new Eight(), "8");
        addButton(gridPane, new Nine(), "9");
        addButton(gridPane, new Zero(), "0");
        addButton(gridPane, new Point(), ".");
        addButton(gridPane, new Addition(), "+");
        addButton(gridPane, new Subtraction(), "-");
        addButton(gridPane, new Multiplication(), "*");
        addButton(gridPane, new Division(), "/");
        addButton(gridPane, new Exponentiation(), "^");
        addButton(gridPane, new Calculation(), "=");

        jPanel.add(gridPane);
        JLabel labelInfo = new JLabel("Для корректной работы с калькулятором:");
        jPanel.add(labelInfo);

        JButton info = new JButton(new Info());
        info.setText("Информация");
        jPanel.add(info);

        return jPanel;
    }

    private static void addButton (JPanel jPanel, Action action, String name){
        JButton jButton = new JButton(action);
        jButton.setText(name);
        jPanel.add(jButton);
    }
}
