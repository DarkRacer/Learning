import javax.swing.*;
import java.awt.event.ActionEvent;

public class Six extends AbstractAction {

    public Six (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 6");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("6");
    }
}