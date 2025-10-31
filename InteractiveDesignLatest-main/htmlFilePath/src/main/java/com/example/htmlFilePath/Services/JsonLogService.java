package com.example.htmlFilePath.Services;


import com.example.htmlFilePath.Dto.JsonLog;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonLogService {

    private static final String LOG_DIR = "errorlogs";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public synchronized List<JsonLog> saveLogs(List<String> messages) throws IOException {
        LocalDate today = LocalDate.now();
        String dateStr = today.toString();

        // Ensure log directory exists
        File dir = new File(LOG_DIR);
        if (!dir.exists()) dir.mkdirs();

        // Target file
        File file = new File(LOG_DIR + "/" + dateStr + ".json");
        List<JsonLog> logs = new ArrayList<>();

        // If file already exists, load existing logs
        if (file.exists()) {
            logs = objectMapper.readValue(file, new TypeReference<List<JsonLog>>() {});
        }

        List<JsonLog> newLogs = new ArrayList<>();

        for (String message : messages) {
            String timeStr = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String uid = dateStr + "-" + (logs.size() + 1);

            JsonLog log = new JsonLog(uid, dateStr, timeStr, message);
            logs.add(log);
            newLogs.add(log);
        }

        // Save back to file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, logs);

        return newLogs;
    }

    public List<JsonLog> getLogs(String fromDateStr, String toDateStr) throws IOException {
        LocalDate fromDate = fromDateStr == null ? LocalDate.now() : LocalDate.parse(fromDateStr);
        LocalDate toDate = toDateStr == null ? LocalDate.now() : LocalDate.parse(toDateStr);

        List<JsonLog> result = new ArrayList<>();

        for (LocalDate date = fromDate; !date.isAfter(toDate); date = date.plusDays(1)) {
            File file = new File(LOG_DIR + "/" + date.toString() + ".json");
            if (file.exists()) {
                List<JsonLog> dailyLogs = objectMapper.readValue(file, new TypeReference<List<JsonLog>>() {});
                result.addAll(dailyLogs);
            }
        }
        return result;
    }
}
