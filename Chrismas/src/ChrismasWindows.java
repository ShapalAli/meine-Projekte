import javax.swing.*;

public class ChrismasWindows  extends JFrame {

    public  ChrismasWindows(){

        super("Chrismas");
        setSize(1100, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new ChristmasPanel());
        setVisible(true);




    }
}
