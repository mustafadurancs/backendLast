package com.srs.backend;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.MultiColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.srs.backend.model.School;
import com.srs.backend.model.Users;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Mustafa BILGIC
 * @created 27/05/2023
 * @project KARGO DROP
 */
public class SRSUtil {

    public static byte[] createPDF(Users user, List<School> schoolsByParameters) {
        String pdfName="samplePdf.pdf";
        Document myPDFDoc = new Document(PageSize.A4,
                40f,   // left
                40f,   // right
                50f,  // top
                50f); // down

        String myContantTitle = "My Contact";
        String email = "email:" + user.getEmail();
        String phone = "phone:" +user.getPhone();
        String facebook = "facebook:" +user.getFacebook();

        String tangiblesTitle = "Tangibles";
        String highLight = "HighLight:"+user.getHighLight();
        String weight = "Weight:"+String.valueOf(user.getWeight());
        String height = "Forty:"+String.valueOf(user.getHeight());

        String speed = "Speed:"+String.valueOf(user.getSpeed());
        String squat = "Squat:"+String.valueOf(user.getSquat());

        String aboutMeTitle = "About Me";
        String aboutMeText = user.getAboutMe();

        String acedemicsTitle = "Acedemics";
        String act = "Act:"+String.valueOf(user.getAct());
        String gpa = "Gpa:"+String.valueOf(user.getGpa());
        String sat = "Sat:"+String.valueOf(user.getSat());
        String instagram = "Instagram:"+String.valueOf(user.getInstagram());
        String bench = "Bench:"+String.valueOf(user.getBench());
        String broadJump = "BroadJump:"+String.valueOf(user.getBroadJump());
        String forty = "Forty:"+String.valueOf(user.getForty());
        String fortyLazer = "FortyLazer:"+String.valueOf(user.getFortyLazer());


        String seniorYearTitle = "Senior Year";
        String senior = user.getSeniorYear();

        String juniorYearTitle = "Junior Year";
        String junior = user.getJuniorYear();

        String schoolsTitle = "List Of School";
        // Define a string as title
        String title = "Hidden Athlete Profile";

        //1) Let's create a Table object
        Table myTable = new Table(5); // 3 columns
        myTable.setPadding(2f);
        myTable.setSpacing(1f);
        myTable.setWidth(100f);

        //2) Create the header of the table
        ArrayList<String> headerTable = new ArrayList<>();
        headerTable.add("schoolName");
        headerTable.add("city");
        headerTable.add("state");
        headerTable.add("type");
        headerTable.add("region");

        headerTable.forEach(e -> {
            Cell current = new Cell(new Phrase(e));
            current.setHeader(true);
            current.setBackgroundColor(Color.LIGHT_GRAY);
            myTable.addCell(current);
        });

        // 3) Then create a list of rows and add them to the table
        LinkedHashMap<Integer, List<String>> listRows = new LinkedHashMap<>();

//        Object[] namesArray = user.getSchools().toArray();
//        for (int i = 0; i < namesArray.length; i++) {
//            School school = (School) namesArray[i];
//            listRows.put(i, Arrays.asList(school.getSchool(), school.getCity(), school.getState(), school.getType(), school.getRegion()));
//            System.out.println(i + ": " + namesArray[i]);
//        }


        for (int i = 0; i < schoolsByParameters.size(); i++) {
            listRows.put(i, Arrays.asList(schoolsByParameters.get(i).getSchool(), schoolsByParameters.get(i).getCity(), schoolsByParameters.get(i).getState(), schoolsByParameters.get(i).getType(), schoolsByParameters.get(i).getRegion()));
        }


        listRows.forEach((index, userDetailRow) -> {
            String schoolName = userDetailRow.get(0);
            String city = userDetailRow.get(1);
            String state = userDetailRow.get(2);
            String type = userDetailRow.get(3);
            String region = userDetailRow.get(4);

            myTable.addCell(new Cell(new Phrase(schoolName)));
            myTable.addCell(new Cell(new Phrase(city)));
            myTable.addCell(new Cell(new Phrase(state)));
            myTable.addCell(new Cell(new Phrase(type)));
            myTable.addCell(new Cell(new Phrase(region)));

        });


        try {
            FileOutputStream pdfOutputFile = new FileOutputStream("./"+pdfName);

            final PdfWriter pdfWriter = PdfWriter.getInstance(myPDFDoc, pdfOutputFile);
            pdfWriter.setPageEvent(new PdfPageEventHelper() {
                @Override
                public void onEndPage(PdfWriter writer, Document document) {
                    PdfContentByte cb = writer.getDirectContent();
//                    cb.rectangle(header);
//                    cb.rectangle(footer);
                }
            });

            myPDFDoc.open();  // Open the Document
            // Create a Font object
            Font titleFont = new Font(Font.COURIER, 12f, Font.BOLDITALIC, Color.getHSBColor(19, 142, 148));

            // Create a paragraph with the new font
            Paragraph paragraph = new Paragraph(title, titleFont);

            // Element class provides properties to align
            // Content elements within the document
            paragraph.setAlignment(Element.ALIGN_CENTER);

            myPDFDoc.add(paragraph);

            // Adding an empty line
            myPDFDoc.add(new Paragraph(Chunk.NEWLINE));

            // Include the text as content of the pdf
//            myPDFDoc.add(new Paragraph(lorenIpsum1));
            MultiColumnText mct = new MultiColumnText();
            mct.setColumnsRightToLeft(false);
            mct.addRegularColumns(myPDFDoc.left(), myPDFDoc.right(), 40f, 2);


            mct.addElement(new Paragraph(myContantTitle, titleFont));


            mct.addElement(new Paragraph(phone));
            mct.addElement(new Paragraph(email));
            mct.addElement(new Paragraph(facebook));

            mct.addElement(new Paragraph(aboutMeTitle, titleFont));
            mct.addElement(new Paragraph(aboutMeText));


            mct.addElement(new Paragraph(tangiblesTitle, titleFont));
            mct.addElement(new Paragraph(height));
            mct.addElement(new Paragraph(highLight));
            mct.addElement(new Paragraph(speed));
            mct.addElement(new Paragraph(squat));

            mct.addElement(new Paragraph(instagram));
            mct.addElement(new Paragraph(bench));
            mct.addElement(new Paragraph(broadJump));
            mct.addElement(new Paragraph(forty));
            mct.addElement(new Paragraph(fortyLazer));



            mct.addElement(new Paragraph(acedemicsTitle, titleFont));
            mct.addElement(new Paragraph(act));
            mct.addElement(new Paragraph(sat));
            mct.addElement(new Paragraph(gpa));

            mct.addElement(new Paragraph(seniorYearTitle, titleFont));
            mct.addElement(new Paragraph(senior));


            mct.addElement(new Paragraph(juniorYearTitle, titleFont));
            mct.addElement(new Paragraph(junior));


            mct.addElement(new Paragraph(myContantTitle, titleFont));
            mct.addElement(new Paragraph(phone));
            mct.addElement(new Paragraph(email));
            mct.addElement(new Paragraph(facebook));

            mct.addElement(new Paragraph(aboutMeTitle, titleFont));
            mct.addElement(new Paragraph(aboutMeText));


            mct.addElement(new Paragraph(tangiblesTitle, titleFont));
            mct.addElement(new Paragraph(height));
            mct.addElement(new Paragraph(weight));


            mct.addElement(new Paragraph(acedemicsTitle, titleFont));
            mct.addElement(new Paragraph(act));
            mct.addElement(new Paragraph(sat));
            mct.addElement(new Paragraph(gpa));

            mct.addElement(new Paragraph(seniorYearTitle, titleFont));
            mct.addElement(new Paragraph(senior));


            mct.addElement(new Paragraph(juniorYearTitle, titleFont));
            mct.addElement(new Paragraph(junior));


            // 4)Finally add the table to the document
            myPDFDoc.add(mct);
            myPDFDoc.add(new Paragraph(schoolsTitle, titleFont));
            myPDFDoc.add(myTable);


            myPDFDoc.close();
            pdfWriter.close();

            File file = new File("./"+pdfName);
            byte[] pdfBytes = FileUtils.readFileToByteArray(file);

            return pdfBytes;

        } catch (IOException de) {
            System.err.println(de.getMessage());
        }

        return new byte[0];
    }

}
