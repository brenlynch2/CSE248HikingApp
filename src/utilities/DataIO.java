package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataIO {
	public static BackupContainer loadContainer() {
		File inputBackup = new File("backup.dat");
		ObjectInputStream datReader;
		BackupContainer loadedContainer;
		try {
			datReader =  new ObjectInputStream(new FileInputStream(inputBackup));
			loadedContainer = (BackupContainer) datReader.readObject();
			datReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return new BackupContainer();
		}
		return loadedContainer;
	}
	public static void saveContainer(BackupContainer inputContainer) {
		File inputBackup = new File("backup.dat");
		if(inputBackup.exists()) {
			try {
				inputBackup.delete();
				inputBackup.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} 	
		ObjectOutputStream writer;
		try {
			writer = new ObjectOutputStream(new FileOutputStream(inputBackup));
			writer.writeObject(inputContainer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
