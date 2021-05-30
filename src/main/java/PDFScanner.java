import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PDFScanner {

    public static void main(String[] args) throws IOException {
        System.out.println("what are you looking for?");
        Scanner scan = new Scanner(System.in);
        String searching = scan.next();
        System.out.println("input file path");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();

        File file = new File(filePath);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        String[] split = text.split(" ");

        for(int i=0; i < split.length; i++)
        {
            if(split[i].toLowerCase().equals(searching)) {
                String firstName = split[i + 1];
                String lastName = split[i + 2];
                firstName=firstName.replace("\n", "");
                lastName=lastName.replace("\n", "");
                System.out.println(firstName + " " + lastName);
            }
        }

        document.close();
    }
}