package Utilities;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendMail {



    public static void sendmails(String messagebody) throws MessagingException, UnknownHostException {



        GenericMail mail=new GenericMail();
        mail.sendMail(MailConfig.server,MailConfig.from,MailConfig.to,MailConfig.subject,messagebody);
    }

}
