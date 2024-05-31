package com.srs.backend;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

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
        String pdfName = "samplePdf.pdf";
        Document myPDFDoc = new Document(PageSize.A4,
                40f,   // left
                40f,   // right
                50f,  // top
                50f); // down

        String myContantTitle = "My Contact";
        String email = "email:" + user.getEmail();
        String phone = "phone:" + user.getPhone();
        String facebook = "facebook:" + user.getFacebook();

        String tangiblesTitle = "Tangibles";
        String highLight = "HighLight:" + user.getHighLight();
        String weight = "Weight:" + String.valueOf(user.getWeight());
        String height = "Forty:" + String.valueOf(user.getHeight());

        String speed = "Speed:" + String.valueOf(user.getSpeed());
        String squat = "Squat:" + String.valueOf(user.getSquat());

        String aboutMeTitle = "About Me";
        String aboutMeText = user.getAboutMe();

        String acedemicsTitle = "Acedemics";
        String act = "Act:" + String.valueOf(user.getAct());
        String gpa = "Gpa:" + String.valueOf(user.getGpa());
        String sat = "Sat:" + String.valueOf(user.getSat());
        String instagram = "Instagram:" + String.valueOf(user.getInstagram());
        String bench = "Bench:" + String.valueOf(user.getBench());
        String broadJump = "BroadJump:" + String.valueOf(user.getBroadJump());
        String forty = "Forty:" + String.valueOf(user.getForty());
        String fortyLazer = "FortyLazer:" + String.valueOf(user.getFortyLazer());


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
            FileOutputStream pdfOutputFile = new FileOutputStream("./" + pdfName);

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

            File file = new File("./" + pdfName);
            byte[] pdfBytes = FileUtils.readFileToByteArray(file);

            return pdfBytes;

        } catch (IOException de) {
            System.err.println(de.getMessage());
        }

        return new byte[0];
    }


    public static void sendEmail(String to) {

        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title></title><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=1\"><style type=\"text/css\">td{box-sizing:border-box;border-collapse:collapse}tr{box-sizing:border-box;border-collapse:collapse}th{box-sizing:border-box;border-collapse:collapse}table{box-sizing:border-box;border-collapse:collapse}.previewText{display:none;font-size:0;line-height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;visibility:hidden}@media screen and (max-width:480px){.mB,tbody,td,tr{display:block}.fixedTable tbody{display:table-row-group}.fixedTable tr{display:table-row}.fixedTable td{display:table-cell}#templateColumns{width:100%!important}.templateColumnContainer{width:100%!important;width:100%;max-width:100%!important;display:block!important;display:block}.sFW{width:100%!important;width:100%;max-width:100%!important}.columnImage{height:auto!important;max-width:480px!important;width:100%!important}.leftColumnContent{font-size:16px!important;line-height:125%!important}.rightColumnContent{font-size:16px!important;line-height:125%!important}img{max-width:100%!important}}</style></head><body topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" bgcolor=\"#F9F9F9\" style=\"margin:0;padding:0;font-family:'Helvetica Neue',Helvetica,Helvetica,Arial,sans-serif;-webkit-font-smoothing:antialiased;-webkit-text-size-adjust:none;height:100%;width:100%!important;background-color:#f9f9f9\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\"templateColumns\" style=\"margin:0 auto;text-align:left;background-color:#f9f9f9\"><tbody><tr align=\"center\" style=\"display:block;padding:0;background-color:#fff\"><td align=\"center\" style=\"display:block;overflow:hidden;background-color:#fff;border-color:#000;padding:0 0 20px 0;width:640px\" class=\"sFW\"><table width=\"640\" style=\"display:block;width:640px;padding:0 0 10px 0\" class=\"sFW\"><tbody><tr valign=\"top\" class=\"sFW\" style=\"display:block;overflow:hidden;padding:0 25px 0 25px\"><th style=\"vertical-align:top;padding:5px 5px 5px 5px;width:590px\" class=\"templateColumnContainer\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;display:table;border-collapse:separate;overflow:hidden;flex-grow:1;border-color:#000\" class=\"sFW\"><tbody><tr><td style><table width=\"100%\"><tbody><tr><td style=\"font-weight:700;display:block;line-height:1.5;font-size:34px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641;padding:10px 0 10px 0;margin:0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:700;display:block;line-height:1.5;font-size:34px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641\">Welcome To Hiddenathletes!</p></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:18px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641;padding:0 0 0;margin:0 0 5px 0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:18px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641\">Hidden Athletes is a professional organization dedicated to providing parents, coaches.</p></td></tr></tbody></table></td></tr></tbody></table></th></tr></tbody></table></td></tr><tr align=\"center\" style=\"display:block;padding:0 0 60px 0;background-color:#fff\"><td align=\"center\" style=\"display:block;overflow:hidden;background-color:#fff;border-color:#000;border-radius:0;padding:0;width:640px\" class=\"sFW\"><table width=\"640\" style=\"display:block;width:640px;padding:0 30px 0 30px\" class=\"sFW\"><tbody><tr valign=\"top\" class=\"sFW\" style=\"display:block;overflow:hidden;border-color:#000;padding:14px 20px 22px 20px;background-color:#122641;border-radius:12px 12px 12px 12px\"><th style=\"vertical-align:top;padding:5px 5px 5px 5px;width:540px\" class=\"templateColumnContainer\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;display:table;border-collapse:separate;overflow:hidden;flex-grow:1;border-color:#000\" class=\"sFW\"><tbody><tr><td style><table width=\"100%\"><tbody><tr><td style=\"margin:0;text-align:center;display:block;overflow:hidden;padding:0\" valign=\"top\" align=\"center\"><img src=\"https://img.pblc.it/i/300x180x9.f.DO/538a5/65a5325dd91e44eb8fe8abeb_lightbulb-4.png\" width=\"60\" class style=\"vertical-align:middle;box-sizing:border-box;border-color:#000\"></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:14px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff;padding:0;margin:0 0 5px 0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:14px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff\">Thanks for signing up. Click the link below to confirm your subscription and we'll keep you updated with the latest updates.&nbsp;</p></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:21px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff;padding:12px 0 12px 0;margin:0;border-color:#000\" valign=\"top\" align=\"center\"><h2 style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:21px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff\"><a href=\"https://test.hiddenathletes.com/about-us/\" style=\"text-decoration:none;color:inherit\" target=\"_blank\"><a href=\"https://test.hiddenathletes.com/sign-up-success?name="+to+"\" style=\"text-decoration:none;color:#3498db\">Confirm your&nbsp;subscription</a></a></h2></td></tr></tbody></table></td></tr></tbody></table></th></tr></tbody></table></td></tr><table width=\"100%\"><tbody><tr><td align=\"center\" style=\"padding:20px\"></td></tr></tbody></table></tbody></table></body></html>";
        String subject = "Hiddenathletes Subscription";

        // Set up properties for the mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Your email credentials
        final String username = "support@hiddenathletes.com";
        final String password = "ehpiylnwvyzydkou";

        // Get the default Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(username));

            // Set To: header field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setContent(content, "text/html");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        // Example usage
//
//        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title></title><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=1\"><style type=\"text/css\">td{box-sizing:border-box;border-collapse:collapse}tr{box-sizing:border-box;border-collapse:collapse}th{box-sizing:border-box;border-collapse:collapse}table{box-sizing:border-box;border-collapse:collapse}.previewText{display:none;font-size:0;line-height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;visibility:hidden}@media screen and (max-width:480px){.mB,tbody,td,tr{display:block}.fixedTable tbody{display:table-row-group}.fixedTable tr{display:table-row}.fixedTable td{display:table-cell}#templateColumns{width:100%!important}.templateColumnContainer{width:100%!important;width:100%;max-width:100%!important;display:block!important;display:block}.sFW{width:100%!important;width:100%;max-width:100%!important}.columnImage{height:auto!important;max-width:480px!important;width:100%!important}.leftColumnContent{font-size:16px!important;line-height:125%!important}.rightColumnContent{font-size:16px!important;line-height:125%!important}img{max-width:100%!important}}</style></head><body topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" bgcolor=\"#F9F9F9\" style=\"margin:0;padding:0;font-family:'Helvetica Neue',Helvetica,Helvetica,Arial,sans-serif;-webkit-font-smoothing:antialiased;-webkit-text-size-adjust:none;height:100%;width:100%!important;background-color:#f9f9f9\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\"templateColumns\" style=\"margin:0 auto;text-align:left;background-color:#f9f9f9\"><tbody><tr align=\"center\" style=\"display:block;padding:0;background-color:#fff\"><td align=\"center\" style=\"display:block;overflow:hidden;background-color:#fff;border-color:#000;padding:0 0 20px 0;width:640px\" class=\"sFW\"><table width=\"640\" style=\"display:block;width:640px;padding:0 0 10px 0\" class=\"sFW\"><tbody><tr valign=\"top\" class=\"sFW\" style=\"display:block;overflow:hidden;padding:0 25px 0 25px\"><th style=\"vertical-align:top;padding:5px 5px 5px 5px;width:590px\" class=\"templateColumnContainer\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;display:table;border-collapse:separate;overflow:hidden;flex-grow:1;border-color:#000\" class=\"sFW\"><tbody><tr><td style><table width=\"100%\"><tbody><tr><td style=\"font-weight:700;display:block;line-height:1.5;font-size:34px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641;padding:10px 0 10px 0;margin:0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:700;display:block;line-height:1.5;font-size:34px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641\">Welcome To Hiddenathletes!</p></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:18px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641;padding:0 0 0;margin:0 0 5px 0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:18px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#122641\">Hidden Athletes is a professional organization dedicated to providing parents, coaches.</p></td></tr></tbody></table></td></tr></tbody></table></th></tr></tbody></table></td></tr><tr align=\"center\" style=\"display:block;padding:0 0 60px 0;background-color:#fff\"><td align=\"center\" style=\"display:block;overflow:hidden;background-color:#fff;border-color:#000;border-radius:0;padding:0;width:640px\" class=\"sFW\"><table width=\"640\" style=\"display:block;width:640px;padding:0 30px 0 30px\" class=\"sFW\"><tbody><tr valign=\"top\" class=\"sFW\" style=\"display:block;overflow:hidden;border-color:#000;padding:14px 20px 22px 20px;background-color:#122641;border-radius:12px 12px 12px 12px\"><th style=\"vertical-align:top;padding:5px 5px 5px 5px;width:540px\" class=\"templateColumnContainer\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;display:table;border-collapse:separate;overflow:hidden;flex-grow:1;border-color:#000\" class=\"sFW\"><tbody><tr><td style><table width=\"100%\"><tbody><tr><td style=\"margin:0;text-align:center;display:block;overflow:hidden;padding:0\" valign=\"top\" align=\"center\"><img src=\"https://img.pblc.it/i/300x180x9.f.DO/538a5/65a5325dd91e44eb8fe8abeb_lightbulb-4.png\" width=\"60\" class style=\"vertical-align:middle;box-sizing:border-box;border-color:#000\"></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:14px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff;padding:0;margin:0 0 5px 0;border-color:#000\" valign=\"top\" align=\"center\"><p style=\"margin:0;padding:0\" style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:14px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff\">Thanks for signing up. Click the link below to confirm your subscription and we'll keep you updated with the latest updates.&nbsp;</p></td></tr></tbody></table><table width=\"100%\"><tbody><tr><td style=\"font-weight:400;display:block;line-height:1.5;font-size:21px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff;padding:12px 0 12px 0;margin:0;border-color:#000\" valign=\"top\" align=\"center\"><h2 style=\"width:100%;margin:0;padding:0;font-weight:400;display:block;line-height:1.5;font-size:21px;text-align:center;font-family:helvetica,arial,verdana,sans-serif;color:#fff\"><a href=\"https://test.hiddenathletes.com/about-us/\" style=\"text-decoration:none;color:inherit\" target=\"_blank\"><a href=\"https://test.hiddenathletes.com/sign-up-success?var1=@variable1\" style=\"text-decoration:none;color:#3498db\">Confirm your&nbsp;subscription</a></a></h2></td></tr></tbody></table></td></tr></tbody></table></th></tr></tbody></table></td></tr><table width=\"100%\"><tbody><tr><td align=\"center\" style=\"padding:20px\"></td></tr></tbody></table></tbody></table></body></html>";
//
//        sendEmail("bm.bilgic@gmail.com");
//    }

}
