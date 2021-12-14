package Modelo;

//import com.jcraft.jsch.*;
//import com.sun.jdi.connect.Transport;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
//Opcional
import javax.swing.JOptionPane;

public class SFTPServer {

    //Importar este maven
    /*
    <dependency>
<groupId>com.jcraft</groupId>
<artifactId>jsch</artifactId>
<version>0.1.54</version>
</dependency>
*/
    public SFTPServer() {



    }

    public static void envio(String ruta,String nombre){

        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "grupo07ebury@gmail.com";
            String passwordRemitente = "oumngwvfjleyutik";
            String correoReceptor = "grupo07ebury@gmail.com";
            String asunto = "Mi primero correo en Java";
            String mensaje = "Hola<br>Este es el contenido de mi primer correo desde <b>java</b><br><br>Por <b>Códigos de Programación</b>";

            BodyPart texto= new MimeBodyPart();
            texto.setText("hola caracola");

            BodyPart adjunto= new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
            adjunto.setFileName(nombre);

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            m.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");


            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);

            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(SFTPServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SFTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
