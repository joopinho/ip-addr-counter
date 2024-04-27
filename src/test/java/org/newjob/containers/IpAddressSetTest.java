package org.newjob.containers;

import org.junit.Test;

import java.util.Random;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.newjob.utils.IPAddressUtils.ipToLong;

public class IpAddressSetTest {
    @Test
    public void itShouldDeduplicateLongValues() {
        // given new empty set
        IpAddressSet underTestSet = new IpAddressSet();

        // when add some duplicated long values
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(50); i++) {
            underTestSet.add(1);
        }

        // then
        assertEquals(1, underTestSet.size());
    }

    @Test
    public void itShouldReturnCountUniqueValues() {
        // given new empty set
        IpAddressSet underTestSet = new IpAddressSet();

        // when add some unique long values
        LongStream.rangeClosed(1, 2000).boxed().forEach((underTestSet::add));

        // then
        assertEquals(2000, underTestSet.size());
    }

    @Test
    public void itShouldAddMinIPAddressLongValue() {
        // given new empty set
        IpAddressSet underTestSet = new IpAddressSet();

        // when add 1.1.1.1
        underTestSet.add(ipToLong("1.1.1.1"));

        // then
        assertEquals(1, underTestSet.size());
    }

    @Test
    public void itShouldAddMaxIPAddressLongValue() {
        // given new empty set
        IpAddressSet underTestSet = new IpAddressSet();

        // when add 255.255.255.255
        underTestSet.add(ipToLong("255.255.255.255"));

        // then
        assertEquals(1, underTestSet.size());
    }

    @Test
    public void itShouldAddLastIPAddressLongValue() {
        // given new empty set
        IpAddressSet underTestSet = new IpAddressSet();

        // when add 0.0.0.0
        underTestSet.add(ipToLong("0.0.0.0"));

        // then
        assertEquals(1, underTestSet.size());
    }
}