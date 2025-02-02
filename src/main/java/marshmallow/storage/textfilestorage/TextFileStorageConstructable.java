package marshmallow.storage.textfilestorage;

public interface TextFileStorageConstructable<T> {
    public T constructFromSaveString(String data);
}
