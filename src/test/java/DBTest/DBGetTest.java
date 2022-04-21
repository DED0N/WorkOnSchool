package DBTest;

import db.DBHelper;
import org.testng.annotations.Test;

public class DBGetTest {
    @Test
    public void startTest() {

        String getFromBD = "SELECT * FROM REGISTRATION";

        DBHelper.insertIntoBD(5455, "Dobrynia2", "qwerty1337", 25);

        DBHelper.getSqlResult(getFromBD).forEach(s -> System.out.println(s));
        DBHelper.isExist(5455);
        //System.out.println(DBHelper.getValueFirstRow(sql, "first"));
    }
}
