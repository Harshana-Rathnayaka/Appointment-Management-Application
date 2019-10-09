/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Hash
 */
public class SetColour {
    
    public void setColour(JLabel lbl)
    {
        lbl.setBackground(new Color(22,42,57));
    }
    
    public void resetColour(JLabel lbl)
    {
        lbl.setBackground(new Color(33,63,86));
    }
    
}
