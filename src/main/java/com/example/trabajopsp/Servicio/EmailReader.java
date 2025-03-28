package com.example.trabajopsp.Servicio;

import com.example.trabajopsp.Enumerados.Estado;
import com.example.trabajopsp.Modelo.Correo;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.*;

public class EmailReader {
    private String host = "imap.gmail.com";
    private String user = "exprofesor390@gmail.com";
    private String pass = "vaex vyjf xxgw yebs";

    public List<Correo> EmailReader(){
        List<Correo> emails = new ArrayList<Correo>();
        try{
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host,user,pass);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            int i = 0;

            for(Message message : messages){
                String enunciado = message.getSubject();
                MimeMultipart multipart = (MimeMultipart) message.getContent();
                String contenido = multipart.getBodyPart(0).getContent().toString();
                Correo correo;
                if(i< 3){
                    correo = new Correo(Estado.DONE, contenido, enunciado);
                } else if (i == 4) {
                    correo = new Correo(Estado.WORK_IN_PROGRESS, contenido, enunciado);
                }else {
                    correo = new Correo(Estado.TO_BE_DONE, contenido, enunciado);
                }
                emails.add(correo);
                i++;
            }
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return emails;
    }
}