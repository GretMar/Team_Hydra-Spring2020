import java.io.FileNotFoundException;
import java.io.IOException;

public class Play {
    /**
     * Method: main()
     * runs program
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.play();
    }
}
