package javaapplication13;
import java.util.Scanner; 
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;




class Main {
  
 public static final char[] EXTENDED = { 0x00C7, 0x00FC, 0x00E9, 0x00E2,
            0x00E4, 0x00E0, 0x00E5, 0x00E7, 0x00EA, 0x00EB, 0x00E8, 0x00EF,
            0x00EE, 0x00EC, 0x00C4, 0x00C5, 0x00C9, 0x00E6, 0x00C6, 0x00F4,
            0x00F6, 0x00F2, 0x00FB, 0x00F9, 0x00FF, 0x00D6, 0x00DC, 0x00A2,
            0x00A3, 0x00A5, 0x20A7, 0x0192, 0x00E1, 0x00ED, 0x00F3, 0x00FA,
            0x00F1, 0x00D1, 0x00AA, 0x00BA, 0x00BF, 0x2310, 0x00AC, 0x00BD,
            0x00BC, 0x00A1, 0x00AB, 0x00BB, 0x2591, 0x2592, 0x2593, 0x2502,
            0x2524, 0x2561, 0x2562, 0x2556, 0x2555, 0x2563, 0x2551, 0x2557,
            0x255D, 0x255C, 0x255B, 0x2510, 0x2514, 0x2534, 0x252C, 0x251C,
            0x2500, 0x253C, 0x255E, 0x255F, 0x255A, 0x2554, 0x2569, 0x2566,
            0x2560, 0x2550, 0x256C, 0x2567, 0x2568, 0x2564, 0x2565, 0x2559,
            0x2558, 0x2552, 0x2553, 0x256B, 0x256A, 0x2518, 0x250C, 0x2588,
            0x2584, 0x258C, 0x2590, 0x2580, 0x03B1, 0x00DF, 0x0393, 0x03C0,
            0x03A3, 0x03C3, 0x00B5, 0x03C4, 0x03A6, 0x0398, 0x03A9, 0x03B4,
            0x221E, 0x03C6, 0x03B5, 0x2229, 0x2261, 0x00B1, 0x2265, 0x2264,
            0x2320, 0x2321, 0x00F7, 0x2248, 0x00B0, 0x2219, 0x00B7, 0x221A,
            0x207F, 0x00B2, 0x25A0, 0x00A0 };
    // function to convert decimal to hexadecimal 
    static void decToHexa(int n ) 
    {    
        // char array to store hexadecimal number 
        char[] hexaDeciNum = new char[100]; 
       
        // counter for hexadecimal number array 
        int i = 0; 
        while(n!=0) 
        {    
            // temporary variable to store remainder 
            int temp  = 0; 
           
            // storing remainder in temp variable. 
            temp = n % 16; 
           
            // check if temp < 10 
            if(temp < 10) 
            { 
                hexaDeciNum[i] = (char)(temp + 48); 
                i++; 
            } 
            else
            { 
                hexaDeciNum[i] = (char)(temp + 55); 
                i++; 
            } 
           
            n = n/16; 
        } 
       System.out.print("Sesioliktainis skacius lygus ");
        // printing hexadecimal number array in reverse order 
        for(int j=i-1; j>=0; j--) {
      
            System.out.print(hexaDeciNum[j]); 
    }
        System.out.println(" ");
    }
    public static int hex_to_decimal(String s)
    {
             String digits = "0123456789ABCDEF";
             s = s.toUpperCase();
             int val = 0;
             for (int i = 0; i < s.length(); i++)
             {
                 char c = s.charAt(i);
                 int d = digits.indexOf(c);
                 val = 16*val + d;
             }
             return val;
    }
   
public static byte[] utf8encode(int codepoint) {
        return new String(new int[]{codepoint}, 0, 1).getBytes(StandardCharsets.UTF_8);
    }
 
    public static int utf8decode(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8).codePointAt(0);
    }
    public static final char getAscii(int code) {
        if (code >= 0x80 && code <= 0xFF) {
            return EXTENDED[code - 0x7F];
        }
        return (char) code;
    }

    public static final void printChar(int code)  {
       //  BufferedWriter bw = null;
      //  File file = new File("C:\\Users\\Lenovo\\Desktop\\2laboras\\intel2.txt");
      //  FileWriter fw = new FileWriter(file);
       //  bw = new BufferedWriter(fw);
        //  bw.write(getAscii(code));
        
    }
 
   
    public static void main (String[] args)  throws Exception
    { 
         Scanner in = new Scanner(System.in);
        // Display the menu
        System.out.println(" 1.decimal converteris");
        System.out.println(" 2.atkoduoti faila");
        

        System.out.println("pasirinkite varianta:");
        
        //Get user's choice
        int choice=in.nextInt();
         
        //Display the title of the chosen module
        switch (choice) {
            case 1: 
                 int n;
        System.out.println("Iveskite desimtaini skaiciu");
        Scanner S=new Scanner(System.in);
        n=S.nextInt();
        decToHexa(n); 
        String hexdec_num; // turi buti sesioliktanis 
        int dec_num, i=1, j;
        int bin_num[] = new int[100];
        Scanner scan = new Scanner(System.in);
		
        System.out.println("Iveskite gauta sesioliktaini skaiciu");
        hexdec_num = scan.nextLine();
        dec_num = hex_to_decimal(hexdec_num);
        
        /* convert decimal to binary */        
        while(dec_num != 0)
        {
            bin_num[i++] = dec_num%2;
            dec_num = dec_num/2;
        }
	StringBuffer sbfNumbers = new StringBuffer();	
          
        System.out.print("Dvejatainis skacius lygus ");
        for(j=i-1; j>0; j--)
        {
          sbfNumbers.append(bin_num[j]);
           // System.out.print(bin_num[j]);
          //  String s = Arrays.toString(bin_num);
        }
        System.out.println(sbfNumbers.toString());
        String string = sbfNumbers.toString();
   System.out.printf("%-7s %-43s %7s\t%s\t%7s%n",
                "Char", "Name", "Unicode", "UTF-8 encoded", "Decoded");
 
        for (int codepoint : new int[]{n}) {
            byte[] encoded = utf8encode(codepoint);
            Formatter formatter = new Formatter();
            for (byte b : encoded) {
                formatter.format("%02X ", b); 
            }
            String encodedHex = formatter.toString();
            int decoded = utf8decode(encoded);
            System.out.printf("%-7c %-43s U+%04X\t%-12s\tU+%04X%n",
                    codepoint, Character.getName(codepoint), codepoint, encodedHex, decoded);
        }
            
	   break;
            case 2:
                File f=new File("C:\\Users\\Lenovo\\Desktop\\2laboras\\intel.txt");     
      FileReader fr=new FileReader(f);   //Creation of File Reader object
      BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
      int c = 0;             
      while((c = br.read()) != -1)         //Read char by Char
      {
            char character = (char) c; //converting integer to char    
          //  int value = Character.getNumericValue(c); 
         
             }
             
        
           // System.out.print(character);        //Display the Character
      
      

                    break;
            default: System.out.println("neteisingas pasirinkimas");
        }//end of switch
       
    }

    
    
    }

    
