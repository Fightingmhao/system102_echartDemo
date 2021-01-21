package com.rayootech.utils;

import java.io.*;
import java.util.Arrays;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/16 12:02
 */
public class FileUtils {
    /**
     * 文件复制
     * @param srcPath
     * @param tarPath
     * @throws IOException
     */
    public static void fileCopy(String srcPath,String tarPath) throws IOException {
        File file = new File(srcPath);
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(tarPath);
        byte[] bytes = new byte[1024];
        int i = -1;
        while ((i = in.read(bytes)) != -1) {
            out.write(bytes, 0, i);
        }
        out.close();
        in.close();

    }

    public static String msg(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        byte[] b = new byte[1024];
        int len = -1;
        while((len = fis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] bytes = bos.toByteArray();
        //删除压缩包
        file.delete();
        String replace = Arrays.toString(bytes).replace("[", "").replace("]", "");
        return replace;
    }

    public static String msg(InputStream inputStream,int length) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
        byte[] b = new byte[1024];
        int len = -1;
        while((len = inputStream.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] bytes = bos.toByteArray();

        String replace = Arrays.toString(bytes).replace("[", "").replace("]", "");
        return replace;
    }



}
