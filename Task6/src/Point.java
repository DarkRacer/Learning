import javax.swing.*;
import java.awt.event.ActionEvent;

public class Point extends AbstractAction {

    public Point (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить .");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(".");
    }
}