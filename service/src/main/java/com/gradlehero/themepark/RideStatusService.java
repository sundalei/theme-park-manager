package com.gradlehero.themepark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

public class RideStatusService {

    public static String getRideStatus(String ride) {
        List<String> rideStatuses = readFile(StringUtils.trim(String.format("%s.txt", ride)));
        return rideStatuses.get(new Random().nextInt(rideStatuses.size()));
    }

    private static List<String> readFile(String filename) {
        InputStream resourceStream = RideStatusService.class.getClassLoader().getResourceAsStream(filename);

        if (resourceStream == null) {
            throw new IllegalArgumentException("Ride not found.");
        }

        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedInputStream =
                     new BufferedReader(new InputStreamReader(resourceStream, StandardCharsets.UTF_8))) {
            while(bufferedInputStream.ready()) {
                result.add(bufferedInputStream.readLine());
            }

        } catch (IOException exception) {
            throw new RuntimeException("Could not read file", exception);
        }
        return result;
    }
}
