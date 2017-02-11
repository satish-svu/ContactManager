package com.example.aditya.gojek.util;

import android.content.Context;
import android.os.Environment;

import com.example.aditya.gojek.data.model.Contact;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import timber.log.Timber;

/**
 * Created by Aditya on 11-Feb-17.
 */

public class FileUtil {

    public static File createVcfFile(Context context, Contact contact) {
        String filename = Environment.getExternalStorageDirectory() + "/generated" + contact.getEmail() + ".vcf";
        Timber.d(filename);
        File vcfFile = new File(filename);
        FileWriter fw;
        try {
            fw = new FileWriter(vcfFile);
            fw.write("BEGIN:VCARD\r\n");
            fw.write("VERSION:3.0\r\n");
            fw.write("N:" + contact.getLastName() + ";" + contact.getFirstName() + "\r\n");
            fw.write("FN:" + contact.getFirstName() + " " + contact.getLastName() + "\r\n");
            fw.write("TEL;TYPE=HOME,VOICE:" + contact.getPhoneNumber() + "\r\n");
            fw.write("EMAIL;TYPE=PREF,INTERNET:" + contact.getEmail() + "\r\n");
            fw.write("END:VCARD\r\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vcfFile;
    }
}
