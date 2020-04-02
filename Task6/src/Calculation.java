import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.lang.Math.pow;

public class Calculation extends AbstractAction {

    public Calculation() {
        putValue(AbstractAction.SHORT_DESCRIPTION, "Вычисление");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        double one;
        double two;

        if (!Pane.expression.getText().matches("^[а-яА-Я]+$") && !Pane.expression.getText().isEmpty() &&!Pane.expression.getText().matches("^[A-Za-z]+$")) {

            String[] calc = Pane.expression.getText().split(" ");

            if (calc.length < 3) {
                JOptionPane.showMessageDialog(Main.jPanel, "Недостаточно аргументов", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            else if (!calc[1].equals("+") && !calc[1].equals("-") && !calc[1].equals("/") && !calc[1].equals("*") && !calc[1].equals("^")) {
                JOptionPane.showMessageDialog(Main.jPanel, "Не указана арифметическая операция или она не корректна", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            else if (calc.length == 3) {

                if (!calc[0].equals("+") || !calc[0].equals("-") || !calc[0].equals("/") || !calc[0].equals("*") || !calc[0].equals("^")
                        && !calc[2].equals("+") || !calc[2].equals("-") || !calc[2].equals("/") || !calc[2].equals("*") || !calc[2].equals("^")){
                    try {
                        one = Double.parseDouble(calc[0]);
                        two = Double.parseDouble(calc[2]);

                        if (calc[1].equals("+")){
                            Pane.answer.setEditable(true);
                            Pane.answer.setText(String.valueOf(one + two));
                            Pane.answer.setEditable(false);
                        }
                        else if (calc[1].equals("-")) {
                            Pane.answer.setEditable(true);
                            Pane.answer.setText(String.valueOf(one - two));
                            Pane.answer.setEditable(false);
                        }
                        else if (calc[1].equals("*")) {
                            Pane.answer.setEditable(true);
                            Pane.answer.setText(String.valueOf(one * two));
                            Pane.answer.setEditable(false);
                        }
                        else if (calc[1].equals("/")) {
                            if (two != 0){
                                Pane.answer.setEditable(true);
                                Pane.answer.setText(String.valueOf(one / two));
                                Pane.answer.setEditable(false);
                            }
                            else JOptionPane.showMessageDialog(Main.jPanel, "На ноль делить нельзя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        }
                        else if (calc[1].equals("^")) {
                            Pane.answer.setEditable(true);
                            Pane.answer.setText(String.valueOf(pow(one, two)));
                            Pane.answer.setEditable(false);
                        }
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(Main.jPanel, "Возникла ошибка " + e, "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            else JOptionPane.showMessageDialog(Main.jPanel, "Число цифр или арифметических операций превышает допустимое количество", "Ошибка", JOptionPane.ERROR_MESSAGE);

        } else
            JOptionPane.showMessageDialog(Main.jPanel, "Были введены не допустимые символы или поля ввода пусто", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
