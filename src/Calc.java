//Copyright@2014 KenLee All rights reversed

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc implements ActionListener {
    private JTextField[] firstRow=new JTextField[5];
    private JButton[] secRow=new JButton[5];
    
    private  void createAndShowGUI() {
        JFrame frame = new JFrame("GuiCalcByKL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(340,170));
        // Pane's layout
        Container cp = frame.getContentPane();
        cp.setLayout(new FlowLayout());
        
        //create text field
        for(int i=0;i<5;i++){
            firstRow[i]=new JTextField();
            firstRow[i].setPreferredSize(new Dimension(60,60));//style
            firstRow[i].setHorizontalAlignment(JTextField.CENTER);
            firstRow[i].setFont(new Font("sans", Font.PLAIN, 30));
        }
        firstRow[1].setEditable(false); 
        firstRow[3].setEditable(false);
        firstRow[3].setText("=");
        firstRow[1].setText("+");
        firstRow[4].setEditable(false);
        
        // create button
         secRow[0] = new JButton("+");
         secRow[1] = new JButton("-");
         secRow[2] = new JButton("*");
         secRow[3] = new JButton("/");
         secRow[4] = new JButton("OK");
        //set size
       for(int i=0;i<5;i++){
           secRow[i].setPreferredSize(new Dimension(60,60));
           secRow[i].addActionListener(this);
       }
        
        // add buttons and text
        for(int i=0;i<5;i++){
            cp.add(firstRow[i]);
        }
        for(int i=0;i<5;i++){
            cp.add(secRow[i]);
        }
        // show the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable tr = new Runnable() {
            public void run() {
                Calc c=new Calc();
                c.createAndShowGUI();
            }
        };
        javax.swing.SwingUtilities.invokeLater(tr);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==secRow[0]){
            firstRow[1].setText("+");
        }
        else if(e.getSource()==secRow[1]){
            firstRow[1].setText("-");
        }
        else if(e.getSource()==secRow[2]){
            firstRow[1].setText("*");
        }
        else if(e.getSource()==secRow[3]){
            firstRow[1].setText("/");
        }
        else if(e.getSource()==secRow[4]){
            String a=firstRow[0].getText();
            String b=firstRow[2].getText();
            firstRow[4].setText("N/A");
            double aNum=Double.parseDouble(a);
            double bNum=Double.parseDouble(b);
            String op=firstRow[1].getText();
            if(op.equals("+")){
                firstRow[4].setText(Double.toString(aNum+bNum));
            }
            if(op.equals("-")){
                firstRow[4].setText(Double.toString(aNum-bNum));
            }
            if(op.equals("*")){
                firstRow[4].setText(Double.toString(aNum*bNum));
            }
            if(op.equals("/")){
                firstRow[4].setText(Double.toString(aNum/bNum));
            }
        }
    }
}
