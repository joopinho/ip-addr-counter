package org.newjob.containers;

import java.util.BitSet;

public class IpAddressSet {
    private final BitSet[] bits;

    private long size;

    public IpAddressSet() {
        this.bits = new BitSet[]{new BitSet(Integer.MAX_VALUE), new BitSet(Integer.MAX_VALUE)};
        this.size = 0;
    }

    public void add(long ip) {
        int setIndex = chooseBitSet(ip);
        int bitIndex = ipToBitSetIndex(ip);

        if (!this.bits[setIndex].get(bitIndex)) {
            this.bits[setIndex].set(bitIndex);
            this.size++;
        }
    }

    private int chooseBitSet(long i) {
        if ((int) i < 0) {
            return 0;
        }
        return 1;
    }

    private int ipToBitSetIndex(long ip) {
        int res  = (int) ip;
        if (res < 0) {
            return res * (-1);
        }
        return res;
    }

    public long size() {
        return this.size;
    }
}


