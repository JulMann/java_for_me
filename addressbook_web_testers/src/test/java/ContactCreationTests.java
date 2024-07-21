import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithAllField() {
        createContactWithAllField();
    }

    @Test
    public void canCreateContactWithSomeEmptyField() {
        createContactWithSomeEmptyField();
    }

}
