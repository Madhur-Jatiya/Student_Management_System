package Student_Management_System;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Dao dao = new Dao();
//        dao.addStudent();
        dao.getData();
    }
}
