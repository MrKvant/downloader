package com.kazachenko;

import java.io.File;

/**
 * Created by admin on 6/15/2017.
 */

//Singletone class
public class Config {

    private static final String FLAG_L = "-L";
    private static final String FLAG_P = "-P";
    private static final String FLAG_N = "-N";
    private static final String FLAG_F = "-F";
    private static final String FLAG_T = "-T";

    private static Config uniqueInstance;

    private String url;
    private String savingPlace;
    private String savingName;
    private String linksFile;
    private Integer countThreads;

    public static Config createConfig(String[] args) {
        if (uniqueInstance == null) {
            uniqueInstance = new Config(args);
        }
        return uniqueInstance;
    }

    public static Config getConfig() {
        return uniqueInstance;
    }

    private Config(String[] args) {
        url = null;
        savingPlace = null;
        savingName = null;
        linksFile = null;
        countThreads = null;
        setFlags(args);
        checkFlags(args);
    }

    private void setFlags(String[] args) {
        try {

            for (int i = 0; i < args.length; i++)
                switch (args[i].toUpperCase()) {
                    case FLAG_L:url = args[++i];break;
                    case FLAG_P:savingPlace = args[++i];break;
                    case FLAG_N:savingName = args[++i];break;
                    case FLAG_F:linksFile = args[++i];break;
                    case FLAG_T:countThreads = Integer.parseInt(args[++i]);break;
                }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Flag is empty.");
            System.exit(0);
        }
    }

    private void checkFlags(String[] args) {
        if (countThreads != null) {
            if (countThreads > 0) {
                if (countThreads > 30) {
                    System.out.println("ERROR: Count threads can not be more than 30.");
                    System.exit(0);
                }
            } else {
                System.out.println("ERROR: Incorrect count threads.");
                System.exit(0);
            }
        } else countThreads = 1;

        if (linksFile != null){
            checkSavingPlace();
        } else if (url != null){
            countThreads =1;
            if (savingName == null){
                System.out.println("ERROR: Not specified saving name.");
                System.exit(0);
            } else checkSavingPlace();
        } else {
            System.out.println("ERROR: Not specified links file or url.");
            System.exit(0);
        }
    }

    private void checkSavingPlace(){

        if (savingPlace != null) {
            File folder = new File(savingPlace);
            if (!folder.exists()) {

                if(!folder.mkdirs()){
                    System.out.println("ERROR: Can not make dir.");
                    System.exit(0);
                }
                }
            } else {
            System.out.println("ERROR: Not specified saving place.");
            System.exit(0);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getSavingPlace() {
        return savingPlace;
    }

    public String getSavingName() {
        return savingName;
    }

    public String getLinksFile() {
        return linksFile;
    }


    public Integer getCountThreads() {
        return countThreads;
    }
}
