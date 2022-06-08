package com.app.matrix_natali.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileFormat {

    public static BufferedReader getFile(Context context, String fileName ){
        InputStream file = null;
        try {
            file = context.getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BufferedReader(new InputStreamReader(file));

    }

    public static String getStringifyFileContent(BufferedReader reader){
        String line = "";
        String StringifyFile = "";
        try {
            do {
                StringifyFile +=  line;

                    line = reader.readLine();

            }while (line!= null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringifyFile;
    }
}
