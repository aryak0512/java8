import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class App {

	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

	public static String encrypt(String message, String key) throws GeneralSecurityException {

		if (message == null || key == null) {
			throw new IllegalArgumentException("text to be encrypted and key should not be null");
		}

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		byte[] messageArr = message.getBytes();
		byte[] keyparam = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(keyparam, "AES");
		byte[] ivParams = new byte[16];
		byte[] encoded = new byte[messageArr.length + 16];
		System.arraycopy(ivParams, 0, encoded, 0, 16);
		System.arraycopy(messageArr, 0, encoded, 16, messageArr.length);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivParams));
		byte[] encryptedBytes = cipher.doFinal(encoded);
		encryptedBytes = Base64.getEncoder().encode(encryptedBytes);
		return new String(encryptedBytes);
	}

	public static String decrypt(String encryptedStr, String key) throws GeneralSecurityException {

		if (encryptedStr == null || key == null) {
			throw new IllegalArgumentException("text to be decrypted and key should not be null");
		}
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		byte[] keyparam = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(keyparam, "AES");
		byte[] encoded = encryptedStr.getBytes();
		encoded = Base64.getDecoder().decode(encoded);
		byte[] decodedEncrypted = new byte[encoded.length - 16];
		System.arraycopy(encoded, 16, decodedEncrypted, 0, encoded.length - 16);
		byte[] ivParams = new byte[16];
		System.arraycopy(encoded, 0, ivParams, 0, ivParams.length);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivParams));
		byte[] decryptedBytes = cipher.doFinal(decodedEncrypted);
		return new String(decryptedBytes);
	}

	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, InstantiationException, GeneralSecurityException {

		String ciphertext = encrypt(
				"<VMX_ROOT>\r\n" + "  <VMX_HEADER>\r\n" + "    <MSGID>M.LMS.POINTS.ADJ.ADD</MSGID>\r\n"
						+ "    <VERSION>E8V2</VERSION>\r\n" + "    <CLIENTID>06146</CLIENTID>\r\n"
						+ "    <CORRELID>7879790866</CORRELID>\r\n" + "    <CONTEXT>00000KOTAKVMX</CONTEXT>\r\n"
						+ "    <NAME>00000KOTAKVMX</NAME>\r\n" + "  </VMX_HEADER>\r\n" + "  <VMX_MSGIN>\r\n"
						+ "    <CONTEXT>00000KOTAKVMX</CONTEXT>\r\n" + "    <NAME>00000KOTAKVMX</NAME>\r\n"
						+ "    <ORG>406</ORG>\r\n" + "    <ACCT_NBR>0009406188000003875</ACCT_NBR>\r\n"
						+ "    <SCHEME>SC160</SCHEME>\r\n" + "    <POINTS>1</POINTS>\r\n"
						+ "    <CASHBACK_AMT></CASHBACK_AMT>\r\n" + "    <REWARD_ITEM />\r\n"
						+ "    <ACTION_CODE />\r\n" + "    <DESC>REWARD POINTS CREDIT</DESC>\r\n"
						+ "    <CC_MASKED>7607</CC_MASKED>\r\n" + "  </VMX_MSGIN>\r\n" + "</VMX_ROOT>",
				"647d1342ef604341b753d6877b1c941c");

		// reward red : 260b8bdd4eb8440ca02f6275686c55d7
		System.out.println(ciphertext);

		String decryptedText = decrypt(
				"SmL3ALfk0BhJ5njktclCTpYxxSTxBPxAY5PXCO/sDg0q84CW5Da8K64UUVuF4lknbRT2Re3hL5GroKdKCeJxEPbBljlOIoDuYQ7qngtv/OmDHZsSIJ6KCKS0t3HQGZNLXvPUzVz7b1c+eTMieLWmO8gwQdOo4nrDrnhi8C2fs/xGOk/2Hey1ebeq6VCBVRd9089RvO9uGudYFQcnQSarauTPXTpumfpglUuC820lg5zGN6bfi0MPeynM1KZsSnEOwSJQCBXkLTyOtFqzBf4at/aCvR+1fUIPXy3K7Ummw32Ma2atwnU+2vOVLOtyO5HKgtAHAfthjAmnMIef3hbnAXsX56st1t22fdHyENbCAsh9kHBF5V8JDtM2TYR+XDaO3zDxO3B9n8olPhPdWCZoi3DsZI2J/FR4iVAm7HVzKcfv9dxy2FtvcXvkWKfHM1aFbZEGEcqAKTdh9EM9NXhGth5rmM31MbtLtuDuoPu2/w17fRTS4RehQ8n97lgZ/NUXrNzzLRR+WnQbUqIK44P/G3ET5g3zHvIE7pS/b1NozuBCzMRrSRs0N0psxisyh5jshWCqGD5OiLhHtF4o3GAwoP+UUJAs9WtTCFHP1P+LElKuH2/2g1OuvD9P54gdyf+YF40kFnesXjpNjujJUdGHAA1aS0SU1Boasn38VeYYUPpK+D+9NmPIy7027JGMn9VW6218/cFbmQpi5b0uusUzT+wCm0oZgiBLw0k965MvHjVQ6RaqG5QIHZSmnIJQetaTW8zroX3PlAHEpO2q2xkj5dLm58C6XPdR8rYN8LhKYa/edw1oWCLXdGSIYJptsPwI",
				"647d1342ef604341b753d6877b1c941c");
		System.out.println(decryptedText);
	}
}
