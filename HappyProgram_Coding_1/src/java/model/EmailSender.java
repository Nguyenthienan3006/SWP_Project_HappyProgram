package model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    String otp;

    public String getOtp() {
        return otp;
    }
    
    public void sendOTP(String emailAddress) {
        // Cấu hình thông tin email và máy chủ SMTP
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "havietdanh1810@gmail.com";
        String password = "ixsgcnlvlgxqtrjn";

        // Thông tin người nhận và nội dung email
        String toAddress = emailAddress;
        String subject = "OTP Confirmation";
        otp = OTPGenerator.generateOTP();
        String body = "Your OTP is: " + otp;

        // Thiết lập các thuộc tính cần thiết cho máy chủ SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo một phiên làm việc (session) với máy chủ SMTP
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // Tạo một tin nhắn email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(body);

            // Gửi email
            Transport.send(message);

            // TODO: Lưu mã OTP vào cơ sở dữ liệu để xác nhận sau này
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
