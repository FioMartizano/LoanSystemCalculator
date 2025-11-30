package com.example.loansystemcalculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "loan_db";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) { //dadagdagan and ayos pa
        db.execSQL("CREATE TABLE loan_table (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "applicationID TEXT," +
                "email TEXT," +
                "loanType TEXT," +
                "loanAmount NUMBER," +
                "dateApproved NUMBER," +
                "status TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS loan_table");
        onCreate(db);
    }

    //to get the ApprovedLoans ONLY
    public Cursor getApprovedLoans() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM loan_table WHERE status = 'Approved'", null);
    }
}
