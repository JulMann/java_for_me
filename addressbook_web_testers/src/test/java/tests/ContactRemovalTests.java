package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.isContactPresent()) {
            app.createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
        }
        app.removeContact();
    }
}
