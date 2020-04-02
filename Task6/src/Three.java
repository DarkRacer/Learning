import javax.swing.*;
import java.awt.event.ActionEvent;

public class Three extends AbstractAction {

    public Three (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Добавить 3");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append("3");
    }
}