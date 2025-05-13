import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private static final String DATA_DIRECTORY = "inventory_data";
    private static final String FILE_EXTENSION = ".dat";

    public FileManager() {
        // Create data directory if it doesn't exist
        File directory = new File(DATA_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void saveInventory(String sectionName, Map<String, Map<String, Product>> inventory) {
        String fileName = DATA_DIRECTORY + "/" + sectionName + FILE_EXTENSION;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(inventory);
            System.out.println("Inventory data saved successfully for " + sectionName);
        } catch (IOException e) {
            System.err.println("Error saving inventory data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Map<String, Product>> loadInventory(String sectionName) {
        String fileName = DATA_DIRECTORY + "/" + sectionName + FILE_EXTENSION;
        File file = new File(fileName);
        
        if (!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Map<String, Map<String, Product>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading inventory data: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public boolean deleteInventory(String sectionName) {
        String fileName = DATA_DIRECTORY + "/" + sectionName + FILE_EXTENSION;
        File file = new File(fileName);
        return file.delete();
    }
} 