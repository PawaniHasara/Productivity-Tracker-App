package EX;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

	
    private static final String DATABASE_FILE = "user_database.txt";

    public static Map<String, String> loadDatabase() {

        Map<String, String> userDatabase = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userDatabase.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDatabase;
    }

    public static void saveDatabase(Map<String, String> userDatabase) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (Map.Entry<String, String> entry : userDatabase.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	}

