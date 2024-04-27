package org.newjob.utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.newjob.utils.IPAddressUtils.ipToLong;

public class IPAddressUtilsTest {
    @Test
    public void itShouldReturnLongRepresentationOfStringIPAddress() {
        assertEquals(16843009L, ipToLong("1.1.1.1"));
        assertEquals(1701143909L, ipToLong("101.101.101.101"));
        assertEquals(185273099L, ipToLong("11.11.11.11"));
        assertEquals(4294967295L, ipToLong("255.255.255.255"));

    }
}