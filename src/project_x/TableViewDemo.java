
package project_x;

public class TableViewDemo {
    String firstName,lastName,gender,phoneNumber,region,city,woreda,houseNumber;
 Integer id;
    public TableViewDemo(Integer id,String firstName, String lastName, String gender, String phoneNumber, String region,
            String city, String woreda, String houseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.city = city;
        this.woreda = woreda;
        this.houseNumber = houseNumber;
        this.id=id;
    }

    public Integer getId() {
        return id;
    }
    

   

   

    public String getWoreda() {
        return woreda;
    }

    public String getRegion() {
        return region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }
    
}
