package l513;
public class Text {
    //Описание класса для работы со строкой
    // Объявление внутренних полей объекта этого класса.
    private static int num;  // Поле для хранения номера удаляемого эл-та
    private static String str;   //Поле для хранения строки

    // Объявление методов, определяющих поведение объектов-экземпляров этого класса

    public Text(){//конструктор по умолчанию
        this.num = 1;
        this.str = "Hello, how are you?";
    }
    public Text(int num, String s){//конструктор с параметрами
        this.num = num;
        this.str = s;
    }
    public Text(Text s){//конструктор копирования
        this.num = s.num;
        this.str = s.str;
    }
    public String getStr(){
        return this.str;
    }
    public int getNum(){
        return this.num;
    }

    //разворот выбранного слова
    public String reverse(){
        String[] words = this.str.split("[?!,. ]+");
        String mess = "";
        //проверяем есть ли слово под заданным индексом в стоке
        if(words.length<num){
            mess = "Слова под этим \nномером нет в данной \nстроке";
        }
        else
        {
            String word = "Исходное слово: "+"\n"+words[num-1] +"\n"+"Перевернутое слово: "+"\n"+ new StringBuffer(words[num-1]).reverse().toString();
            mess = word;
        }
        return mess;
    }

    //удаление каждого третьего слова
    public String delete(){
        //создаем массив слов
        String[] words= this.str.split("[?!,. ]+");
        //очищаем строку для последующего заполнения
        this.str="";
        //заполняем строку, избегая каждого третьего слова
        for (int i=0;i<words.length;i++){
            if((i+1)%3!=0){
                this.str+=words[i]+" ";
            }
        }
        return this.str;
    }
}

