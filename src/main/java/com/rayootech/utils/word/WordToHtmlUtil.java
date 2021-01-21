package com.rayootech.utils.word;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

@Component
public class WordToHtmlUtil {

//    @Autowired
//    private UploadFileUtil uploadFileUtil;

    /**
     * 将word2003转换为html文件
     *
     * @param input
     * @throws IOException
     * @throws TransformerException
     * @throws ParserConfigurationException
     */
    public String Word2003ToHtml(InputStream input)
            throws IOException, TransformerException, ParserConfigurationException {
        HWPFDocument wordDocument = new HWPFDocument(input);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches,
                                      float heightInches) {
//                String fileName = AliOssUtil.generateImageFileName() + suggestedName.substring(suggestedName.lastIndexOf("."));
//                return uploadFileUtil.uploadFile(content, bucket, directory, fileName, visitPoint);
                return null;
            }
        });
        // 解析word文档
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream outStream = new BufferedOutputStream(baos);
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer serializer = factory.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        String content = baos.toString();
        baos.close();
        return content;
    }

    /**
     * 2007版本word转换成html
     *
     * @param
     * @throws IOException
     */
    public static String Word2007ToHtml(MultipartFile file) throws IOException {
//    String htmlPath = "C:\\Users\\FightingHao\\Desktop\\test\\test";
//    String htmlName = wordName + ".html";
        String imagePath = "ers\\Fightintest\\test\\image" + File.separator;

//    //判断html文件是否存在
//    File htmlFile = new File(htmlPath + htmlName);
//    if(htmlFile.exists()){
//      return htmlFile.getAbsolutePath();
//    }

        // 1) 加载word文档生成 XWPFDocument对象
        InputStream input = file.getInputStream();

        XWPFDocument document = new XWPFDocument(input);

        // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
        File imgFolder = new File(imagePath);
        XHTMLOptions options = XHTMLOptions.create();
        options.setExtractor(new FileImageExtractor(imgFolder));
        //html中图片的路径 相对路径
        options.URIResolver(new BasicURIResolver("image"));
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);

//    // 3) 将 XWPFDocument转换成XHTML
//    //生成html文件上级文件夹
//    File folder = new File(htmlPath);
//    if(!folder.exists()){
//      folder.mkdirs();
//    }
//    OutputStream out = new FileOutputStream(htmlFile);
//    XHTMLConverter.getInstance().convert(document, out, options);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XHTMLConverter.getInstance().convert(document, baos, options);
        String content = baos.toString();
        baos.close();
        return content;

//    return htmlFile.getAbsolutePath();
    }

}