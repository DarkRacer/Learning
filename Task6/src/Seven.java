import javax.swing.*;
import java.awt.event.ActionEvent;

public class Seven extends AbstractAction {

    public Seven (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 7");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("7");
    }
}