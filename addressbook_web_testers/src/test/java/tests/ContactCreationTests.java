package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithAllField() {
        app.createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "email", "email2", "email3", "address", "home_tel", "mobile_tel", "work_tel", "fax", "1", "January", "2001"));
    }

    @Test
    public void canCreateContactWithAllEmptyField() {
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithNickNameOnly() {
        var emptyContact = new ContactData();
        var contactWithNickNameOnly = emptyContact.WithNickNameOnly("NickNameOnly");
        app.createContact(contactWithNickNameOnly);
    }
}
