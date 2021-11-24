package com.project.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringListUtils {
    public static List<Integer> convertIntStringToIntegerList(String str){
        String[] roleidlist = StringUtils.strip(str, "[]").split(",");
        int[] introleidList = Arrays.stream(roleidlist.clone()).mapToInt(i -> Integer.valueOf(i.trim())).toArray();
        List<Integer> integerroleidlist = Arrays.asList(ArrayUtils.toObject(introleidList));
        return  integerroleidlist;
    }
}
