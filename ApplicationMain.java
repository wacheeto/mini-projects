package applicationProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import Salmo.Main.output;

public class ApplicationMain {

    public static boolean registered = false;
    public static void main(String[] args) {

        

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel full_name = new JLabel("Full Name:");
        full_name.setBounds(10,20,80,25);
        panel.add(full_name);

        JLabel user_name = new JLabel("User Name:");
        user_name.setBounds(10,50,80,25);
        panel.add(user_name);

        JLabel password = new JLabel("Password:");
        password.setBounds(10,80,80,25);
        panel.add(password);

        JLabel conf_pass = new JLabel("Confirm Password:");
        conf_pass.setBounds(10,110,110,25);
        panel.add(conf_pass);

        JTextField name_input = new JTextField(50);
        name_input.setBounds(100,20,250,25 );
        panel.add(name_input);

        JTextField user_name_input = new JTextField(15);
        user_name_input.setBounds(100, 50,250, 25);
        panel.add(user_name_input);

        JPasswordField password_in= new JPasswordField(12);
        JPasswordField conf_pass_in = new JPasswordField(12);
        password_in.setBounds(100,80,250,25);
        panel.add(password_in);
        conf_pass_in.setBounds(130,110,220,25);
        panel.add(conf_pass_in);
        
        JButton register_button = new JButton("Register");
        register_button.setBounds(100, 150, 90, 25);
        panel.add(register_button);
        JButton clear_button = new JButton("Clear");
        clear_button.setBounds(200, 150, 90, 25);
        panel.add(clear_button);

        //submitbutton
        register_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String curr_pass = String.valueOf(password_in.getPassword());
                String conf_curr_pass = String.valueOf(conf_pass_in.getPassword());
                String curr_name = String.valueOf(name_input.getText());
                String curr_uName = String.valueOf(name_input.getText());
                
                if ((curr_pass.equals("") || conf_curr_pass.equals("")) || (curr_pass.length() <= 5 || conf_curr_pass.length() <= 5)){//curr_pass.equals(conf_curr_pass)
                    System.out.println("error"); 
                }else if(curr_name.equals("")){
                    System.out.println("Name must be filled out!");
                }else if(curr_uName.equals("")){
                    System.out.println("Pease select a username!");
                }else{
                       try (FileWriter myWriter = new FileWriter("C:\\Users\\User\\Documents\\users registered\\"+ user_name_input.getText()+ ".txt")) {
                        myWriter.write("Name: " + name_input.getText());
                        myWriter.write("\nUser Name: " + user_name_input.getText());
                        registered = true;
                        myWriter.write("\nRegistered: " + registered);
                        myWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("Successfully wrote to the file.");
                    }
                }
            });

        //clearbutton
        clear_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                name_input.setText("");
                user_name_input.setText("");
                password_in.setText("");
                conf_pass_in.setText("");
                System.out.println("ran");
            }
        });
        
        frame.setTitle("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,220);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        //frame setup
    }
    
}
