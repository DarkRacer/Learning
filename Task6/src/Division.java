import javax.swing.*;
import java.awt.event.ActionEvent;

public class Division extends AbstractAction {

    public Division (){
        putValue(AbstractAction.SHORT_DESCRIPTION, "Деление");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pane.expression.append(" / ");
    }
}
