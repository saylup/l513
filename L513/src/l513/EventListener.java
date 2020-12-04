package l513;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
                Cin cin = new Cin();
                cin.setSize((int)m.spin2.getValue());
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
            if (e.getActionCommand().equals("Save")) {
                System.out.println(m.label5.getText());
                if (m.label5.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Нет данных для сохранения");
                } else {
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.*");
                    JFileChooser filesave = new JFileChooser();
                    filesave.setFileFilter(filter);
                    int ret = filesave.showDialog(null, "Сохранить файл");
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        File file = filesave.getSelectedFile();
                        System.out.println(file);
                        Cin cin = new Cin();
                        if (m.task2RadioButton.isSelected() == true) {
                            try {
                                cin.save2(file, m.label5.getText());
                                if (cin.getMess() != "") {
                                    JOptionPane.showMessageDialog(null, cin.getMess());
                                    cin.setMess("");
                                }
                            } catch (IOException ioException) {
                                System.out.println("Ошибочка");
                            }
                        } else if (m.task3RadioButton.isSelected() == true) {
                            try {
                                cin.save3(file, m.label5.getText());
                                if (cin.getMess() != "") {
                                    JOptionPane.showMessageDialog(null, cin.getMess());
                                    cin.setMess("");
                                }
                            } catch (IOException ioException) {
                                System.out.println("Ошибочка");
                            }
                        } else {
                            try {
                                cin.save1(file, m.label5.getText());
                                if (cin.getMess() != "") {
                                    JOptionPane.showMessageDialog(null, cin.getMess());
                                    cin.setMess("");
                                }
                            } catch (IOException ioException) {
                                System.out.println("Ошибочка");
                            }
                        }
                    }
                }
            }
            //если была нажата кнопка "Open"
            if(e.getActionCommand().equals("Open")) {
                JFileChooser fileopen = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "*.*");
                fileopen.setFileFilter(filter);
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {

                    File file = fileopen.getSelectedFile();
                    if (file.exists() && !file.isDirectory()) {
                        Cin cin = new Cin();
                        System.out.println(file);
                        if (m.task1RadioButton.isSelected() == true) {
                            cin.streamA(file);
                            Text text1 = new Text(cin.getN(), cin.getStr());
                            if (cin.getMess() != "") {
                                JOptionPane.showMessageDialog(null, cin.getMess());
                                cin.setMess("");
                            }
                            System.out.println(0);
                            Text text2 = new Text(text1);//копия строки для преобразования
                            m.text.setText(text1.getStr());
                            m.spin1.setValue(cin.getN());
                            m.label5.setText(text2.reverse());
                        } else if (m.task2RadioButton.isSelected() == true) {
                            cin.streamB(file);
                            Text text1 = new Text(0, cin.getStr1());
                            if (cin.getMess() != "") {
                                JOptionPane.showMessageDialog(null, cin.getMess());
                                cin.setMess("");
                            }
                            Text text2 = new Text(text1);//копия строки для преобразования
                            m.text.setText(text1.getStr());
                            m.label5.setText(text2.delete());
                        } else {
                            try {
                                cin.streamC(file);
                                Matrix matrix = new Matrix(cin.getSize(), 1);
                                if (cin.getMess() != "") {
                                    JOptionPane.showMessageDialog(null, cin.getMess());
                                    cin.setMess("");
                                }
                                m.label5.setText(matrix.print());
                                m.spin2.setValue(cin.getSize());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }

                        }
                    }
                    else JOptionPane.showMessageDialog(null, "Файл не существует!");
                }
            }
        }
    }
}

