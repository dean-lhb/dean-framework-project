package org.deanframework.component.idgenerator.config;

import org.deanframework.component.idgenerator.util.IdGeneratorUtil;

/**
 * @auther Dean
 */
public class IdGeneratorConfig {

    private int machineId = 1;
    private int maxMachineBit = 11;
    private int maxSequenceBit = 11;
    private long epoch = 1356969600000L;
    private final int maxBit = 63;
    private final int maxTimestampBit = 41;
    private final int maxMachineId = IdGeneratorUtil.bitConvert(maxMachineBit);
    private final int maxSequence = IdGeneratorUtil.bitConvert(maxSequenceBit);
    private final int timestampLeftShiftBit = maxMachineBit + maxSequenceBit;
    private final int machineLeftShiftBit = maxSequenceBit;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public int getMaxMachineBit() {
        return maxMachineBit;
    }

    public void setMaxMachineBit(int maxMachineBit) {
        this.maxMachineBit = maxMachineBit;
    }

    public int getMaxSequenceBit() {
        return maxSequenceBit;
    }

    public void setMaxSequenceBit(int maxSequenceBit) {
        this.maxSequenceBit = maxSequenceBit;
    }

    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public int getMaxBit() {
        return maxBit;
    }

    public int getMaxTimestampBit() {
        return maxTimestampBit;
    }

    public int getMaxMachineId() {
        return maxMachineId;
    }

    public int getMaxSequence() {
        return maxSequence;
    }

    public int getTimestampLeftShiftBit() {
        return timestampLeftShiftBit;
    }

    public int getMachineLeftShiftBit() {
        return machineLeftShiftBit;
    }
}
