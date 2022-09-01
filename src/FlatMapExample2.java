import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample2 {

    public static void main(String[] args) {

        Address address1 = new Address(444505,"Kale File","Washim");
        Address address2 = new Address(444507,"Sawata Mali Chowk","Ansing");
        Address address3 = new Address(431606,"Vishnupuri","Nanded");
        Address address4 = new Address(555555,"Sewagram","Wardha");

        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(address1);
        addressList1.add(address2);
        addressList1.add(address3);

        List<Address> addressList2 = new ArrayList<>();
        addressList1.add(address1);
        addressList1.add(address2);
        addressList1.add(address4);

        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Shreekhand",addressList1));
        userList.add(new User(2,"Gajanan",addressList2));

        Set<Integer> distinctPinCode = userList.stream().flatMap(u->u.getAddressList().stream()).map(a-> a.getPinCode()).collect(Collectors.toSet());
        Long distinctPinCodeCount = userList.stream().flatMap(u->u.getAddressList().stream()).map(a-> a.getPinCode()).collect(Collectors.toSet()).stream().collect(Collectors.counting());
        System.out.println("Distinct PINCODES => "+distinctPinCode);
        System.out.println("Distinct PINCODE Count =>"+distinctPinCodeCount);
    }

}

class User {
    private int userId;
    private String userName;
    private List<Address> addressList;

    public User(int userId, String userName, List<Address> addressList) {
        this.userId = userId;
        this.userName = userName;
        this.addressList = addressList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}



class Address {
    private int pinCode;
    private String addressLine1;
    private String addressLine2;


    public Address(int pinCode, String addressLine1, String addressLine2) {
        this.pinCode = pinCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}