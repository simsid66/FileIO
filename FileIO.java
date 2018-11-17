/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sid
 */
public class FileIO {
String filename = "foo";
    int No = 0;
    ArrayList<String> arr = new ArrayList();
    
    public FileIO(String s) {
        filename = s;
        load(filename, No);
    }
    
    public FileIO(String s, ArrayList<String> existing) {
        filename = s;
        arr = existing;
    }
    
    void rmLine(String s) {
        arr.remove(s);
    }
    void SOP(String s) {
        System.out.println(s);
    }
    
    void dumpToFile() {
        boolean success = false;
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filename))) {
            int k = 0;
            while (k < arr.size()) {
                fw.write(arr.get(k));
                fw.newLine();
                k += 1;
            }
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
    
    String getFromLineNo(int number) {
        String obtainedLine;
        obtainedLine = arr.get(number);
        return obtainedLine.trim();
    }
    
    int searchForLineNumber(String y) {
        int lnNo = 0;
        String s = y.trim();
        while (lnNo <= arr.size()) {
            if (arr.get(lnNo).equals(s)) {
                break;
            }
            else {
            }
            lnNo++;
        }
        return lnNo; 
    }
    
    
    
    void addXMLTag(boolean close, String s, int indentLevel) {
        
        String tab = "    ";
        String constructedString = "";
        for (int i = 0; i < indentLevel; i++) {
            constructedString += tab;
        }
        
        constructedString += "<";
        if (close) {
            constructedString += "/";
            constructedString += s;
            constructedString += ">";
        }
        else {
            constructedString += s;
            constructedString += ">";
        }
  
        SOP(constructedString);
        arr.add(constructedString);
        SOP(""+95);
    }
    
    void load(String s, int lines) {        
        try {
            SOP("\n\n\n\n<<<<File contents begin here!>>>>\n\n\n\n");
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
                lines++;
            }
            br.close();
            fr.close();

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            for (int j = 0; j < lines; j++) {
                arr.add(j, br.readLine());
                SOP(arr.get(j));
            }

            br.close();
            SOP("\n\n\n\n<<<<File contents end here!>>>>\n\n\n\n");
        }
        catch (IOException e) {
            SOP("IOException: " + e);
        }
    }
    
    void AddLine(String s) {
        arr.add(s);
    }
    
    void dispose() {
    arr = new ArrayList();
    filename = "";
    }
    
    int numLines() {
        return arr.size();
    }
}
