package it.khorfox.sftp;

import java.io.File;
import java.io.IOException;


public class Directory {

	final File homeDir = new File(System.getProperty("user.home"));
	
	private void crea(String dirName) throws Exception {
		System.out.println("creo la directory");
		System.out.println(homeDir.getName());
		File dir = new File(dirName);
		System.out.println("Esiste ? " + dir.exists());
	    if (!dir.exists() && !dir.mkdirs()) {
	        throw new IOException("Unable to create " + dir.getAbsolutePath());
	    }
		
	}
	
	public static void main(String[] args) throws Exception {
		Directory manager = new Directory();
		if((args!=null) && args.length > 0) {
			manager.crea(args[0]);
		} 
		else {
			manager.crea("C:\\Temp\\din-logs\\esercizio");
		}
	}

}
