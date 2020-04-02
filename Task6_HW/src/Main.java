import javax.swing.*;

public class Main {

    protected static JPanel jPanel;
    public static void main(String[] args) {
        JFrame jFrame = Frame.getFrame();
        jPanel= Pane.getPane();

        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
