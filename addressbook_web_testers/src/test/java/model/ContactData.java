package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String email,
                          String email2, String email3, String address, String home_tel, String mobile_tel,
                          String work_tel, String fax, String day, String month, String year) {
    public ContactData() {
        this("", "", "", "",
             "","", "", "", "", "",
             "", "", "", "", "");
    }

    public ContactData WithNickNameOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.email,
                this.email2, this.email3, this.address, this.home_tel, this.mobile_tel,
                this.work_tel, this.fax, this.day, this.month, this.year);
    }
}