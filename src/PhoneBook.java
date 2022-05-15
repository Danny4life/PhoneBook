import javax.swing.*;
import java.util.*;

// create individual info class
class IndividualInfo{
    String getContactName;
    String getContactAddress;
    String getContactPhoneNum;

    // create individual info constructor
    IndividualInfo(String name, String address, String phoneNum) {
        getContactName = name;
        getContactAddress = address;
        getContactPhoneNum = phoneNum;
    }

    // create display function using java swing GUI
    public void display() {
        JOptionPane.showMessageDialog(null,"Name:" + getContactName + "\n" +
                "Address:"  + getContactAddress + "\n" +
                "Phone Number:"  + getContactPhoneNum);
    }

}

// create store contact info class
class StoreContactInfo {
    ArrayList persons;

    // store contact info constructor
    StoreContactInfo() {
        persons = new ArrayList();
    }

    // adding a person object
    public void addPerson() {
        String name = JOptionPane.showInputDialog("Enter Your name:");
        String address = JOptionPane.showInputDialog("Enter Your Address:");
        String phoneNumber = JOptionPane.showInputDialog("Enter Your Phone Number:");

        // create person info object
        IndividualInfo person = new IndividualInfo(name, address, phoneNumber);

        // add person info into array list
        persons.add(person);
    }

    // search person
    public void searchPerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            IndividualInfo person = (IndividualInfo) persons.get(i);

            if (name.equals(person.getContactName) || name.equals(person.getContactPhoneNum)) {
                person.display();
            }
        }
    }

}


public class PhoneBook {
    public static void main(String[] args) {
        StoreContactInfo contactInfo = new StoreContactInfo();
        String input;
        String search;
        int ch;

        while (true) {
            input = JOptionPane.showInputDialog("Enter 1 to store contact information\nEnter 2 to retrieve contact information\nEnter 3 to Exit");
            ch = Integer.parseInt(input);


            switch (ch) {
                case 1:
                    contactInfo.addPerson();
                    break;

                case 2:
                    search = JOptionPane.showInputDialog("Enter contact name or phone number to search:");
                    contactInfo.searchPerson(search);
                    break;


                case 3:
                    System.exit(0);
            }
        }
    }

}
