import javax.swing.*;
import java.awt.event.ActionEvent;

public class Nine extends AbstractAction {

    public Nine (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 9");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("9");
    }
}