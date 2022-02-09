package org.deanframework.component.idgenerator;

import org.deanframework.component.idgenerator.base.Id;
import org.deanframework.component.idgenerator.config.IdGeneratorConfig;
import org.deanframework.component.idgenerator.util.IdGeneratorUtil;

/**
 * @auther Dean
 */
public class IdGenerator implements Id {

    private int sequence;
    private long lastTimestamp = 0;
    private IdGeneratorConfig idGeneratorConfig;

    public IdGenerator(IdGeneratorConfig idGeneratorConfig) {
        this.idGeneratorConfig = idGeneratorConfig;
        IdGeneratorUtil.checkConfig(idGeneratorConfig);
    }

    @Override
    public synchronized long getUnique() {
        long currentTimestamp = IdGeneratorUtil.getTimestamp();
        IdGeneratorUtil.checkTime(currentTimestamp, lastTimestamp);
        if (currentTimestamp == lastTimestamp) {
            ++sequence;
            if (sequence > idGeneratorConfig.getMaxSequence()) {
                while (currentTimestamp <= lastTimestamp) {
                    currentTimestamp = IdGeneratorUtil.getTimestamp();
                }
                sequence = 0;
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = currentTimestamp;
        return ((currentTimestamp - idGeneratorConfig.getEpoch()) << idGeneratorConfig.getTimestampLeftShiftBit()) |
                (idGeneratorConfig.getMachineId() << idGeneratorConfig.getMachineLeftShiftBit()) | sequence;
    }

    public String getUniqueForString() {
        return String.valueOf(getUnique());
    }
}

