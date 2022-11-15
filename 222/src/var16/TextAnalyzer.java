package var10;

/**
 */

import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;

public class TextAnalyzer {
    public static void main(String[] args) {
        int ratioWords = 0;

        //Создаём настороения
        Mood positive = new Mood("Positive");
        Mood negative = new Mood("Negative");

        //Создаём банк слов
        ArrayList<Word> wordList = new ArrayList<Word>();

        wordList.add(new Word("recommend", positive, +1));
        wordList.add(new Word("verified", positive, +1));
        wordList.add(new Word("verifying", positive, +1));
        wordList.add(new Word("verification", positive, +1));
        wordList.add(new Word("support", positive, +4));
        wordList.add(new Word("ok", positive, +2));
        wordList.add(new Word("yes", positive, +1));

        wordList.add(new Word("don't", negative, -1));
        wordList.add(new Word("never", negative, -1));
        wordList.add(new Word("stupid", negative, -3));
        wordList.add(new Word("lose", negative, -2));
        wordList.add(new Word("storm", negative, -2));

        //Считываем текст из файла
        String fileName = "C:\\Users\\q\\Desktop\\Орехова УП\\УП_5\\222\\data.txt";
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        String tempString;
        int counter = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));

            while ((tempString = in.readLine()) != null) {
                for (Word item : wordList) {
                    Pattern p = Pattern.compile(item.getSpelling());
                    Matcher m = p.matcher(tempString);
                    counter = 0;

                    //Подсчёт поличества совпадений слова в очередной строке
                    while (m.find()) {
                        counter++;
                    }
// test
                    //Учитываем вес слова в общем рейтинге текста
                    if(counter > 0) {
                        ratioWords += item.getRatio() * counter;
                    }
                }
            }
            System.out.println("RatingText: " + ratioWords);
            in.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}
