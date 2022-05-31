import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ProductsParser {
    public static void main(String[] args) throws IOException {
        //Person person = new Person("John", "Doe", "sdf");
        //System.out.println(person.toString());
        //Document document = (Document) Jsoup.connect("https://veteran-vov-vagsh.mil.ru/vov").get();
        Document document = Jsoup.connect("https://calorizator.ru/product/all").get();
        //$x(".//div/div[1]/table[2]/tbody/tr[2]/td[2]/a")[0].childNodes[0]

        //System.out.println(document);
        Elements elements = document.select("table>tbody>tr");
        //System.out.println(elements.size());

        for (Element element : elements) {
            String name = element.select("td>a").text();
            double kcal = 0;
            try {
                 kcal = Double.parseDouble(element.select(":eq(5)").text());
            }
            catch (Exception e){}
            if (!name.isEmpty())
            System.out.println(name+" "+kcal);
        }
    }
}
