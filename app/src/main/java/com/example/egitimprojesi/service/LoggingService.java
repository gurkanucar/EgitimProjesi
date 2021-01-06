package com.example.egitimprojesi.service;

import android.content.Context;

import com.example.egitimprojesi.model.LogModel;
import com.example.egitimprojesi.repository.LoggingRepository;

import java.util.List;

public class LoggingService {
    public static void createLog(Context context, String title, String detail) {
        LoggingRepository loggingRepository = new LoggingRepository(context);
        LogModel logModel = new LogModel.Builder().title(title).detail(detail).build();
        loggingRepository.create(logModel);
    }

    public static void deleteAll(Context context) {
        LoggingRepository loggingRepository = new LoggingRepository(context);
        List<LogModel> logModels = (List<LogModel>) (Object) loggingRepository.listAll();
        for (LogModel logModel : logModels) {
            loggingRepository.delete(logModel.getId());
        }
    }

    public static void deleteLast10(Context context) {
        LoggingRepository loggingRepository = new LoggingRepository(context);
        List<LogModel> logModels = (List<LogModel>) (Object) loggingRepository.listAll();
        for (int i = 0; i < 10; i++) {
            loggingRepository.delete(logModels.get(i).getId());
        }
    }
}
