package org.itstep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Java. Lesson038. Task01
 * Алиса в стране чудес
 * @author Semenyuk Alexander
 * Date 1.12.2022
 *
 * Написать программу для подсчета наиболее встречающихся слов в неком тексте произведения Алиса в стране чудес.
 * Файл с текстом прилагается.
 * При выводе результатов привести первые 10 наиболее встречающихся слова (длинной более 3 букв)
 * с указанием их количества.
 * Пример вывода:
 *
 * алиса: 406
 * сказала: 126
 * было: 105
 * сказал: 100
 * если: 87
 * только: 87
 * очень: 71
 * когда: 64
 * король: 61
 * подумала: 61
 *
 * Подсчет слов не должен учитывать регистр и знаки препинания.
 * Рекомендуется использовать Stream API для решения этого задания
 */
public class Task01 {
    public static void main(String[] args) throws IOException {
        Path fileAlica = Path.of("alice.txt");
        List<Word> rezult = new ArrayList();
        int n = 10;
        for (int i = 0; i < n; i++) {
            rezult.add(new Word());
        }
        String line = Files.readString(fileAlica);

//        String [] array = line.toLowerCase().split("[,.*\\-!\\? ;:\"{}()_\\d\\r\\n]");        // вариант 1 = вариант 2
        String [] array = line.toLowerCase().split("[^a-zA-Zа-яёА-ЯЁ]");                  // вариант 2
//        String [] array = line.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "").split(" ");    // Этот вариант показывает результат хуже

        int amount = 1;
        String tmpLine = "";
        Object[] array1 =  Arrays.stream(array)
                .filter(x -> x.length() > 3)
                .sorted((String::compareTo))
                .toArray();

        for (int i = 0; i < array1.length; i++) {
            if (i == 0){
                tmpLine = (String) array1[i];
            } else {
                if (tmpLine.equals(array1[i])) {
                    amount++;
                } else {
                    rezult = formRezult(rezult, tmpLine, amount);
                    tmpLine = (String) array1[i];
                    amount = 1;
                }
            }
        }

        // Вывод слов в консоль сортированного массива слов
//        for (int i = 0; i < array1.length; i++) {
//            System.out.print(array1[i] + " ");
//        }
//        System.out.println();

        rezult.forEach(System.out::print);
    }

    // перезапись списка с 1 позиции, если кол-во повторений больше, чем было экземпляре списка, сохраняя в промежуточную переменную
    public static List <Word> formRezult (List <Word> arr, String word, int amount){
        String tmpWord = "";
        int tmpAmount = 0;
        for (Word w: arr){
            if (amount > w.getAmount()){
                tmpWord = w.getWord();
                tmpAmount = w.getAmount();
                w.setWord(word);
                w.setAmount(amount);
                word = tmpWord;
                amount = tmpAmount;
            }
        }
        return arr;
    }
}
