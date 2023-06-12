package testcases;


import com.rd.manwoman.Man;
import com.rd.manwoman.Person;
import com.rd.manwoman.Woman;
import dataprovider.Data;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestPerson {
    SoftAssert softAssert = new SoftAssert();
    @Test(dataProvider = "personFromDB", dataProviderClass = Data.class)
    public void testGetterCreateObject(String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        softAssert.assertEquals(man.getFirstName(), firstNameMan, "Problems with first names getter");
        softAssert.assertEquals(man.getLastName(), lastNameMan, "Problems with last names getter");
        softAssert.assertEquals(man.getGender(), genderMan, "Problems with genders getter");
        softAssert.assertEquals(man.getAge(), ageMan, "Problems with age getter");
        softAssert.assertEquals(man.getPartner(), partnerMan, "Problems with partners getter");
        softAssert.assertAll();
    }
    @Test(dataProvider = "personFromDB", dataProviderClass = Data.class)
    public void testSetterCreateObject(String setFirstName, String setLastName, String setGender, int setAge, String setPartner){
        Man man = new Man("firstName", "lastName", "genderMan", 0, "partner");
        man.setFirstName(setFirstName);
        softAssert.assertEquals(man.getFirstName(), setFirstName, "Problems with setter of first name");
        man.setLastName(setLastName);
        softAssert.assertEquals(man.getLastName(), setLastName, "Problems with setter of last name");
        man.setGender(setGender);
        softAssert.assertEquals(man.getGender(), setGender, "Problems with setter of gender");
        man.setAge(setAge);
        softAssert.assertEquals(man.getAge(), setAge, "Problems with setter of age");
        man.setPartner(setPartner);
        softAssert.assertEquals(man.getPartner(), setPartner, "Problems with setter of Partner");
        softAssert.assertAll();
    }
    @Test(dataProvider = "manWoman", dataProviderClass = Data.class)
    public void testRegisterPartnership (String firstNameWoman, String lastNameWoman, String genderWoman, int ageWoman, String partnerWoman, String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Woman woman = new Woman(firstNameWoman, lastNameWoman, genderWoman, ageWoman, partnerWoman);
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        woman.registerPartnership(man);
        Assert.assertEquals(man.getLastName(), woman.getLastName(), "Problems with register partnership method");
    }
    @Test(dataProvider = "manWoman", dataProviderClass = Data.class)
    public void testDeregisterPartnership (String firstNameWoman, String lastNameWoman, String genderWoman, int ageWoman, String partnerWoman, String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Woman woman = new Woman(firstNameWoman, lastNameWoman, genderWoman, ageWoman, partnerWoman);
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        String previousLastName = lastNameWoman;
        woman.registerPartnership(man);
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getLastName(), previousLastName, "Problems with deregister of partnership method");
    }

    @Test(dataProvider = "personFromDB", dataProviderClass = Data.class)
    public void testSetRetired(String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        Assert.assertTrue(man.isRetired(), "Problems with retired setter method");
    }
}
