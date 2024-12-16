import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;


public class Body extends JFrame implements ActionListener{
    ArrayList<JButton> button;
    String[] names = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "÷", "=", "C", "AC"};
    String[] operations = {"+", "-", "*", "÷"};
    String[] nums =  {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",".","C","AC"};
    Double openrand1 = null;
    Double openrand2 = null;
    String operation = "";
    String eql = "=";
    Double output;
    String out1;
    String out2;
    String out3;
    JLabel[] o = new JLabel[4];
    JLabel o2;
    JLabel o3;
    JLabel o4;
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    StringBuilder sb3 = new StringBuilder();

    Font fn = new Font("Arial", Font.BOLD, 20);
 

    public void go(){
        JPanel numbers = new JPanel(new GridLayout(4, 3));
        JPanel screen = new JPanel(new GridLayout(1,6));



        for (int i = 0; i < o.length; i++) {
            o[i] = new JLabel();
            o[i].setFont(fn);
            
        }

        screen.add(o[0]);
        screen.add(o[2]);
        screen.add(o[1]);
        screen.add(o[3]);

        o[3].setVisible(false);



        for (int i = 0; i < names.length; i++) {
            JButton a = new JButton(names[i]);
            a.addActionListener(this);
            numbers.add(a);
            
        }

       


        
        screen.setBackground(Color.CYAN);
        
        getContentPane().add(BorderLayout.CENTER,screen);
        getContentPane().add(BorderLayout.SOUTH,numbers);

        
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    public void clear(){
        sb1.setLength(0);
        sb2.setLength(0);
        sb3.setLength(0);

        out1 = "";
        out2 = "";
        out3 = "";
        operation = "";

        o[3].setVisible(true);
       

        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickeButton = (JButton) e.getSource();
        String buttonText = clickeButton.getText();


        if(Arrays.asList(operations).contains(buttonText)){
            operation = buttonText;
            sb3.append(buttonText);
            
        }

        if (Arrays.asList(nums).contains(buttonText)) {
            if (operation == "") {
                output = null;
                sb1.append(buttonText);
            }else{
                sb2.append(buttonText);;
            }
        }

        
        out1 = sb1.toString();
        out2 = sb2.toString();
        out3 = sb3.toString();

        if(buttonText == eql && out1 != "" && out2 != ""){

            switch (out3.charAt(0)) {
                case '+':
                    output = Double.valueOf(out1) + Double.valueOf(out2);
                    clear();
                    break;
                case '-':
                    output = Double.valueOf(out1) - Double.valueOf(out2);  
                    clear();
                    break;
                case '*':
                    output = Double.valueOf(out1) * Double.valueOf(out2);
                    clear();
                    break;
                case '÷':
                    try {
                        output = Double.valueOf(out1) / Double.valueOf(out2); 
                        clear();
                    } catch (ArithmeticException other) {
                        throw new ArithmeticException("Cant devide By Zero");
                    }
                    break;
                default:
                    throw new ArithmeticException("Invalid operation");
            }
        }

        if (buttonText == "AC") {
            clear();
            output = null;
            for (int i = 0; i < o.length; i++) {
                o[i].setText("");
                
            }
            o[3].setVisible(false);
        }
        
        
        
        o[0].setText(sb1.toString());
        o[1].setText(sb2.toString());
        o[2].setText(sb3.toString());
        o[3].setText(String.valueOf(output));
        System.out.println(output);
        System.out.println(out2);
        

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }    
}
