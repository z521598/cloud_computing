package com.example.demo.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by langshiquan on 17/6/12.
 */
public class PdfUtils {
    public static String parsePdfToTxt(String filePath) {
        String excute = "pdftotext";

        String[] cmd = new String[] {excute, "-enc", "UTF-8", "-q", filePath, "-"};
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedInputStream bis = new BufferedInputStream(p.getInputStream());

        InputStreamReader reader = null;

        try {
            reader = new InputStreamReader(bis, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();

        try {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            sb = new StringBuffer();
            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
