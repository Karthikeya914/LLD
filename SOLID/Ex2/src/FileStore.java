import java.util.*;

public class FileStore implements InvoiceStore {

    private final Map<String, String> storage = new HashMap<>();

    @Override
    public void save(String invoiceId, String content) {
        storage.put(invoiceId, content);
    }

    @Override
    public int countLines(String invoiceId) {
        String text = storage.get(invoiceId);
        if (text == null) return 0;
        return text.split("\n").length;
    }
}