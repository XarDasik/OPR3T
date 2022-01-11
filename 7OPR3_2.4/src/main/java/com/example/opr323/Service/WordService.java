package com.example.opr323.Service;

import org.apache.derby.iapi.db.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordService {
    public static void fillWordsToDatabase(){
        Path path = Paths.get("src/main/resources/words");
        try {
            List<String> read = Files.readAllLines(path);
            for (String word: read
                 ) {
                DatabaseService.insertToWords(word);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateCode(){
        Random random = new Random();

        StringBuilder ret = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            ret.append(DatabaseService.getWord(random.nextInt(98)+1));
        }
        if(DatabaseService.isUserTextFree(ret.toString()))
            return ret.toString();
        else return null;


    }

}
