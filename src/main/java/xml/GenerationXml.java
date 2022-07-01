package xml;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xml.globalSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerationXml {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        Document document = db.newDocument();
        // 不显示standalone="no"
        document.setXmlStandalone(true);
        Element bookstore = document.createElement("GlobalValueSet");
        bookstore.setAttribute("xmlns","http://soap.sforce.com/2006/04/metadata");
        Element description = document.createElement("description");
        description.setTextContent("州");
        bookstore.appendChild(description);
        Element masterLabel = document.createElement("masterLabel");
        masterLabel.setTextContent("州");
        bookstore.appendChild(masterLabel);
        List<globalSet> list = new ArrayList<>();
        String fileName = "C:\\Users\\Derrick\\Desktop\\test.xlsx";
        EasyExcel.read(fileName, globalSet.class, new PageReadListener<globalSet>(dataList -> {
            for (globalSet demoData : dataList) {
                list.add(demoData);
            }
        })).sheet().doRead();
        for (globalSet globalSet : list) {
            // 向bookstore根节点中添加子节点book
            Element customValue = document.createElement("customValue");
            Element fullName = document.createElement("fullName");
            fullName.setTextContent(globalSet.getApi());
            customValue.appendChild(fullName);
            Element aDefault = document.createElement("default");
            aDefault.setTextContent(String.valueOf(false));
            customValue.appendChild(aDefault);
            Element label = document.createElement("label");
            label.setTextContent(globalSet.getLabel());
            customValue.appendChild(label);
            bookstore.appendChild(customValue);
        }
        Element sorted = document.createElement("sorted");
        sorted.setTextContent(String.valueOf(false));
        bookstore.appendChild(sorted);
        document.appendChild(bookstore);
        TransformerFactory tff = TransformerFactory.newInstance();
        // 创建 Transformer对象
        Transformer tf = tff.newTransformer();

        // 输出内容是否使用换行
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        // 创建xml文件并写入内容
        tf.transform(new DOMSource(document), new StreamResult(new File("tax.globalValueSet")));
    }

}
