import javax.swing.*;
import java.awt.event.ActionEvent;

public class Multiplication extends AbstractAction {

    public Multiplication (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Умножение");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(" * ");
    }
}

