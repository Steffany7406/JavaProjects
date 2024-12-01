package Java.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numButtons;
    private JButton addButton, subButton, multButton, divButton, igualButton, limparButton;
    private JPanel panel;

    private double num1, num2, resultado;
    private char operator;

    public Calculadora() {
        super("Calculadora");
        display = new JTextField();
        display.setBounds(30, 40, 280, 30);
        add(display);

        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        addButton.addActionListener(this);
        subButton = new JButton("-");
        subButton.addActionListener(this);
        multButton = new JButton("*");
        multButton.addActionListener(this);
        divButton = new JButton("/");
        divButton.addActionListener(this);
        igualButton = new JButton("=");
        igualButton.addActionListener(this);
        limparButton = new JButton("C");
        limparButton.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(30, 100, 280, 200);
        panel.setLayout(new java.awt.GridLayout(4, 4, 10, 10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multButton);
        panel.add(limparButton);
        panel.add(numButtons[0]);
        panel.add(igualButton);
        panel.add(divButton);

        add(panel);

        setSize(350,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == igualButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        display.setText("Erro");
                        return;
                    }
                    break;
                default:
                    throw new AssertionError("Digite um operador válido!");
            }
            display.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if (e.getSource() == limparButton){
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}

/* Para executar no VS Code utilize o seguinte comando no terminal 
 * javac Java/Calculadora/Calculadora.java
    java Java.Calculadora.Calculadora

 */