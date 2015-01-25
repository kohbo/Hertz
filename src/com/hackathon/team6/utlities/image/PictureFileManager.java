package com.hackathon.team6.utlities.image;

import android.net.Uri;
import android.os.Environment;

import java.io.File;

/**
 * Created by Colin on 1/24/2015.
 */
public class PictureFileManager {

    private static final String APP_NAME = "Quick Assess";

    public static String getDir(){
        return  Environment.getExternalStorageDirectory().toString() + File.separator +
                APP_NAME + File.separator + "temp" + File.separator;
    }

    public static boolean clearAppDir() {
        File dir = new File(getDir());
        return deleteDirectory(dir);
    }

    public static boolean deleteDirectory(File dir){
        if( dir.exists() ) {
            File[] files = dir.listFiles();
            if (files == null) {
                return( dir.delete() );
            }
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                }
                else {
                    files[i].delete();
                }
            }
        }
        return( dir.delete() );
    }

}
