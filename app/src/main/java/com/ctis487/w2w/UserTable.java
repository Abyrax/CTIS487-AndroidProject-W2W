package com.ctis487.w2w;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;

public class UserTable {
    public static final String TABLE_NAME="users";
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_USERNAME = "Username";
    public static final String FIELD_PSW = "Password";

    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_NAME
            +" text, "+FIELD_USERNAME+" text, "+FIELD_PSW+" number);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<Users> getAllMedia (DatabaseHelper db){
        Cursor cursor = db.getAllRecords(TABLE_NAME, null);
        //Cursor cursor  db.getAllRecordsMethod2("SELECT * FROM "+TABLE_NAME, null)
        ArrayList<Users> data=new ArrayList<>();
        Users us = null;
        while (cursor.moveToNext()) {
            String Name = cursor.getString(0);
            String Username = cursor.getString(1);
            String Password = cursor.getString(2);

            us = new Users(Name,Username,Password);
            data.add(us);
        }
        return data;
    }

    public static ArrayList<Users> findUser(DatabaseHelper db, String key){
        String where = FIELD_NAME+" like '%"+key+"%'";
        Cursor cursor = db.getSomeRecords(TABLE_NAME,null, where);
        ArrayList<Users> data=new ArrayList<>();
        Users us = null;
        while (cursor.moveToNext()) {
            String Name = cursor.getString(0);
            String Username = cursor.getString(1);
            String Password = cursor.getString(2);

            us = new Users(Name,Username,Password);
            data.add(us);
        }
        return data;
    }

    public static boolean insertUser(DatabaseHelper db, String Name, String Username, String Password){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, Name);
        contentValues.put(FIELD_USERNAME, Username);
        contentValues.put(FIELD_PSW, Password);

        boolean res = db.insert(TABLE_NAME,contentValues);

        return res;
    }

    public static boolean insertUser(DatabaseHelper db, Users us){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, us.getName());
        contentValues.put(FIELD_USERNAME, us.getUsername());
        contentValues.put(FIELD_PSW, us.getPsw());

        boolean res = db.insert(TABLE_NAME,contentValues);

        return res;
    }

    public static boolean updateUser(DatabaseHelper db, String Name, String Username, String Password){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, Name);
        contentValues.put(FIELD_USERNAME,Username);
        contentValues.put(FIELD_PSW,Password);
        String where = FIELD_USERNAME +" = "+Username;

        boolean res = db.update(TABLE_NAME,contentValues,where);

        return res;
    }

    public static boolean updateUser(DatabaseHelper db, Users us){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, us.getName());
        contentValues.put(FIELD_USERNAME,us.getUsername());
        contentValues.put(FIELD_PSW,us.getPsw());
        String where = FIELD_USERNAME +" = "+us.getUsername();

        boolean res = db.update(TABLE_NAME,contentValues,where);

        return res;
    }

    public static boolean deleteUser (DatabaseHelper db, String Username){
        String where = FIELD_USERNAME +" = "+ Username;
        boolean res = db.delete(TABLE_NAME,where);
        return res;
    }
}
