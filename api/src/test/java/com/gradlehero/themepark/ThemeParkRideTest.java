package com.gradlehero.themepark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThemeParkRideTest {

    @Test
    public void setFieldsCorrectly() {
        ThemeParkRide themeParkRide = new ThemeParkRide("Ride name", "description",
                "status", "some/path.jpg");
        assertEquals("Ride name", themeParkRide.name());
        assertEquals("description", themeParkRide.description());
        assertEquals("status", themeParkRide.status());
        assertEquals("some/path.jpg", themeParkRide.imagePath());
    }
}
