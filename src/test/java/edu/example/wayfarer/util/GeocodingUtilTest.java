package edu.example.wayfarer.util;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GeocodingUtilTest {

    @Autowired
    private GeocodingUtil geocodingUtil;

    @Test
    @Order(1)
    public void testGeocoding() {
        String address = "서울특별시 종로구 세종대로 110)";

        String result = geocodingUtil.geocoding(address);

        System.out.println(result);
    }

    @Test
    @Order(2)
    public void testReverseGeocoding() {
        double lat = 37.5665;
        double lon = 126.9780;

        String result = geocodingUtil.reverseGeocoding(lat, lon);

        System.out.println(result);
    }
}
