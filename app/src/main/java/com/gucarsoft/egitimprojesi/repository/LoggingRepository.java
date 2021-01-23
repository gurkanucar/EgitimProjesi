package com.gucarsoft.egitimprojesi.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.gucarsoft.egitimprojesi.model.LogModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoggingRepository implements BaseRepository<LogModel> {


    private String[] COLUMNS = {"id","title","detail","date"};
    private String TABLE_NAME = "Logs";
    private DataBase dataBase;
    private SQLiteDatabase sqLiteDatabase;

    public LoggingRepository(Context context) {
        dataBase = new DataBase(context);
    }

    @Override
    public List<LogModel> listAll() throws SQLException {
        sqLiteDatabase = dataBase.getReadableDatabase();
        List<LogModel> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            LogModel entity = new LogModel();
            entity.setId(cursor.getInt((cursor.getColumnIndex(COLUMNS[0]))));
            entity.setTitle(cursor.getString(cursor.getColumnIndex(COLUMNS[1])));
            entity.setDetail(cursor.getString(cursor.getColumnIndex(COLUMNS[2])));
            entity.setDate(cursor.getString(cursor.getColumnIndex(COLUMNS[3])));
            list.add(entity);
        }
        return list;
    }

    @Override
    public LogModel findByID(int id) throws SQLException {
        sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        LogModel entity = new LogModel();
        while (cursor.moveToNext()){
            if(cursor.getInt((cursor.getColumnIndex(COLUMNS[0])))==id) {
                entity.setId(cursor.getInt((cursor.getColumnIndex(COLUMNS[0]))));
                entity.setTitle(cursor.getString(cursor.getColumnIndex(COLUMNS[1])));
                entity.setDetail(cursor.getString(cursor.getColumnIndex(COLUMNS[2])));
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateString = cursor.getString(cursor.getColumnIndex(COLUMNS[3]));
                entity.setDate(formatter.format(dateString));
                return entity;
            }
        }
        return null;
    }


    @Override
    public void create(LogModel object) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[1], object.getTitle());
        contentValues.put(COLUMNS[2], object.getDetail());
        contentValues.put(COLUMNS[3], (String.valueOf(object.getDate())));
        sqLiteDatabase.insertOrThrow(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    @Override
    public void update(LogModel object) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[1], object.getTitle());
        contentValues.put(COLUMNS[2], object.getDetail());
        contentValues.put(COLUMNS[3], object.getDate());
        sqLiteDatabase.update(TABLE_NAME, contentValues, "id=" + object.getId(), null);
    }

    @Override
    public void delete(int id) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "id=" + id, null);
    }
}
