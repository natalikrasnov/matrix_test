package com.app.matrix_natali.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.app.matrix_natali.data.model.DataListObject;

import java.util.ArrayList;
import java.util.function.Function;

public class Mapping {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static DataListObject[] map(DataListObject[] oldArr, Function func){
        DataListObject[] newArr = new DataListObject[oldArr.length];
        for (int i = 0; i < oldArr.length && oldArr[i] != null; i++) {
            DataListObject object = oldArr[i];
            newArr[i] = (DataListObject) func.apply(object);
        }
        return newArr;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Object findOne(Object[] array, Function func){
        for (Object o : array) {
            boolean isIt = (boolean) func.apply(o);
            if (isIt) return o;
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Integer findIndex(Object[] array, Function func){
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            Object o = array[i];
            boolean isIt = (boolean) func.apply(o);
            if (isIt) return i;
        }
        return null;
    }
}
