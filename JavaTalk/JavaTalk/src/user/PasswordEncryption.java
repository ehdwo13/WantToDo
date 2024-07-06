package user;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordEncryption {

    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = generateSalt();
        byte[] hash = hashPassword(password.toCharArray(), salt);

        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encodedHash = Base64.getEncoder().encodeToString(hash);

        return encodedSalt + ":" + encodedHash;
    }

    // 저장된 비밀번호와 입력된 비밀번호가 일치하는지 확인하는 메서드
    public static boolean matchPassword(String storedPassword, String inputPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 저장된 비밀번호에서 솔트와 해시를 분리
        String[] parts = storedPassword.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid stored password format.");
        }
        String encodedSalt = parts[0];
        String encodedHash = parts[1];

        byte[] salt = Base64.getDecoder().decode(encodedSalt);
        byte[] hash = Base64.getDecoder().decode(encodedHash);

        // 입력된 비밀번호를 같은 솔트로 해시
        byte[] inputHash = hashPassword(inputPassword.toCharArray(), salt);

        // 저장된 해시와 입력된 해시가 일치하는지 확인
        return slowEquals(hash, inputHash);
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] hashPassword(char[] password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return factory.generateSecret(spec).getEncoded();
    }
    
    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}
