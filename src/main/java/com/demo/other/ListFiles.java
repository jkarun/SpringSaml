package com.demo.other;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ListFiles {

	public static void main(String[] args) throws IOException {

//		new ListFiles().read();
		
		File folder = new File(
				"D:\\IFBI_Project\\IFBI_eApp\\eApp_Saml_Source\\webapp\\src\\main\\java\\org\\apache\\commons\\codec");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//System.out.println("" + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory \n" + listOfFiles[i].getAbsolutePath());
				File[] ss = new File(listOfFiles[i].getAbsolutePath()).listFiles();
				for (File f : ss) {
					System.out.println(f.getName());
				}
				System.out.println();
			}
//			
		}

	}

	private void read() throws IOException {
		Resource resource = new ClassPathResource("/saml/privatekey.txt");
		File file = resource.getFile();
		System.out.println(file.getPath());
	}

}
