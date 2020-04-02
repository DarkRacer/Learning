import javax.swing.*;
import java.awt.event.ActionEvent;

public class Addition extends AbstractAction {

    public Addition (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Сложение");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        double one;
        double two;
        //"^[A-Za-z]+$"
        if (!Pane.expression1.getText().matches("^[а-яА-Я]+$") && !Pane.expression1.getText().isEmpty() && !Pane.expression1.getText().matches("^[A-Za-z]+$") &&
                !Pane.expression2.getText().matches("^[а-яА-Я]+$") && !Pane.expression2.getText().isEmpty() && !Pane.expression2.getText().matches("^[A-Za-z]+$")) {

            String[] calc = Pane.expression1.getText().split(" ");
            String[] calc1 = Pane.expression2.getText().split(" ");
            try {
                one = Double.parseDouble(calc[0]);
                two = Double.parseDouble(calc1[0]);
                Pane.answer.setEditable(true);
                Pane.answer.setText(String.valueOf(one + two));
                Pane.answer.setEditable(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Main.jPanel, "Возникла ошибка " + e, "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(Main.jPanel, "Были введены не допустимые символы или поля ввода пусто", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

}