import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithAllField() {
        createContact(
                "firstname", "middlename", "lastname", "nickname",
                "email", "email2", "email3",
                "address",
                "home_tel", "mobile_tel", "work_tel", "fax",
                "//option[. = '1']", "//option[. = 'January']", "2001"
        );
    }

    @Test
    public void canCreateContactWithAllEmptyField() {
        createContact(
                "", "", "", "",
                "", "", "",
                "",
                "", "", "", "",
                "//option[. = '']", "//option[. = '']", ""
        );
    }

}
