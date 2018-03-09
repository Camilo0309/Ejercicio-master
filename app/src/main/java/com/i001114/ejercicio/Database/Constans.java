package com.i001114.ejercicio.Database;

/**
 * Created by camilo on 28/02/18.
 */

public class Constans {

    //BASE DE DATOS USUARIO
    public static final String TABLE_NAME_USERS = "users";
    public static final String TABLE_FIELD_USER_ID = "id";
    public static final String TABLE_FIELD_USER_USERNAME = "username";
    public static final String TABLE_FIELD_USER_EMAIL = "email";
    public static final String TABLE_FIELD_USER_PASSWORD = "password";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLE_NAME_USERS+" ("+
                    TABLE_FIELD_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_USER_USERNAME+" TEXT, "+
                    TABLE_FIELD_USER_EMAIL+" TEXT,"+
                    TABLE_FIELD_USER_PASSWORD+" TEXT) ";


}
