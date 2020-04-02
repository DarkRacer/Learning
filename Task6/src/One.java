import javax.swing.*;
import java.awt.event.ActionEvent;

public class One extends AbstractAction {

    public One (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 1");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("1");
    }
}
