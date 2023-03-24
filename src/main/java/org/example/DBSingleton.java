package org.example;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class DBSingleton {

    private static final Map<String, DB<?>> dbMap = new ConcurrentHashMap<>();

    //Create new data store and get data store based on class name
    public static synchronized <T> DB<T> getDb(Class<T> type) {
        if (!dbMap.containsKey(type.getSimpleName())) {
            dbMap.put(type.getSimpleName(), new DB<>(type));
        }
        return (DB<T>) dbMap.get(type.getSimpleName());
    }

    public static synchronized void saveAll() {
        for (Map.Entry<String, DB<?>> entry : dbMap.entrySet()) {
            entry.getValue().save();
        }
    }
}
