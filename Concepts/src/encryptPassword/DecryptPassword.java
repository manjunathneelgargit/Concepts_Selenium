package encryptPassword;

import org.apache.xmlbeans.impl.util.Base64;

public class DecryptPassword {
	
	public static String decryptPassword(String encodedPassword) {
		return new String(Base64.decode(encodedPassword.getBytes()));
	}

}
