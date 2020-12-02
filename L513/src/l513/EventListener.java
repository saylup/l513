package l513;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EventListener implements ActionListener {
    //поле для обращения (получения) данных полей
    private MainWindow m;
    public void actionPerformed(ActionEvent e) {
        //если была нажата кнопка "Do task"
        if (e.getActionCommand().equals("Do task")){

        if (m.task2RadioButton.isSelected() == true){
            Text text1 = new Text(0,m.text.getText());
            Text text2 = new Text(text1);//копия строки для преобразования
            m.label5.setText(text2.delete());
    }
        else
            if (m.task3RadioButton.isSelected() == true){
                Matrix matrix = new Matrix((int)m.spin2.getValue(),1);
                m.label5.setText(matrix.print()+"Минимальный элемент: " + matrix.searchMin());
            }
        else{
                Text text1 = new Text((int)m.spin1.getValue(),m.text.getText());
                Text text2 = new Text(text1);//копия строки для преобразования
                m.label5.setText(text2.reverse());
            }
        }
        else
        {
            //если была нажата кнопка "Save"
        if (e.getActionCommand().equals("Save")){
            Cin cin = new Cin();
            if (m.task2RadioButton.isSelected() == true){
                try {
                    //System.out.println("tyt");
                    cin.save2(m.text1.getText(),m.label5.getText());
                    if (cin.getMess()!=""){
                        JOptionPane.showMessageDialog(null,cin.getMess());
                        cin.setMess("");
                    }
                } catch (IOException ioException) {
                    System.out.println("Ошибочка");
                }
            }
            else
            if (m.task3RadioButton.isSelected() == true){
                try {
                    cin.save3(m.text1.getText());
                    if (cin.getMess()!=""){
                        JOptionPane.showMessageDialog(null,cin.getMess());
                        cin.setMess("");
                    }
                } catch (IOException ioException) {
                    System.out.println("Ошибочка");
                }
            }
            else{
                try {
                    cin.save1(m.text1.getText(),m.label5.getText());
                    if (cin.getMess()!=""){
                        JOptionPane.showMessageDialog(null,cin.getMess());
                        cin.setMess("");
                    }
                } catch (IOException ioException) {
                    System.out.println("Ошибочка");
                }
            }
        }
            //если была нажата кнопка "Open"
        if(e.getActionCommand().equals("Open")) {
            Cin cin = new Cin();
            if (m.task1RadioButton.isSelected() == true){
                cin.streamA(m.text3.getText());
                Text text1 = new Text(cin.getN(),cin.getStr());
                if (cin.getMess()!=""){
                    JOptionPane.showMessageDialog(null,cin.getMess());
                    cin.setMess("");
                }
                Text text2 = new Text(text1);//копия строки для преобразования
                m.label5.setText(text2.reverse());
            }
            else

            if (m.task2RadioButton.isSelected() == true){
                cin.streamB(m.text3.getText());
                Text text1 = new Text(0,cin.getStr1());
                if (cin.getMess()!=""){
                    JOptionPane.showMessageDialog(null,cin.getMess());
                    cin.setMess("");
                }
                Text text2 = new Text(text1);//копия строки для преобразования
                m.label5.setText(text2.delete());
            }
            else {
                try {
                    cin.streamC(m.text3.getText());
                    Matrix matrix = new Matrix(cin.getSize(),1);
                    if (cin.getMess()!=""){
                        JOptionPane.showMessageDialog(null,cin.getMess());
                        cin.setMess("");
                    }
                    m.label5.setText(matrix.print());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
        }
    }
}

