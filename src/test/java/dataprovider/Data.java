package dataprovider;

import com.rd.manwoman.Man;
import org.testng.annotations.DataProvider;

import java.util.List;

import static utils.DBReader.getPersonFromDB;


public class Data {
    @DataProvider(name = "personFromDB")
    public static Object[][] personFromDB(){
        return getPersonFromDB().stream().map(man -> new Object[]{man.getFirstName(), man.getLastName(), man.getGender(), man.getAge(), man.getPartner()})
        .toArray(Object[][]::new);
    }
}

