package org.example;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class DBSingleton {

    private static final Map<String, DB<?>> dbMap = new ConcurrentHashMap<>();

    public static synchronized <T> DB<T> getDb(Class<T> type) throws Exception {
        if (!dbMap.containsKey(type.getSimpleName())) {
            dbMap.put(type.getSimpleName(), new DB<>(type));
        }
        return (DB<T>) dbMap.get(type.getSimpleName());
    }

    public static synchronized void saveAll() throws Exception {
        for (Map.Entry<String, DB<?>> entry : dbMap.entrySet()) {
            entry.getValue().save();
        }
    }
}
