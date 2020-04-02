import javax.swing.*;
import java.awt.event.ActionEvent;

public class Two extends AbstractAction {

    public Two (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 2");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("2");
    }
}