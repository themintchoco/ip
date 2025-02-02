import java.util.List;

public interface Storage<T> {
    public List<T> load();
    public void save(List<T> items);
}
