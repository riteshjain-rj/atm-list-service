package com.atm.list.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

public class TestUtils {

    public static <T extends Object> T getObjectFromJson (final String filePath, Class<T> type, ResourceLoader loader) throws IOException {
        return new ObjectMapper().readValue(loader.getResource(filePath).getFile(), type);
    }
}
