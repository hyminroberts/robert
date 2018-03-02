package com.leiyang.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class IOTest {
   public static void main(String[]args) throws Exception {
        String str = "ÖÐ¹úÈË";
        /*FileOutputStreamfos  = newFileOutputStream("1.txt");
       
        fos.write(str.getBytes("UTF-8"));
        fos.close();*/
       
        /*FileWriter fw =new FileWriter("1.txt");
        fw.write(str);
        fw.close();*/
        PrintWriter pw =new PrintWriter("1.txt","utf-8");
        pw.write(str);
        pw.close();
       
        /*FileReader fr =new FileReader("1.txt");
        char[] buf = newchar[1024];
        int len =fr.read(buf);
        String myStr = newString(buf,0,len);
        System.out.println(myStr);*/
        /*FileInputStreamfr = new FileInputStream("1.txt");
        byte[] buf = newbyte[1024];
        int len =fr.read(buf);
        String myStr = newString(buf,0,len,"UTF-8");
        System.out.println(myStr);*/
        BufferedReader br =new BufferedReader(
                      new InputStreamReader(
                             new FileInputStream("1.txt"),"UTF-8"
                             )
                      );
        String myStr =br.readLine();
        br.close();
        System.out.println(myStr);
   }
 
}