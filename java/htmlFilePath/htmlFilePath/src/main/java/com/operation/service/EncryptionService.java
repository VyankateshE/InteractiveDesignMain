package com.operation.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operation.config.PropertiesConfig;

import jakarta.annotation.PostConstruct;

@Service
public class EncryptionService {
	
	

	private static final Logger logger = LoggerFactory.getLogger(EncryptionService.class);
    private static final String ALGORITHM = "AES";

	private static final String KEY = "ariantechsolutionsprivatelimitedmaladmumbai=";
	
	//private static final String KEY = "ariantechsolutions1234" ;
	
	 

	   

	public static String encrypt(String data) throws Exception {
		return Base64.getEncoder().encodeToString(getCipher(false).doFinal(data.getBytes()));
	}

	public static String decrypt(String encryptedValue) throws Exception {
		return new String(getCipher(true).doFinal(Base64.getDecoder().decode(encryptedValue)));
	}

	private static Cipher getCipher(boolean isDecryptMode) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);

		byte[] decodedKey = Base64.getDecoder().decode(KEY);
		SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

		if (isDecryptMode) {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		}

		return cipher;
	}

	public static String encryptFile(InputStream inputStream) throws IOException {
		try {
	
			byte[] encryptedData = getCipher(false).doFinal( inputStream.readAllBytes() );

			// Encode the encrypted data to Base64 and return as a string
			return Base64.getEncoder().encodeToString(encryptedData);

		} catch (Exception e) {
			throw new IOException("Error encrypting file", e);
		}
	}

	public String secureHtmlContain(String encryptedData) {

		String script = "const _0x59aeb5=_0x5e20,_0x2a2cf7=_0x5e20;function _0x5e20(_0x126bf3,_0x42d20a){const _0x40efe3=_0x40ef();return _0x5e20=function(_0x5e206f,_0x4e1397){_0x5e206f=_0x5e206f-0xad;let _0x2af27b=_0x40efe3[_0x5e206f];return _0x2af27b;},_0x5e20(_0x126bf3,_0x42d20a);}(function(_0x5f4976,_0x3d2a62){const _0xa510b9=_0x5e20,_0x27933d=_0x5e20,_0x1d4480=_0x5f4976();while(!![]){try{const _0x4f10ec=-parseInt(_0xa510b9(0xb7))/0x1+-parseInt(_0x27933d(0xb9))/0x2*(parseInt(_0xa510b9(0xad))/0x3)+parseInt(_0xa510b9(0xc0))/0x4*(parseInt(_0x27933d(0xb0))/0x5)+parseInt(_0x27933d(0xb5))/0x6+parseInt(_0xa510b9(0xc1))/0x7+-parseInt(_0xa510b9(0xc3))/0x8*(-parseInt(_0x27933d(0xbf))/0x9)+-parseInt(_0xa510b9(0xbb))/0xa*(parseInt(_0x27933d(0xb6))/0xb);if(_0x4f10ec===_0x3d2a62)break;else _0x1d4480['push'](_0x1d4480['shift']());}catch(_0x18839c){_0x1d4480['push'](_0x1d4480['shift']());}}}(_0x40ef,0xe7929));const a=\""
				+ encryptedData
				+ "\";function _0x40ef(){const _0x4fc939=['\\x61\\x72\\x69\\x61\\x6e\\x74\\x65\\x63\\x68\\x73','\\x34\\x35\\x32\\x50\\x53\\x75\\x54\\x61\\x75','\\x6f\\x6c\\x75\\x74\\x69\\x6f\\x6e\\x73\\x70\\x72','\\x32\\x30\\x49\\x47\\x53\\x46\\x53\\x7a','\\x42\\x61\\x73\\x65\\x36\\x34','\\x6d\\x6f\\x64\\x65','\\x74\\x6f\\x53\\x74\\x72\\x69\\x6e\\x67','\\x39\\x59\\x70\\x78\\x53\\x79\\x51','\\x32\\x31\\x34\\x34\\x38\\x35\\x32\\x6c\\x72\\x4c\\x57\\x5a\\x55','\\x37\\x32\\x38\\x36\\x32\\x37\\x39\\x65\\x69\\x4f\\x6f\\x47\\x57','\\x65\\x6e\\x63','\\x31\\x32\\x34\\x31\\x37\\x34\\x35\\x36\\x61\\x48\\x41\\x79\\x4b\\x47','\\x41\\x45\\x53','\\x33\\x36\\x32\\x34\\x4c\\x76\\x45\\x71\\x63\\x48','\\x70\\x61\\x72\\x73\\x65','\\x50\\x6b\\x63\\x73\\x37','\\x31\\x35\\x66\\x6e\\x4e\\x4e\\x6b\\x48','\\x63\\x6c\\x6f\\x73\\x65','\\x64\\x65\\x63\\x72\\x79\\x70\\x74','\\x6f\\x70\\x65\\x6e','\\x69\\x76\\x61\\x74\\x65\\x6c\\x69\\x6d\\x69\\x74','\\x39\\x39\\x36\\x34\\x31\\x37\\x30\\x66\\x44\\x71\\x4e\\x79\\x77','\\x32\\x31\\x36\\x32\\x38\\x35\\x36\\x33\\x64\\x74\\x5a\\x44\\x74\\x70','\\x37\\x30\\x38\\x34\\x31\\x38\\x6d\\x66\\x41\\x73\\x67\\x71'];_0x40ef=function(){return _0x4fc939;};return _0x40ef();}function n(_0x2be3db,_0x17afdb){const _0x19edee=_0x5e20,_0x3b9b9d=_0x5e20,_0x387aa1=CryptoJS[_0x19edee(0xc4)][_0x19edee(0xb2)]({'\\x63\\x69\\x70\\x68\\x65\\x72\\x74\\x65\\x78\\x74':CryptoJS[_0x3b9b9d(0xc2)][_0x19edee(0xbc)][_0x19edee(0xae)](_0x2be3db)},_0x17afdb,{'\\x6d\\x6f\\x64\\x65':CryptoJS[_0x3b9b9d(0xbd)]['\\x45\\x43\\x42'],'\\x70\\x61\\x64\\x64\\x69\\x6e\\x67':CryptoJS['\\x70\\x61\\x64'][_0x19edee(0xaf)]});return _0x387aa1[_0x19edee(0xbe)](CryptoJS['\\x65\\x6e\\x63']['\\x55\\x74\\x66\\x38']);}const b=_0x59aeb5(0xb8)+_0x59aeb5(0xba)+_0x59aeb5(0xb4)+'\\x65\\x64\\x6d\\x61\\x6c\\x61\\x64\\x6d\\x75\\x6d'+'\\x62\\x61\\x69\\x3d',q=CryptoJS[_0x59aeb5(0xc2)][_0x2a2cf7(0xbc)][_0x2a2cf7(0xae)](b),m=n(a,q);document[_0x59aeb5(0xb3)](),document['\\x77\\x72\\x69\\x74\\x65'](m),document[_0x2a2cf7(0xb1)]()";

		String htmlString = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Document</title><script src=\"https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js\"></script><title>Original Page</title><script>"
				+ script + "</script></head><body></body></html>";
		return htmlString;
	}

}
