package l513;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    static JRadioButton task2RadioButton = new JRadioButton("Task2");
    static JRadioButton task3RadioButton=new JRadioButton("Task3");;
    static JRadioButton task1RadioButton=new JRadioButton("Task1");;
    private JTextArea label1 = new JTextArea("Введите строку\nдля преобразования\n(Задание 1 и 2):");
    private JTextArea label2 = new JTextArea("Введите номер\nслова для переворота:");
    private JTextArea label3 = new JTextArea("Введите размерность\nматрицы:");
    private JLabel label6 = new JLabel("Ответ на задание:");
    static JTextArea label5 = new JTextArea();
    static JButton buttonTask=new JButton("Do task");
    static JButton buttonOpen = new JButton("Open");
    static JButton buttonSave = new JButton("Save");
    static JTextField  text = new JTextField ();
    static SpinnerModel value = new SpinnerNumberModel(1, 1, 10, 1);
    static SpinnerModel value1 = new SpinnerNumberModel(1, 1, 10, 1);
    static JSpinner spin1 = new JSpinner(value);
    static JSpinner spin2 = new JSpinner(value1);
    JScrollPane scroll = new JScrollPane(label5, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public MainWindow(){
        super("MainWindow");
//настройки главного окна
        setBounds(100,100,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //создаём контейнер, описывающий структуру окна
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,3));

//добавляем RadioButton в одну группу для того, чтобы можно было выбрать только один из них
        ButtonGroup group = new ButtonGroup();
        group.add(task1RadioButton);
        group.add(task2RadioButton);
        group.add(task3RadioButton);

        //изначально выбран 1 таск
        task1RadioButton.setSelected(true);

        //делаем недоступными JTextArea
        label5.setEditable(false);
        label1.setEditable(false);
        label2.setEditable(false);
        label3.setEditable(false);

        //устанавливаем им текст
        label1.setBackground(null);
        label2.setBackground(null);
        label3.setBackground(null);

        //и выравнивание
        //label4.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        //label7.setHorizontalAlignment(SwingConstants.CENTER);

        // добавляем в контейнер поочерёдно блоки
        container.add(task1RadioButton);
        container.add(task2RadioButton);
        container.add(task3RadioButton);

        container.add(label1);
        container.add(label2);
        container.add(label3);

        container.add(text);
        container.add(spin1);
        container.add(spin2);

        container.add(label6);
        container.add(scroll);
        container.add(buttonTask);
        
        container.add(buttonOpen);
        container.add(buttonSave);

        //создаём слушателей для обработки нажатия кнопок
        buttonTask.addActionListener(new EventListener());
        buttonSave.addActionListener(new EventListener());
        buttonOpen.addActionListener(new EventListener());
    }

}
