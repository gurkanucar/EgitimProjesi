package com.example.egitimprojesi.repository;

import android.database.SQLException;

import java.util.List;

public interface BaseRepository {

    void create(Object object) throws SQLException ;

    void update(Object object) throws SQLException ;

    void delete(int id) throws SQLException ;

    List<Object> listAll() throws SQLException ;

    Object findByID(int id) throws SQLException ;


}
