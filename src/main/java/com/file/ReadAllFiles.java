package com.file;

import java.io.File;

public class ReadAllFiles {

    // used for personal work, to list out files and add to conf. (.nsi file)
    public static void main(String[] args) {
        File folder = new File("D:\\Project Related\\Repository\\TruVu\\packages\\MahApps.Metro.IconPacks.3.0.0\\lib\\net47");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".xml")) {
                System.out.println("File \"${PRODUCT_FOLDER}\\" + listOfFiles[i].getName()+"\"");
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

}
