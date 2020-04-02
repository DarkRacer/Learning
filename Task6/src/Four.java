import javax.swing.*;
import java.awt.event.ActionEvent;

public class Four extends AbstractAction {

    public Four (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 4");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("4");
    }
}