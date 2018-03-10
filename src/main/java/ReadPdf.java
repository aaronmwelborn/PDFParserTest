import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class ReadPdf {

    public static void main(String[] args) throws IOException {

        try (PDDocument document = PDDocument.load(new File(args[0]))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                // split by whitespace
//                String lines[] = pdfFileInText.split("\\r?\\n");
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    if (line.contains(args[1])){
                        System.out.println(line);
                        break;
                    } else if (line.equals(lines[lines.length-1])){
                        System.out.println("The provided ID does not exist in this document.");
                    }
                }

            }

        }

    }
}