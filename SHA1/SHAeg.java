import java.security.*;
import javax.crypto.*;
public class SHAeg{
    public static void main(String[] args)throws NoSuchAlgorithmException
    {
        byte[] input = "67452301".getBytes();

        //message digest object using SHA1
        MessageDigest md = MessageDigest.getInstance("SHA1");

        //compute digest
        md.update(input);
        byte[] digest =  md.digest();

        //convert byte digest to hex
        StringBuffer hexDigest = new StringBuffer();
        for(int i=0;i<digest.length;i++)
            hexDigest.append(Integer.toString((digest[i]&0xff)+0x100,16).substring(1));
        
        System.out.println("Digest of string 67452301 is "+hexDigest);
    }
}