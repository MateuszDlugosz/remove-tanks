package remove.tanks.game.utility.xml;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Mateusz Długosz
 */
public final class XmlFormatter {
    public String formatXmlString(String xml) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml)));

            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            format.setIndent(2);
            format.setOmitXMLDeclaration(false);
            format.setLineWidth(Integer.MAX_VALUE);
            Writer outxml = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(outxml, format);
            serializer.serialize(doc);

            return outxml.toString();
        } catch (Exception e) {
            throw new XmlFormattingException(xml, e);
        }
    }
}
