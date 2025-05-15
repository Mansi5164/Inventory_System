import java.io.*;
import java.util.*;

public class FileManager {
    private static final String BASE_PATH = "inventory_data/";

    public FileManager() {
        File dir = new File(BASE_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // ✅ Save the full inventory map for the section (all categories)
    public void saveInventory(String section, Map<String, Map<String, Product>> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(BASE_PATH + section + ".dat"))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved for section: " + section);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Load the full inventory map for the section (all categories)
    public Map<String, Map<String, Product>> loadInventory(String section) {
        File file = new File(BASE_PATH + section + ".dat");
        if (!file.exists()) {
            return new HashMap<>();  // If file doesn't exist, return empty inventory
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<String, Map<String, Product>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void backupInventory(String section) {
        File source = new File(BASE_PATH + section + ".dat");
        File backup = new File(BASE_PATH + section + "_backup.dat");

        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(backup)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("Backup created for section: " + section);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Optional: Restore just one category from the section if needed
    public Map<String, Product> restoreInventory(String section) {
        Map<String, Map<String, Product>> fullInventory = loadInventory(section);
        return fullInventory.getOrDefault(section, new HashMap<>());
    }
}
