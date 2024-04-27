package org.newjob;

import org.newjob.containers.IpAddressSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.newjob.utils.IPAddressUtils.ipToLong;

public class Main {
    public static final String IP_ADDRESSES_FILE_PATH = "./ip_addresses/ip_addresses";

    public static void main(String[] args) {
        try {
            long uniqueCount = calculateUniqueIPAddressCount(IP_ADDRESSES_FILE_PATH);
            System.out.printf("[%s][INFO] total count unique ip addresses: %d", LocalDateTime.now(), uniqueCount);
        } catch (RuntimeException e) {
            System.out.printf("[%s][ERROR] error calculating unique ip addresses count: %s", LocalDateTime.now(), e.getMessage());
        }
    }

    private static long calculateUniqueIPAddressCount(String filePath) {
        System.out.printf("[%s][INFO] opening a connection to file: %s\n", LocalDateTime.now(), filePath);
        try (FileReader fileReader = new FileReader(filePath)) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                IpAddressSet ipAddressSet = new IpAddressSet();
                System.out.printf("[%s][INFO] starting read file line by line\n", LocalDateTime.now());
                while ((line = bufferedReader.readLine()) != null) {
                    ipAddressSet.add(ipToLong(line));
                }
                return ipAddressSet.size();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}