package com.gucarsoft.egitimprojesi.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.gucarsoft.egitimprojesi.model.SoruModel;
import java.util.ArrayList;
import java.util.List;

public class SoruRepository implements BaseRepository<SoruModel> {


    private String[] COLUMNS = {"id","name","goal","done"};
    private String TABLE_NAME = "Sorular";
    private DataBase dataBase;
    private SQLiteDatabase sqLiteDatabase;

    public SoruRepository(Context context) {
        dataBase = new DataBase(context);
    }

    @Override
    public List<SoruModel> listAll() throws SQLException {
        sqLiteDatabase = dataBase.getReadableDatabase();
        List<SoruModel> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            SoruModel entity = new SoruModel();
            entity.setId(cursor.getInt((cursor.getColumnIndex(COLUMNS[0]))));
            entity.setName(cursor.getString(cursor.getColumnIndex(COLUMNS[1])));
            entity.setGoal(cursor.getInt(cursor.getColumnIndex(COLUMNS[2])));
            entity.setDone(cursor.getInt(cursor.getColumnIndex(COLUMNS[3])));
            list.add(entity);
        }
        return list;
    }

    @Override
    public SoruModel findByID(int id) throws SQLException {
        sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        SoruModel entity = new SoruModel();
        while (cursor.moveToNext()){
            if(cursor.getInt((cursor.getColumnIndex(COLUMNS[0])))==id) {
                entity.setId(cursor.getInt((cursor.getColumnIndex(COLUMNS[0]))));
                entity.setName(cursor.getString(cursor.getColumnIndex(COLUMNS[1])));
                entity.setGoal(cursor.getInt(cursor.getColumnIndex(COLUMNS[2])));
                entity.setDone(cursor.getInt(cursor.getColumnIndex(COLUMNS[3])));
                return entity;
            }
        }
        return null;
    }


    @Override
    public void create(SoruModel object) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[1], object.getName());
        contentValues.put(COLUMNS[2], object.getGoal());
        contentValues.put(COLUMNS[3], object.getDone());
        sqLiteDatabase.insertOrThrow(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    @Override
    public void update(SoruModel object) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS[1], object.getName());
        contentValues.put(COLUMNS[2], object.getGoal());
        contentValues.put(COLUMNS[3], object.getDone());
        sqLiteDatabase.update(TABLE_NAME, contentValues, "id=" + object.getId(), null);
    }

    @Override
    public void delete(int id) throws SQLException {
        sqLiteDatabase = dataBase.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "id=" + id, null);
    }
}
