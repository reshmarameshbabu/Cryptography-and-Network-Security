import java.util.*;
class RailFenceBasic{
    int depth;
    
    String Encryption(String plainText,int depth)
    {
        int r=depth,len=plainText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;
        
        String cipherText="";
        
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                if(k!=len)
                    mat[j][i]=plainText.charAt(k++);
                else
                    mat[j][i]='X';
            }
        }
        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                cipherText+=mat[i][j];
            }
        }
        return cipherText;
    }
    
    
    String Decryption(String cipherText,int depth)
    {
        int r=depth,len=cipherText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;
        
        String plainText="";
        
        
        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                plainText+=mat[j][i];
            }
        }
        
        return plainText;
    }
}

class RailFence{
 public static void main(String args[])
 {
    RailFenceBasic rf=new RailFenceBasic();
    Scanner scn=new Scanner(System.in);
    int depth;
    String plainText,cipherText,decryptedText;
    char ch;
    int choice;

    do{
        System.out.println("Menu:\n1) Encryption\n2) Decryption");
        choice=scn.nextInt();
        switch(choice)
        {
            case 1: System.out.println("Enter plain text:");
                    plainText=scn.next();       
                    System.out.println("Enter depth for Encryption:");
                    depth=scn.nextInt();
                    cipherText=rf.Encryption(plainText,depth);
                    System.out.println("Encrypted text is:\n"+cipherText);
                    break;
            case 2: System.out.println("Enter cipher text:");
                    cipherText=scn.next();       
                    System.out.println("Enter depth for Decryption:");
                    depth=scn.nextInt();
                    decryptedText=rf.Decryption(cipherText, depth);                
                    System.out.println("Decrypted text is:\n"+decryptedText);
                    break;
        }
        System.out.println("\nDo you want to continue? y/n");
        ch = scn.next().charAt(0);
    }while(ch!='n');
    
    
 }
}
