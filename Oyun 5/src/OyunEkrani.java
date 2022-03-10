import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class OyunEkrani extends JFrame{

    public OyunEkrani(String string) throws HeadlessException {
        super(string);
    }
   
    public static void main(String[] args) {
       
        
        
        OyunEkrani ekran = new OyunEkrani("UzayOyunu");
        
        ekran.setResizable(false);
        ekran.setSize(407, 430);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Oyun oyun = new Oyun();
        oyun.setBackground(Color.white);
        ekran.add(oyun);
        ekran.setVisible(true);
        
        
    }
    
}