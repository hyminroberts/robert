package com.leiyang.practice;

import java.net.URL;   
  import java.net.URLClassLoader;   
  public class ClassLoaderTest {   
      private static int count = -1;   
      
      public static void testClassLoader(Object obj) {   
          if (count < 0 && obj == null) {   
             System.out.println("Input object is NULL");   
             return;   
         }   
          ClassLoader cl = null;   
          if (obj != null && !(obj instanceof ClassLoader)) {   
              cl = obj.getClass().getClassLoader();   
          } else if (obj != null) {   
              cl = (ClassLoader) obj;   
          }   
          count++;   
          String parent = "";   
          for (int i = 0; i < count; i++) {   
              parent += "Parent ";   
          }   
          if (cl != null) {   
              System.out.println(   
                  parent + "ClassLoader name = " + cl.getClass().getName());   
              testClassLoader(cl.getParent());   
          } else {   
             System.out.println(   
                  parent + "ClassLoader name = BootstrapClassLoader");   
             count = -1;   
          }   
     }   
      public static void main(String[] args) {   
          URL[] urls = new URL[1];   
          URLClassLoader urlLoader = new URLClassLoader(urls);   
          ClassLoaderTest.testClassLoader(urlLoader);   
     }   
}    
