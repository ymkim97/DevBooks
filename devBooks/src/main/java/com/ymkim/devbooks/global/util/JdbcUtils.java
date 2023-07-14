package com.ymkim.devbooks.global.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class JdbcUtils {
    private JdbcUtils() {}

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
