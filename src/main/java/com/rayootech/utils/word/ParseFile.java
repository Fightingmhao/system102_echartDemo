package com.rayootech.utils.word;

import java.io.*;


public class ParseFile {

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\T阿文\\Desktop\\候振宣(1).doc");
//        System.out.println(readHtml(file));
////        readHtml(file);
    }

    /**
     * 解析html文件
     *
     * @param inputStream
     * @return
     */
    public static String readHtml(InputStream inputStream) {
        String body = "";
        try {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader htmlReader = new BufferedReader(reader);

            String line;
            boolean found = false;
//            while (!found && (line = htmlReader.readLine()) != null) {
//                if (line.toLowerCase().indexOf("<body") != -1) { // 在<body>的前面可能存在空格
//                    found = true;
//                }
//            }

//            found = false;
            while ( (line = htmlReader.readLine()) != null) {
                if (line.contains("智联招聘")) {
                    line = line.replace("智联招聘", "");
                }
                // 如果存在图片，则将相对路径转换为绝对路径
                String lowerCaseLine = line.toLowerCase();
                //
                if(found&&line.contains(">")){
                    String[] split = line.split(">");
                    line = split[1].replace(">","");
                    found = false;
                }
                if (lowerCaseLine.contains("<img")) {
                    //1、
                    String[] split = line.split("<img");
                    if (split[1].contains(">")) {
                        String[] split1 = split[1].split(">");
                        line = split[0] + split1[1].replace(">","");
                    }else {
                        line = split[0];
                        found = true;
                    }
                }

                body = body + line + "\n";
            }
            htmlReader.close();
            //        System.out.println(body);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * @param htmlLine 一行html片段，包含<img>元素
     * @return 文件名
     */
    public static String extractFilename(String htmlLine) {
        int srcIndex = htmlLine.toLowerCase().indexOf("src=");
        if (srcIndex == -1) { // 图片不存在，返回空字符串
            return "";
        } else {
            String htmlSrc = htmlLine.substring(srcIndex + 4);
            char splitChar = '\"'; // 默认为双引号，但也有可能为单引号
            if (htmlSrc.charAt(0) == '\'') {
                splitChar = '\'';
            }
            String[] firstSplit = htmlSrc.split(String.valueOf(splitChar));
            String path = firstSplit[1]; // 第0位为空字符串
            String[] secondSplit = path.split("[/\\\\]"); // 匹配正斜杠或反斜杠
            return secondSplit[secondSplit.length - 1];
        }
    }

}