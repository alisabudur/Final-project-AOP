package mvc.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alisa on 5/14/2017.
 */
public class Utils {

    public static JPanel putInPanel(Component component) {
        JPanel pan=new JPanel();
        pan.setLayout(new GridLayout(2,1));
        pan.add(component);
        return pan;
    }
}
