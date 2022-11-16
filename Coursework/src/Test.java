import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println(Arrays.toString(PuzzleCreator.generateRandomKey()));
        SecretKey jason = null;

        Puzzle puzzle = new Puzzle(2, jason);
        byte [] result = puzzle.getPuzzleAsBytes();
    }
}
