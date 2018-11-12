/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shanedit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class FileIO { 
    
    String filename = "foo";
    int No = 0;
    ArrayList<String> arr = new ArrayList();
    
    public FileIO(String s) {
        fileName = s;
        load(filename, No);
    }
    
    void rmLine(String s) {
        arr.remove(s);
    }
    void SOP(String s) {
        System.out.println(s);
    }
    
    void dumpToFile() {
        boolean success = false;
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(fileName))) {
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
        return obtainedLine;
    }
    
    int searchForLineNumber(String y, int lines) {
        int lnNo = 0;
        String s = y.trim();
        while (lnNo <= lines) {
            if (arr.get(lnNo).equals(s)) {
                break;
            }
            else {
            }
            lnNo++;
        }
        return lnNo; 
    }
    
    
    
    void addXMLTag(boolean close, String s) {

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
        arr.add(constructedString);
        SOP(""+95);
    }
    
    void load(String s, int lines) {        
        try {
            SOP("\n\n\n\n<<<<File contents begin here!>>>>\n\n\n\n");
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
    filename = s;
    }
}

