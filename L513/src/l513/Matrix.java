package l513;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    //Описание класса для работы с матрицей
    // Объявление внутренних полей объекта этого класса.
    private static int size = 0;  // Поле для хранения размерности матрицы
    private static int[][] matr;  //Поле для хранения самой матрицы

    // Объявление методов, определяющих поведение объектов-экземпляров этого класса
    public Matrix(){//конструктор по умолчанию
        this.size = 3;
        this.matr = createMatrixRandom();
    }
    public Matrix(int size, int key){//конструктор с параметрами
        if(size<1) this.size = 1;
        else
            this.size = size;
        if(key==1){
            this.matr = createMatrixRandom();//заполнение случайными значениями
        }
        else
            this.matr = createMatrix();//пользовательский ввод
    }
    public Matrix(Matrix m){//конструктор копирования
        this.size = m.size;
        this.matr = m.matr;
    }

    public int[][] getMatrix(){
        return this.matr;
    }

    public void setMatrix(int[][] n){
        if(n.length==this.size)
            this.matr=n;
    }

    public int getSize(){
        return size;
    }
    public void setElement(int i, int j, int val){
        this.matr[i][j] = val;
    }
    public int getElement(int i,int j){
        return matr[i][j];
    }

    //Метод заполняющий матрицу случайными значениями
    private int[][] createMatrixRandom(){
        this.matr = new int[this.getSize()][this.getSize()];
        int lim=100;
        Random rand = new Random();
        // Создаём объект rand класса Random
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.setElement(i, j, rand.nextInt(lim)-50);
                // с помощью вызова метода nextInt объекта rand получаем случайное значение
                //в диапазоне от 0 до значения параметра lim
            }
        }
        return this.matr;
    }

    //Метод заполняющий матрицу пользовательскими значениями
    private int[][] createMatrix(){
        this.matr = new int[this.getSize()][this.getSize()];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Scanner in = new Scanner(System.in);
                int val = 0;
                //обработка ввода
                boolean validInput = false;
                do {
                    try {
                        System.out.print("x["+i+", "+j+"] = ");
                        val = in.nextInt();
                        validInput = true;
                    }
                    catch (Exception e) {
                        System.out.println("Введите число!");
                        in.next();
                    }
                } while (!validInput);
                this.setElement(i, j, val);
            }
        }
        return this.matr;
    }

    //поиск минимального значения
    public int searchMin(){
        int min=matr[0][0];
        for(int i=0;i<this.size;i++)
            for(int j=0;j<this.size;j++)
                if(this.getElement(i, j)<min) min=this.getElement(i, j);
        return min;
    }

    //Метод предназначен для вывода на экран матрицы объекта этого класса
    public String print() {
        String str="";
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.getElement(i, j) + " ");
                str+=(this.getElement(i, j))+ " ";
                /*Выводим на экран элемент с индексами i и j
                (получаем его с помощью метода этого класса getElement)*/
            }
            str+="\n";
            System.out.println();
        }
    return str;
    }
}
