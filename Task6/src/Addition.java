import javax.swing.*;
import java.awt.event.ActionEvent;

public class Addition extends AbstractAction{

    public Addition (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Сложение");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(" + ");
    }
}
