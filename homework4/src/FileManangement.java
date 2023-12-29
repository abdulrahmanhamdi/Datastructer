
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManangement {
    private String directory;
    private String fileName;

    public FileManangement(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    public String readFile() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(directory + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

}

