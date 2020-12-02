package l513;
import java.io.*;
public class Cin {
    private static String str;
    private static String str1;
    private static int n;
    private static int size;
    private static int[][] matr;
    private static String mess="";

    public static String getMess() {
        return mess;
    }

    public static void setMess(String mess) {
        Cin.mess = mess;
    }

    public void streamA(String nameFile){//чтение из файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(".//src//l513//"+nameFile+".txt"));) {
            String s="";
            int symbol = bufferedReader.read();
            char c = (char) symbol;
            s+=c;
            while (c !='\n') {
                symbol = bufferedReader.read(); // Читаем символ
                c = (char) symbol;
                if (c !='\n')
                    s+=c;
            }
            setStr(s);
            s="";
            symbol = bufferedReader.read();
            while (symbol!=-1) {
                c = (char) symbol;
                s+=c;
                symbol = bufferedReader.read(); // Читаем символ
            }
            System.out.println(getStr());
            System.out.println(Integer.parseInt(s));
            setN(Integer.parseInt(s));
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данным именем не найден. Задана строка по умолчанию");
            setMess("Файл с данным именем не найден. Задана строка по умолчанию");
            Text text = new Text();
            setStr(text.getStr());
            setN(text.getNum());
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");
        }
    }
    public void streamB(String nameFile){//чтение из файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(".//src//l513//"+nameFile+".txt"));) {
            String s="";
            int symbol = bufferedReader.read();
            char c = (char) symbol;
            s+=c;
            while (c !='\n') {
                symbol = bufferedReader.read(); // Читаем символ
                c = (char) symbol;
                if (c !='\n')
                    s+=c;
            }
            setStr1(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данным именем не найден. Задана строка по умолчанию");
            setMess("Файл с данным именем не найден. Задана строка по умолчанию");
            Text text = new Text();
            setStr1(text.getStr());
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");

        }

    }
    public void streamC(String nameFile) throws IOException {//чтение из файла
        try(DataInputStream dos = new DataInputStream(new FileInputStream(".//src//l513//"+nameFile+".bin")))
        {
            int size = dos.available();
            int a;
            a = dos.readByte();
            setSize(a);
        }catch (FileNotFoundException e) {
            System.out.println("Файл с данным именем не найден. Задана матрица по умолчанию");
            setSize(3);
            setMess("Файл с данным именем не найден. Задана матрица по умолчанию");
        }
        catch(IOException e){
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");
        }
    }
    public void save1(String nameFile,String s) throws IOException {//чтение из файла
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".//src//l513//"+nameFile+".txt"));) {
            bufferedWriter.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данным именем не найден.");
            setMess("Файл с данным именем не найден.");
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");

        }
    }
    public void save2(String nameFile,String s) throws IOException {//чтение из файла
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".//src//l513//"+nameFile+".txt"));) {
            bufferedWriter.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данным именем не найден.");
            setMess("Файл с данным именем не найден.");
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");

        }
    }
    public void save3(String nameFile) throws IOException {//чтение из файла
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(".//src//l513//"+nameFile+".bin")))
        {
            Matrix m = new Matrix();
            int size = m.getSize();
            for (int i=0;i<size;i++)
                for (int j=0;j<size;j++)
                    dos.writeByte(m.getElement(i,j));
        }
        catch(IOException e){
            System.out.println("Произошла ошибка ввода/вывода");
            setMess("Произошла ошибка ввода/вывода");
        }
    }
    public void setSize(int size) {this.size = size;}
    public int getSize() {return size;}
    public String getStr1() {return str1;}
    public void setStr1(String str1) {this.str1 = str1;}
    public String getStr() {return str;}
    public void setStr(String str) {this.str = str;}
    public int getN() {return n;}
    public void setN(int n) {this.n = n;}
}
