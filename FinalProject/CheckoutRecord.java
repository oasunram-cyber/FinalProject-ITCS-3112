import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String patronId;
    private final String bookIsbn;
    private final LocalDate checkoutDate;
    private LocalDate returnDate; // null if not returned

    public CheckoutRecord(String patronId, String bookIsbn) {
        this.id = UUID.randomUUID().toString();
        this.patronId = patronId;
        this.bookIsbn = bookIsbn;
        this.checkoutDate = LocalDate.now();
        this.returnDate = null;
    }

    public String getId() { return id; }
    public String getPatronId() { return patronId; }
    public String getBookIsbn() { return bookIsbn; }
    public LocalDate getCheckoutDate() { return checkoutDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public boolean isReturned() { return returnDate != null; }

    public void markReturned() {
        this.returnDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Record[%s] patron=%s book=%s out=%s returned=%s",
                id.substring(0,8),
                patronId.substring(0,8),
                bookIsbn,
                checkoutDate,
                (returnDate == null ? "NOT" : returnDate.toString()));
    }
}
