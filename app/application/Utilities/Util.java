package application.Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by pkonwar on 7/3/2016.
 */
public class Util {


    /**
     * Convert Image URL to byte Array.
     * @param location
     * @return
     * @throws IOException
     */
    public static byte[] convertImageToByte(String location) throws IOException {
        Path path = Paths.get(location);
        return Files.readAllBytes(path);
    }


    public static Boolean isNullOrEmpty(String... strings) {
        for(String astring : strings) {
            if(astring == null || astring.isEmpty())
                return true;
        }
        return false;
    }
}
