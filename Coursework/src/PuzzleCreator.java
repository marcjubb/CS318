import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class PuzzleCreator {


        private static final int PUZZLES = 4096;


        public static Map<Integer,Puzzle> makePuzzles() {
            System.out.println("makePuzzles::Making 1024 puzzles");
            Map<Integer,Puzzle> puzzleSet = new HashMap<>(PUZZLES);
            for(int i=0;i<PUZZLES;i++) {
                /*puzzleSet.put(i,new Puzzle(i));*/
            }
            return puzzleSet;
        }

    public static byte[] generateRandomKey() throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        //Use java's key generator to produce a random key.
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("DES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();

        //print the key
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        SecretKey x = CryptoLib.createDESKey(Arrays.copyOf(stringToByteArray(encodedKey),8));
        String x2 = Base64.getEncoder().encodeToString(x.getEncoded());
        return stringToByteArray(x2);
    }
    public static byte[] stringToByteArray(String s){
        Base64.Decoder decoder  = Base64.getDecoder();
        return decoder.decode(s);
    }
}
