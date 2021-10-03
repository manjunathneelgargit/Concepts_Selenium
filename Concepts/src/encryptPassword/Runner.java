package encryptPassword;

public class Runner {

	public static void main(String[] args) {
		
		//The password Admin@123 is encoded from https://www.base64encode.org/ 
		String encodedPassword = "QWRtaW5AMTIz";
		String decryptedPassword = DecryptPassword.decryptPassword(encodedPassword);
		System.out.println(decryptedPassword);

	}

}
