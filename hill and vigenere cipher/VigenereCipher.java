import java.util.*;
class VigenereCipher  
{ 
static String generateKey(String str, String key) 
{ 
    int x = str.length(); 
  
    for (int i = 0; ; i++) 
    { 
        if (x == i) 
            i = 0; 
        if (key.length() == str.length()) 
            break; 
        key+=(key.charAt(i)); 
    } 
    return key; 
} 
  
// returns ciphertext with the help of key
static String cipherText(String str, String key) 
{ 
    String cipher_text = " "; 
    int c;
    str = str.toUpperCase();
    key = key.toUpperCase();
    key = generateKey(str, key);
    for (int i = 0; i < str.length(); i++) 
    { 
        // converting in range 0-25 
        c = (str.charAt(i) + key.charAt(i))%26;
        // convert into alphabets(ASCII) 
        c += 'A'; 
        cipher_text += (char)(c); 
    } 
    return cipher_text; 
} 
  
// decryption
static String originalText(String cipher_text, String keyword) 
{ 
    String orig_text=" "; 
    String key = generateKey(cipher_text, keyword); 
    cipher_text = cipher_text.toUpperCase();
    key = key.toUpperCase();
  
    for (int i = 0 ; i < cipher_text.length() && i < key.length(); i++) 
    {
        // converting in range 0-25 
        int x = (cipher_text.charAt(i) - key.charAt(i) + 26) %26; 
  
        // convert into alphabets(ASCII) 
        x += 'A'; 
        orig_text+=(char)(x); 
    } 
    return orig_text; 
} 
  
// Driver code 
public static void main(String[] args)  
{ 
    String str, keyword, cipher_text;
    char ch;
    int choice;
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    do{
        System.out.println("Vigenere Cipher: \n 1. Encryption \n 2. Decryption\n");
        System.out.println("Enter Choice:");
        choice = sc1.nextInt();
        //choice = Integer.parseInt(sc.nextLine());
        switch(choice)
        {
            case 1: 
                System.out.println("Enter plain text:");
                str = sc.next();
                System.out.println("Enter keyword:");
                keyword = sc.next();
                cipher_text = cipherText(str, keyword); 
                System.out.println("Ciphertext: "+cipher_text+" \n");
                break;
            case 2: 
                System.out.println("Enter cipher text:");
                cipher_text = sc.next();
                System.out.println("Enter keyword:");
                keyword = sc.next();
                str = originalText(cipher_text, keyword);
                System.out.println("Plain text:"+str+" \n");
                break;
            default: System.out.println("Invalid choice!");break;
        }
        System.out.println("Do you want to continue? y/n");
        ch = sc.next().charAt(0);
    }while(ch!='n');
    sc.close();
    sc1.close();
    } 
} 