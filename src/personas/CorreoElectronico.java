/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;
import java.io.Serializable;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Ana Vargas
 */
public class CorreoElectronico implements Serializable {
    private static final long serialVersionUID = 621223652324028298L;
    private  String correoCliente;//////////////////////////no puede ser estatico

    public CorreoElectronico(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    

    public void enviarCorreo(String asunto, String cuerpo){
        String remitente ="nutriFit_poo@hotmail.com";  //Para la dirección correo
        String clave = "ApG32020";
        Properties props = System.getProperties();
        System.out.println("Enviando correo...");
        props.put("mail.smtp.host", "smtp.office365.com");  //El servidor SMTP de Hotmail
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
       
        

        try {
            
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoCliente));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.office365.com", remitente, clave);
            
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
        }
        catch (MessagingException me) {
            System.err.println(me.getMessage());   //Si se produce un error
        }
    }
    
    @Override
    public String toString() {
        return correoCliente;
    }
      

}
