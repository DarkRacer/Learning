import javax.swing.*;
import java.awt.event.ActionEvent;

public class Zero extends AbstractAction {

    public Zero (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 0");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("0");
    }
}