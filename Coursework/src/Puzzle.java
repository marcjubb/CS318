import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;

public class Puzzle {
    private int puzzleNum;
    private SecretKey encryptionKey;
    private SecretKey key;
    private byte[] padding = new byte[16];

    public Puzzle(Integer puzzleNum, SecretKey inKey){
        this.puzzleNum = puzzleNum;
        this.key = inKey;

    }


    public int getPuzzleNumber(){
        return puzzleNum;
    }
    public SecretKey getKey(){
        return key;
    }

    public byte[] getPuzzleAsBytes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        try {
            outputStream.write(padding);
            outputStream.write(puzzleNum);
            outputStream.write(key.getEncoded());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
