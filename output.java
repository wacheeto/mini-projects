package applicationProject;
import javax.swing.*;

public class output extends JFrame {
        public static JLabel label1 = new JLabel("Hello");
        JPanel panel1 = new JPanel();
        output(){
            panel1.setLayout(null);
            
            label1.setBounds(10,20,80,25);
            // panel1.setLayout(null);
            panel1.add(label1);

            this.setTitle("Register");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(400,220);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.add(panel1);
        }
}
