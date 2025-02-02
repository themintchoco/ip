import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileStorage<T extends TextFileStorageSaveable, TF extends TextFileStorageConstructable<T>> implements Storage<T> {
    private File saveFile;
    private TF factory;

    public TextFileStorage(String path, TF factory) {
        this.saveFile = new File(path);
        this.saveFile.getParentFile().mkdirs();
        this.factory = factory;
    }

    @Override
    public List<T> load() {
        List<T> items = new ArrayList<>();

        try (FileReader reader = new FileReader(this.saveFile)) {
            int data;
            StringBuilder sb = new StringBuilder();
            while ((data = reader.read()) != -1) {
                if (data == '\n') {
                    items.add(factory.constructFromSaveString(sb.toString()));
                    sb.setLength(0);
                } else {
                    sb.append((char) data);
                }
            }
        } catch (IOException e) {
            throw new MarshmallowException("Something went wrong while loading your tasks :(");
        }

        return items;
    }

    @Override
    public void save(List<T> items) {
        try (FileWriter writer = new FileWriter(this.saveFile)) {
            for (T item : items) {
                writer.write(item.toSaveString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new MarshmallowException("Something went wrong while saving your tasks :(");
        }
    }
}
