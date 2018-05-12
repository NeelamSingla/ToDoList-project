package NotificationUtility;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author tmp-sda-1160
 */
public class SendEmail {

    final String senderEmail = "demokth2018@gmail.com";
    final String senderPassword = "demo@2018";
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "587";
    String receiverEmail = null;
    String emailSubject = null;
    String emailBody = null;

    public SendEmail(String receiverEmail, String Subject, String message) {
        this.receiverEmail = receiverEmail;
        this.emailSubject = Subject;
        this.emailBody = message;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);

            Message msg = new MimeMessage(session);
            msg.setText(emailBody);
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmail));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmail));
            Transport.send(msg);
            System.out.println();
            System.out.println("Email notification sent successfully");
        } catch (MessagingException ex) {
            System.out.println("Error occurred while sending email.!");
        }

    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
        }
    }
}
