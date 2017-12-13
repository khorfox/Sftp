package it.khorfox.sftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Sftp
{
    private String destinationFolder;
    private String server;
    private String user;
    private String password;
    private String nomeFile;
    private String remoteFolder;
    private String prefix;

    public Sftp(String server, String user, String password, String destFolder)
    {
        destinationFolder = destFolder==null ||  destFolder.equals("") ? "C:\\" : destFolder;
        this.server = server;
        this.user = user;
        this.password = password;
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length < 3)
            {
                System.out.println("ERROR!");
                System.out.println("usage: java Sftp [url] [user] [pwd] [destination folder]  [file] [dir] [prefix]");
                System.exit(0);
            }
            Sftp ftp = new Sftp(args[0], args[1], args[2], args[3]);
            if(args[5] != null)
                ftp.remoteFolder = args[5];
            if(args[6] != null)
                ftp.prefix = (new StringBuilder(String.valueOf(args[6]))).append("-").toString();
            ftp.nomeFile = args[4];
            ftp.get();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void get()
        throws Exception
    {
        JSch jsch = new JSch();
        Channel channel = null;
        ChannelSftp c = null;
        int port = 22;
        Session session = jsch.getSession(user, server, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        System.out.println("Session connected.");
        System.out.println("Opening Channel.");
        channel = session.openChannel("sftp");
        channel.connect();
        c = (ChannelSftp)channel;
        System.out.println("Changing to FTP remote dir: ");
        c.cd(remoteFolder);
        System.out.println("Downloading file ");
        File dir = new File(destinationFolder);
	    if (!dir.exists() && !dir.mkdirs()) {
	        throw new IOException("Unable to create " + dir.getAbsolutePath());
	    }
       String outputFileName = (new StringBuilder(String.valueOf(destinationFolder))).append("//").append(prefix).append(nomeFile).toString();
        File f = new File(outputFileName);
        c.get(nomeFile, new FileOutputStream(f));
        System.out.println("Downloading terminato ");
        c.quit();
        System.out.println("Process Complete.");
        System.exit(0);
    }

}
