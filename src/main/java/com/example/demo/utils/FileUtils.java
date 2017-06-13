package com.example.demo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by langshiquan on 17/6/13.
 */
public class FileUtils {
    private static Map<String, String> fileMap;

    static {
        fileMap = new HashMap<>();
        // TODO 动态获取
        fileMap.put("fileName", "/path");
    }

    // 根据文件名字，获取文件全路径
    public static String getFilePath(String fileName) {
        return fileMap.get(fileName);
    }

    public static List<String> getFilePath(String[] fileNames) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < fileNames.length; i++) {
            list.add(getFilePath(fileNames[i]));
        }
        return list;
    }

    public static List<String> getFileName(String path){
        //根据文件夹路径；得到文件夹下所有文件名
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return null;
            } else {
                for (File afile : files) {
                    if (afile.isDirectory()) {
                        list.add(afile.getName()) ;
                    }
                }
                return list;
            }
        } else {
            return null;
        }
    }
}
