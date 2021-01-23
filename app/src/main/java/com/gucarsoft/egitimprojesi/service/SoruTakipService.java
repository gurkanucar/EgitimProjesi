package com.gucarsoft.egitimprojesi.service;

import android.content.Context;

import com.gucarsoft.egitimprojesi.model.SoruModel;
import com.gucarsoft.egitimprojesi.repository.SoruRepository;

import java.util.Collections;
import java.util.List;

public class SoruTakipService {
    public static void create(Context context,String name, int goal,int done){
        SoruRepository soruRepository = new SoruRepository(context);
        SoruModel soruModel= new SoruModel.Builder().name(name).goal(goal).done(done).build();
        soruRepository.create(soruModel);
    }

    public static List<SoruModel> findAll(Context context){
        SoruRepository soruRepository = new SoruRepository(context);
       List<SoruModel> list = soruRepository.listAll();
       Collections.reverse(list);
        return list;
    }


    public static void update(Context context,SoruModel entity){
        SoruRepository soruRepository = new SoruRepository(context);
        soruRepository.update(entity);
    }


    public static void delete(Context context,int id){
        SoruRepository soruRepository = new SoruRepository(context);
        soruRepository.delete(id);
    }



}
