/**
 * 
 */
package edu.uniandes.alcaldiavirtual.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * Clase para codificar y decodificar las contraseñas
 * @author Daniel Arevalo
 *
 */
public class PasswordCipher {
	/**
	 * Metodo para encriptar una cadena
	 * @param to_encrypt
	 * @param strkey
	 * @return String
	 */
	public static String encrypt(String to_encrypt, String strkey) {
	  try {
	    SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
	     Cipher cipher = Cipher.getInstance("Blowfish");
	     cipher.init(Cipher.ENCRYPT_MODE, key);
	     return new String(cipher.doFinal(to_encrypt.getBytes()));
	  } catch (Exception e) {
		  e.printStackTrace();
		  return null; 
	  }
	}
	/**
	 * Metodo para desencriptar una cadena
	 * @param to_decrypt
	 * @param strkey
	 * @return String
	 */
	public static String decrypt(String to_decrypt, String strkey) {
	  try {
	     SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
	     Cipher cipher = Cipher.getInstance("Blowfish");
	     cipher.init(Cipher.DECRYPT_MODE, key);
	     String encryptedString = bytesToHex(to_decrypt.getBytes());
	     byte[] decrypted = cipher.doFinal(hexToBytes(encryptedString));
	     return new String(decrypted);
	  } catch (Exception e) { 
		  e.printStackTrace();
		  return null; 
	  }
	}
	
	public static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
	      int len = str.length() / 2;
	      byte[] buffer = new byte[len];
	      for (int i = 0; i < len; i++) {
	        buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
	      }
      return buffer;
    }

  }

  public static String bytesToHex(byte[] data) {
    if (data == null) {
      return null;
    } else {
      int len = data.length;
      String str = "";
  for (int i = 0; i < len; i++) {
    if ((data[i] & 0xFF) < 16)
      str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
        else
          str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
      }
      return str.toUpperCase();
    }
  }
}
