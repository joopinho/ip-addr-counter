package org.newjob.utils;

public final class IPAddressUtils {


    public static long ipToLong(String ip) {
        long result = 0L;
        int octetStartIndex = 0;
        int octetEndIndex;
        for (long i = 0; i < 4; i++) {
            octetEndIndex = ip.indexOf('.', octetStartIndex);
            if (octetEndIndex < 0) {
                octetEndIndex = ip.length();
            }

            long j = Integer.parseInt(ip, octetStartIndex, octetEndIndex, 10);
            result |= j << (24L - (8L * i));

            octetStartIndex = octetEndIndex + 1;
        }
        return result;
    }
}
