package programming.art;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
	private static String getString(byte[] paramArrayOfByte)
	  {
	    StringBuffer localStringBuffer = new StringBuffer();
	    for (int i = 0; ; i++)
	    {
	      if (i >= paramArrayOfByte.length)
	        return localStringBuffer.toString();
	      localStringBuffer.append(paramArrayOfByte[i]);
	    }
	  }

	  public static String getMD5(String paramString)
	    throws NoSuchAlgorithmException
	  {
	    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
	    localMessageDigest.update(paramString.getBytes());
	    return getString(localMessageDigest.digest());
	  }
	  public static void main(String[] args) throws NoSuchAlgorithmException{
		  System.out.println("TSCTF{" +getMD5("hereicome ") + "}");
		  
	  }

}
