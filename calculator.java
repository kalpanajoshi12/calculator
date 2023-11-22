package com.myapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButton  = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton;
    JButton subButton;
    JButton multiButton;
    JButton divisionButton;
    JButton decButton;
    JButton clrButton;
    JButton delButton;
    JButton equButton;
    JButton negButton;
    JPanel panel;
    Font myfont = new Font("Ink free ",Font.BOLD,30);
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char opertion;

    Calculator(){
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

         textField = new JTextField();
         textField.setBounds(50,25,300,50);
         textField.setFont(myfont);
         textField.setEnabled(false);

         addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divisionButton = new JButton("/");
        clrButton = new JButton("clear");
        delButton = new JButton("delete");
        equButton= new JButton("=");
        decButton = new JButton(".");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton ;
        functionButton[2] = multiButton;
        functionButton[3] = divisionButton;
        functionButton[4] = clrButton;
        functionButton[5] = delButton;
        functionButton[6] = equButton;
        functionButton[7] = decButton;
        functionButton[8] = negButton;
        for (int i = 0;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myfont);
            functionButton[i].setFocusable(false);
        }
        for (int i = 0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        negButton.setBackground(Color.LIGHT_GRAY);
        delButton.setBounds(150,430,100,50);
        delButton.setBackground(Color.LIGHT_GRAY);
        clrButton.setBounds(250,430,100,50);
        clrButton.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiButton);
        panel.add(equButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(divisionButton);
        panel.add(negButton);










        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    Calculator cal = new Calculator();
    }
    public void actionPerformed(ActionEvent e){
        for (int i = 0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            opertion = '+';
            textField.setText("");
        }
        if(e.getSource()== subButton){
            num1 = Double.parseDouble(textField.getText());
            opertion = '-';
            textField.setText("");
        }

        if(e.getSource()== multiButton){
            num1 = Double.parseDouble(textField.getText());
            opertion = '*';
            textField.setText("");
        }

        if(e.getSource()== divisionButton){
            num1 = Double.parseDouble(textField.getText());
            opertion = '/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (opertion){
                case '+':
                    result = num1+num2;
                    break;

                case '-':
                    result = num1-num2;
                    break;

                case '*':
                    result = num1*num2;
                    break;

                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }

        if (e.getSource()==delButton){
            String str = textField.getText();
            textField.setText("");
            for (int i = 0;i<str.length()-1;i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }
        if (e.getSource()==negButton){
           Double temp = Double.parseDouble(textField.getText());
           temp*=-1;
           textField.setText(String.valueOf(temp));
        }

    }

}
