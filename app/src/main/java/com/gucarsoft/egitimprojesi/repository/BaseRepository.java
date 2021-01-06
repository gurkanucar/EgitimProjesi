package com.gucarsoft.egitimprojesi.repository;

import android.database.SQLException;

import java.util.List;

public interface BaseRepository<T> {

    void create(T object) throws SQLException ;

    void update(T object) throws SQLException ;

    void delete(int id) throws SQLException ;

    List<T> listAll() throws SQLException ;

    T findByID(int id) throws SQLException ;


}
