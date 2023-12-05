package com.kov.javalessons;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    
    private static String csvFilePath;
    private static String charsetName;
    private static char customDelimiter;
    
    public CSV() {
        csvFilePath = "example.csv";
        charsetName = "windows-1251";
        customDelimiter = ';';
    }
    
    public CSV(String argsCsvFilePath, String argsCharsetName, char argsCustomDelimiter) {
        csvFilePath = argsCsvFilePath;
        charsetName = argsCharsetName;
        customDelimiter = argsCustomDelimiter;
    }
    
    /**
     *
     * @param data
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static void createCsvFile(List<String[]> data) throws IOException, CsvException {
        Charset encoding = Charset.forName(charsetName);
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, encoding), customDelimiter, 
                                    CSVWriter.NO_QUOTE_CHARACTER,
                                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                    CSVWriter.DEFAULT_LINE_END)) {
            writer.writeAll(data);
        }
    }
    /**
     *
     * @return resultList
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static List<String[]>readCsvFile() throws IOException, CsvException {
        List<String[]> resultList = new ArrayList<>();
        List<String[]> existingData;
        Charset encoding = Charset.forName(charsetName);
    
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath, encoding))) {
            existingData = reader.readAll();
        }
        for (String[] item : existingData){
            String joinedString = String.join(",", item);   
            resultList.add(joinedString.split(";"));    
        }
        return resultList;
    }
    /**
     *
     * @param newData
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static void updateCsvFile(String[] newData) throws IOException, CsvException {
        List<String[]> resultList;
        resultList = readCsvFile();       
        resultList.add(newData);
        createCsvFile(resultList);
    }
    /**
    * The main entry point of the Java program.
    * This method is automatically called when the program is executed.
    *
    * @param args Command-line arguments provided to the program.
    * These can be used to pass inputs to the program from the command line.
    * @throws java.io.IOException
    * @throws com.opencsv.exceptions.CsvException
    * @author olegk
    */
    public static void main(String[] args) throws IOException, CsvException {
        List<String[]> resultList = new ArrayList<>();
        String[] data1 = {"Название категории", "URL категории", "id родительской категории", "URL родительской категории", "Описание категории", "Изображение", "Заголовок [SEO]", "Ключевые слова [SEO]", "Описание [SEO]", "SEO Описание", "Наценка", "Не выводить в меню", "Активность", "Не выгружать в YML", "Сортировка", "Внешний идентификатор", "id"};
        String[] data2 = {
            "Verto", 
            "verto", 
            "7", 
            "mezhkomnatnye-dveri-vinnica/", 
            "<div class='textwidget'><center><h3>О ФИРМЕ</h3></center>ООО Фабрика Дверей 'БудМайстер', один из крупнейших производителей межкомнатных дверей на территории Украины. Предприятие более 20 лет работает на рынке строительных столярных изделий, выпуская широкий ассортимент продукции под Торговой Маркой Verto. На сегодняшний день продукция Фабрики Дверей завоевала доверие покупателей на рынке межкомнатных дверей высоким качеством, современным дизайном и отличным соотношением цены – качества предлагаемой продукции.Фабрика Дверей входит в инвестиционно-производственную группу предприятий 'БудМайстер', что создает стабильную финансовую инфраструктуру Фабрики и гарантирует активное и динамичное развитие ТМ Verto на территории всей Украины и за ее пределами.</div><div class='textwidget'><center><h3>ПРОДУКЦИЯ</h3></center>Фабрика Дверей предлагает более 200 моделей межкомнатных дверей в пяти разных покрытиях с большим ассортиментом цветовой гаммы. Все модели дверей предлагаются в одностворчатом и двустворчатом исполнении, и могут быть изготовлены в нестандартных размерах.Помимо дверных полотен, Фабрика изготавливает дверные коробки, пороги, доборные планки и прочие аксессуары к дверным полотнам, обеспечивая покупателя необходимым ассортиментом при выборе продукции.Фабрика постоянно увеличивает объем производства, обновляя модельный ряд выпускаемой продукции, что делает ТМ Verto одну из наиболее прогрессирующих торговых марок в стране.</div><div class='textwidget'><h3 style='text-align: center'><span style='color: #ffffff'>КАЧЕСТВО</span></h3><p><span style='color: #ffffff'>Производство дверей базируется на применении зарубежных технологий. Автоматизированный процесс позволяет высококлассным специалистам контролировать качественные характеристики продукции на каждой стадии изготовления: от подбора материалов до получения продукции покупателем. Подтверждением этому факту является сертификат качества ISO 9001.</span><br><span style='color: #ffffff'>Продукция Фабрики дверей соответствует необходимым строительным требованиям, что подтверждается наличием сертификатов.</span></p></div><div class='panel-grid-cell' id='pgc-171-3-0'><div class='so-panel widget widget_black-studio-tinymce widget_black_studio_tinymce panel-first-child panel-last-child' id='panel-171-3-0-0' data-index='5'><div class='textwidget'><h3 style='text-align: center'>ДИСТРИБУЦИЯ</h3><p>Реализация продукции ТМ Verto осуществляется через дилерскую сеть из более 400 дилеров по территории всей Украины. Вся продукция представлена в выставочных салонах и магазинах, соответствующих требованиям ТМ Verto.<br>Фабрика Дверей постоянно развивает дилерскую сеть на территории Украины и за её приделами , а также сотрудничает с крупнейшими строительными и торговыми организациями. Благодаря активной работы дилеров с Авторизованными Магазинами, продукция ТМ Verto доступна на всей территории Украины.</p></div></div></div>", 
            "/uploads/verto.png", 
            "Купить межкомнатные двери Verto в Виннице", 
            "Межкомнатные двери Verto Винница, Verto двери в Виннице, Где купить Verto межкомнатные двери в Виннице, Магазины Verto дверей Винница, Verto двери цены Винница, Межкомнатные двери Verto Винницкая область, Verto двери продажа Винница, Двери Verto каталог Винница, Verto межкомнатные двери акции Винница, Verto двери отзывы Винница", 
            "<p><strong>Межкомнатные двери Verto</strong> - это превосходное сочетание стиля, качества и функциональности для вашего интерьера. В нашем ассортименте представлены двери, которые выделяются элегантным дизайном, разнообразием отделок и надежной конструкцией.</p><p>Независимо от ваших предпочтений, вы сможете найти идеальную дверь <strong>Verto</strong>, которая подходит к вашему интерьеру. Благодаря использованию высококачествных материалов и инновационных технологий, двери Verto обеспечивают долговечность, звукоизоляцию и защиту от влаги.</p><p>Выбирая <strong>Verto</strong>, вы инвестируете в комфорт и стиль вашего дома. Наши двери не только функциональны, но и придают вашему интерьеру утонченный вид. Переходите к <strong>Verto</strong> для того, чтобы создать идеальный дом.</p>", 
            "<p><strong>Межкомнатные двери Verto</strong> - это превосходное сочетание стиля, качества и функциональности для вашего интерьера. В нашем ассортименте представлены двери, которые выделяются элегантным дизайном, разнообразием отделок и надежной конструкцией.</p><p>Независимо от ваших предпочтений, вы сможете найти идеальную дверь <strong>Verto</strong>, которая подходит к вашему интерьеру. Благодаря использованию высококачествных материалов и инновационных технологий, двери Verto обеспечивают долговечность, звукоизоляцию и защиту от влаги.</p><p>Выбирая <strong>Verto</strong>, вы инвестируете в комфорт и стиль вашего дома. Наши двери не только функциональны, но и придают вашему интерьеру утонченный вид. Переходите к <strong>Verto</strong> для того, чтобы создать идеальный дом.</p>", 
            "0", 
            "0", 
            "1", 
            "1", 
            "1241", 
            "", 
            "1241"
        };
        String[] newData = {
            "НСД Двери", 
            "nds-dveri", 
            "7", 
            "mezhkomnatnye-dveri-vinnica/", 
            "Фабрику 'НСД ДВЕРИ' создано в 2009 году в городе Новгород-Северском (Черниговская область, Украина). С момента создания предприятие преодолело путь от производства локального масштаба к одному из самых быстро прогрессирующих производителей межкомнатных дверей на территории Украины.<br />Благодаря высокому качеству, экологичности и современному дизайну нашей продукции за девять лет работы на рынке межкомнатных дверей мы завоевали доверие своих покупателей, к каждому из которых обеспечивается индивидуальный подход.<br />Качество нашей продукции всегда соответствует высоким стандартам, ведь производство дверей - наша любимая дело.<br />Мы заботимся о том, чтобы наши клиенты получали только лучшее и работаем над разработкой новых моделей, форм и декоров, которые в результате совместной слаженной работы профессиональной команды фабрики 'НСД ДВЕРИ' воплощаются в жизнь с целью создания уникальных, гармоничных и функциональных интерьеров в домах наших покупателей.<br />Сейчас базовая коллекция межкомнатных шпонированных дверей, производимых компанией 'НСД ДВЕРИ', насчитывает более чем 150 моделей и их модификаций, а палитра цветов - более 50 оттенков. Кроме того, по желанию покупателя, в выбранных им моделей мы можем внести конструктивные изменения, изготовить любое дверное полотно в нестандартном размере, откорректировать базовый вид полотна.<br />Существенным является то, что кроме дверных полотен наша фабрика производит дверные коробки, фрамуги, стеновые панели, отборные планки и другие аксессуары, обеспечивая тем самым своих покупателей необходимым ассортиментом сопутствующей продукции при выборе наших межкомнатных дверей.<br />Сегодня фабрика 'НСД ДВЕРИ' продолжает неуклонно наращивать свои производственные мощности и совершенствовать техническую базу. Мы постоянно работаем над расширением дилерской сети и открыты для сотрудничества на долговременной основе со всеми заинтересованными лицами.<br /><br />ПРОДУКЦИЯ<br />Фабрика 'НСД ДВЕРИ' является одним из крупнейших производителей межкомнатных дверей на территории Украины.<br />Базовая коллекция моделей межкомнатных шпононованих дверей, которые мы производим, сегодня насчитывает более 150 эргономических моделей и их модификаций, каждая из которых, в свою очередь, может быть изготовлена в какой - либо из цветов палитры, которая сейчас насчитывает более чем 50 оттенков.<br />Наши специалисты постоянно работают над расширением модельного ряда с учетом пожеланий наших покупателей и актуальных тенденций в дизайне интерьеров.<br />КАЧЕСТВО<br />Мы национальный производитель. При этом, заботясь о том, чтобы наши покупатели получали только лучшее, в своей работе мы также применяем ряд прогрессивных иностранных технологий. Автоматизированный процесс производства позволяет квалифицированным и опытным специалистам контролировать качество продукции на каждом этапе изготовления.<br />В нашем деле для нас не существует мелочей, и, как настоящие мастера своего дела, мы обеспечиваем профессиональный подход ко всему, что связано с производством нашей продукции, начиная от подбора материалов и сырья и заканчивая доставкой готовой продукции к покупателям.<br />Именно поэтому наши двери имеют высокое качество, а наше предприятие - репутацию производителя высококачественных дверей, которая является для нас одной из высших ценностей.",
            "/uploads/cat_brand_nds.jpg", 
            "Купить шпонированные двери НДС в Виннице", 
            "НДС Двери, НДС Двери, шпонированные двери, купить двери в Виннице", 
            "Вы можете купить межкомнатные двери НСД в Виннице по доступным ценам магазин DOOR IN ул. Замостянская 25.",
            "<div class='table-wrapper'></div>",
            "1,5",
            "0",
            "1",
            "1",
            "68",
            "",
            "68"
        };
        resultList.add(data1);
        resultList.add(data2);
        createCsvFile(resultList);
        updateCsvFile(newData);
    }
}
