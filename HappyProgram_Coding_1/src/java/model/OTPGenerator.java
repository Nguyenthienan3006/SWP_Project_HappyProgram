package model;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;

public class OTPGenerator {

    public static String generateOTP() {
        SecureRandom random = new SecureRandom();
        byte[] secretKey = new byte[10];
        random.nextBytes(secretKey);

        Base32 base32 = new Base32();
        String base32Key = base32.encodeToString(secretKey);

        return base32Key.substring(0, 6); // Lấy 6 ký tự đầu tiên
    }
}
