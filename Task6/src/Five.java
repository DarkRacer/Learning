import javax.swing.*;
import java.awt.event.ActionEvent;

public class Five extends AbstractAction {

    public Five (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 5");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("5");
    }
}