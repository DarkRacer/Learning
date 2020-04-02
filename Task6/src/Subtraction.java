import javax.swing.*;
import java.awt.event.ActionEvent;

public class Subtraction extends AbstractAction {

    public Subtraction (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Вычитание");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(" - ");
    }
}
