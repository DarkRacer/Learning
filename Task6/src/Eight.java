import javax.swing.*;
import java.awt.event.ActionEvent;

public class Eight extends AbstractAction {

    public Eight (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 8");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("8");
    }
}