import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.lang.Math.pow;

public class Exponentiation extends AbstractAction {

    public Exponentiation (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Возведение в степень");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(" ^ ");
    }
}
