package com.kov.javalessons;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static void main(String[] args) throws IOException, CsvException {
        // Create a new CSV file and write data to it
        //createCsvFile();
        // Update the CSV file by adding more data
        updateCsvFile();
    }
    
    public static void createCsvFile() throws IOException {
        // Specify the CSV file path
        String csvFilePath = "example.csv";
        Charset encoding = Charset.forName("windows-1251");
        char customDelimiter = ';';
        // Create a CSV writer
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, encoding), customDelimiter, CSVWriter.NO_QUOTE_CHARACTER,
                                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                    CSVWriter.DEFAULT_LINE_END);

        // Define data to be written
        String[] data1 = {"Название категории", "URL категории", "id родительской категории", "URL родительской категории", "Описание категории", "Изображение", "Заголовок [SEO]", "Ключевые слова [SEO]", "Описание [SEO]", "SEO Описание", "Наценка", "Не выводить в меню", "Активность", "Не выгружать в YML", "Сортировка", "Внешний идентификатор", "id"};
        String[] data2 = {"Verto", "verto", "7", "mezhkomnatnye-dveri-vinnica/", "<div class='textwidget'><center><h3>О ФИРМЕ</h3></center>ООО Фабрика Дверей 'БудМайстер', один из крупнейших производителей межкомнатных дверей на территории Украины. Предприятие более 20 лет работает на рынке строительных столярных изделий, выпуская широкий ассортимент продукции под Торговой Маркой Verto. На сегодняшний день продукция Фабрики Дверей завоевала доверие покупателей на рынке межкомнатных дверей высоким качеством, современным дизайном и отличным соотношением цены – качества предлагаемой продукции.Фабрика Дверей входит в инвестиционно-производственную группу предприятий 'БудМайстер', что создает стабильную финансовую инфраструктуру Фабрики и гарантирует активное и динамичное развитие ТМ Verto на территории всей Украины и за ее пределами.</div><div class='textwidget'><center><h3>ПРОДУКЦИЯ</h3></center>Фабрика Дверей предлагает более 200 моделей межкомнатных дверей в пяти разных покрытиях с большим ассортиментом цветовой гаммы. Все модели дверей предлагаются в одностворчатом и двустворчатом исполнении, и могут быть изготовлены в нестандартных размерах.Помимо дверных полотен, Фабрика изготавливает дверные коробки, пороги, доборные планки и прочие аксессуары к дверным полотнам, обеспечивая покупателя необходимым ассортиментом при выборе продукции.Фабрика постоянно увеличивает объем производства, обновляя модельный ряд выпускаемой продукции, что делает ТМ Verto одну из наиболее прогрессирующих торговых марок в стране.</div><div class='textwidget'><h3 style='text-align: center'><span style='color: #ffffff'>КАЧЕСТВО</span></h3><p><span style='color: #ffffff'>Производство дверей базируется на применении зарубежных технологий. Автоматизированный процесс позволяет высококлассным специалистам контролировать качественные характеристики продукции на каждой стадии изготовления: от подбора материалов до получения продукции покупателем. Подтверждением этому факту является сертификат качества ISO 9001.</span><br><span style='color: #ffffff'>Продукция Фабрики дверей соответствует необходимым строительным требованиям, что подтверждается наличием сертификатов.</span></p></div><div class='panel-grid-cell' id='pgc-171-3-0'><div class='so-panel widget widget_black-studio-tinymce widget_black_studio_tinymce panel-first-child panel-last-child' id='panel-171-3-0-0' data-index='5'><div class='textwidget'><h3 style='text-align: center'>ДИСТРИБУЦИЯ</h3><p>Реализация продукции ТМ Verto осуществляется через дилерскую сеть из более 400 дилеров по территории всей Украины. Вся продукция представлена в выставочных салонах и магазинах, соответствующих требованиям ТМ Verto.<br>Фабрика Дверей постоянно развивает дилерскую сеть на территории Украины и за её приделами , а также сотрудничает с крупнейшими строительными и торговыми организациями. Благодаря активной работы дилеров с Авторизованными Магазинами, продукция ТМ Verto доступна на всей территории Украины.</p></div></div></div>", "/uploads/verto.png", "Купить межкомнатные двери Verto в Виннице", "Межкомнатные двери Verto Винница, Verto двери в Виннице, Где купить Verto межкомнатные двери в Виннице, Магазины Verto дверей Винница, Verto двери цены Винница, Межкомнатные двери Verto Винницкая область, Verto двери продажа Винница, Двери Verto каталог Винница, Verto межкомнатные двери акции Винница, Verto двери отзывы Винница", "<p><strong>Межкомнатные двери Verto</strong> - это превосходное сочетание стиля, качества и функциональности для вашего интерьера. В нашем ассортименте представлены двери, которые выделяются элегантным дизайном, разнообразием отделок и надежной конструкцией.</p><p>Независимо от ваших предпочтений, вы сможете найти идеальную дверь <strong>Verto</strong>, которая подходит к вашему интерьеру. Благодаря использованию высококачествных материалов и инновационных технологий, двери Verto обеспечивают долговечность, звукоизоляцию и защиту от влаги.</p><p>Выбирая <strong>Verto</strong>, вы инвестируете в комфорт и стиль вашего дома. Наши двери не только функциональны, но и придают вашему интерьеру утонченный вид. Переходите к <strong>Verto</strong> для того, чтобы создать идеальный дом.</p>", "<p><strong>Межкомнатные двери Verto</strong> - это превосходное сочетание стиля, качества и функциональности для вашего интерьера. В нашем ассортименте представлены двери, которые выделяются элегантным дизайном, разнообразием отделок и надежной конструкцией.</p><p>Независимо от ваших предпочтений, вы сможете найти идеальную дверь <strong>Verto</strong>, которая подходит к вашему интерьеру. Благодаря использованию высококачествных материалов и инновационных технологий, двери Verto обеспечивают долговечность, звукоизоляцию и защиту от влаги.</p><p>Выбирая <strong>Verto</strong>, вы инвестируете в комфорт и стиль вашего дома. Наши двери не только функциональны, но и придают вашему интерьеру утонченный вид. Переходите к <strong>Verto</strong> для того, чтобы создать идеальный дом.</p>", "0", "0", "1", "1", "1241", "", "1241"};

        // Write data to the CSV file
        writer.writeNext(data1);
        writer.writeNext(data2);

        // Close the writer to save the changes
        writer.close();
    }

    public static void updateCsvFile() throws IOException, CsvException {
        // Specify the CSV file path
        String csvFilePath = "example.csv";
        Charset encoding = Charset.forName("windows-1251");
        char customDelimiter = ';';
        // Create a CSV reader
        CSVReader reader = new CSVReader(new FileReader(csvFilePath, encoding));

        // Read existing data from the CSV file
        List<String[]> existingData = reader.readAll();
        reader.close();
        for(String[] items : existingData){
            for(String i : items){
                System.out.println(i);
            }
        }
        
        // Append new data
        String[] newData = {"Bob", "28"};
        existingData.add(newData);

        // Create a CSV writer to update the file
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, encoding), customDelimiter, CSVWriter.NO_QUOTE_CHARACTER,
                                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                    CSVWriter.DEFAULT_LINE_END);

        // Write the updated data back to the file
        writer.writeAll(existingData);

        // Close the writer to save the changes
        writer.close();
    }
}
