package com.example.demo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by langshiquan on 17/6/13.
 */
public class FileUtils {

    public static List<String> getFileNameList(String path) {
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
                    if (afile.isFile() && !afile.isHidden()) {
                        list.add(afile.getName());
                    }
                }
                return list;
            }
        } else {
            return null;
        }
    }
}
