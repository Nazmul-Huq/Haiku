package DataHandler;

import HaikuDomain.Haiku;

import java.io.File;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class HaikuFileWriter {

    // instantiate pdfBox objects
    static PDDocument document = new PDDocument();
    static PDPage blankPage = new PDPage();


    // save newly created haiku as pdf file
    public static void saveAsPdf(Haiku haiku){
        try {

            //first extract information from haiku
            int id = haiku.getId(); // get haiku id
            String name = haiku.getName(); // get name of author
            String firstLine = haiku.getFirstLine(); // get first line of the haiku
            String middleLine = haiku.getMiddleLine(); // get middle line of the haiku
            String lastLine = haiku.getLastLine(); // get last line of the haiku
            String  dateTime = haiku.getDateTime(); // get date and time when haiku was created

            // add blank page to current document
            document.addPage(blankPage);

            // write in the document
            PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
            contentStream.setFont( new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12 );
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("Haiku Id: " + id);
            contentStream.newLine();
            contentStream.showText("Author Name: " + name);
            contentStream.newLine();
            contentStream.showText("-----------------------------");
            contentStream.newLine();
            contentStream.showText(firstLine);
            contentStream.newLine();
            contentStream.showText( middleLine);
            contentStream.newLine();
            contentStream.showText(lastLine);
            contentStream.newLine();
            contentStream.showText("-----------------------------");
            contentStream.newLine();
            contentStream.showText("Haiku was created at: " + dateTime);
            contentStream.endText();
            contentStream.close();
            document.save("HaikuFiles/PdfFiles/"+ name +"_"+ id + ".pdf");
            System.out.println("file added successfully");
        } catch (Exception e){
            System.out.println("file failed to add");
        }
    }


    // save newly created haiku in a csv file
    public void addHaikuToFile(Haiku haiku) {
        String csvFilename = "HaikuFiles/haiku.csv";
        try {
            File file = new File(csvFilename);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(haiku + "\n");
            fileWriter.close();
            System.out.println("Following Haiku has been added successfully to the file");
        } catch (Exception e) {
            System.out.println("Failed to add Haiku");
        }

    }


} // class ends here
