/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultPkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */
public class FileIO { 
    
    static String fileName = "foo";
    
    public FileIO(String s) {
        fileName = s;
    }
    
    static void rmLine(String s, ArrayList<String> arr) {
        arr.remove(s);
    }
    static void SOP(String s) {
        System.out.println(s);
    }
    
    static void dumpToFile(ArrayList<String> array) {
        boolean success = false;
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
            
            int k = 0;
            while (k < array.size()) {
                fw.write(array.get(k));
                SOP(array.get(k));
                fw.newLine();
                k += 1;
            }
            fw.close();
            success = true;
        if (success) {
            SOP("Successfully saved file.");
        }
        else {
            SOP("Save failed.");
        }
        }
        catch (IOException e) {
            SOP("IOException: " + e);
            success = false;
        }
        
    }
    
    static String getFromLineNo(int number, ArrayList<String> array) {
        String obtainedLine;
        obtainedLine = array.get(number);
        return obtainedLine;
    }
    
    static void message(String s) {
        JOptionPane.showMessageDialog(null, s);
    } 
    
    static int searchForLineNumber(String s, ArrayList<String> array, int lines) {
        int lnNo = 0;
        while (lnNo <= lines) {
            if (array.get(lnNo).equals(s)) {
                break;
            }
            else {
            }
            lnNo++;
        }
        return lnNo; 
    }
    
    
    
    static void addXMLTag(boolean close, String s, ArrayList<String> a) {

        String constructedString = "<";
        if (close) {
            constructedString = constructedString + "/";
            constructedString = constructedString + s;
            constructedString = constructedString + ">";
        }
        else {
            constructedString = constructedString + s;
            constructedString = constructedString + ">";
        }
        SOP(constructedString);
        a.add(constructedString);
        SOP(""+95);
    }
    
    static void readFileIntoArray(ArrayList<String> array, int lines) {        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
                lines++;
            }
            br.close();
            fr.close();

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            for (int j = 0; j < lines; j++) {
                array.add(j, br.readLine());
                FileIO.SOP(array.get(j));
            }

            br.close();
        }
        catch (IOException e) {
            FileIO.SOP("IOException: " + e);
        }
    }
    
    static ArrayList<String> linesBetween(int begin, int end, ArrayList<String> source) {
        
        ArrayList<String> result = new ArrayList();
        int length = end - begin;
        for (int i = begin; i <= length; i++) {
            result.add(source.get(i));
        }
        return result;
    }
}