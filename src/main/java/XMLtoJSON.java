import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XMLtoJSON {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String fileContent;

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\t553678\\Downloads\\PrixCarburants_instantane.xml";
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        fileContent = new String(bytes);

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(fileContent);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
