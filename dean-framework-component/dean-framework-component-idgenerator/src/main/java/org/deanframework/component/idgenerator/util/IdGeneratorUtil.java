package org.deanframework.component.idgenerator.util;

import org.deanframework.component.idgenerator.config.IdGeneratorConfig;
import org.deanframework.component.idgenerator.exception.IdGeneratorException;

/**
 * @auther Dean
 */
public class IdGeneratorUtil {

    public static int bitConvert(int bit) {
        return (int) Math.pow(2, bit) - 1;
    }

    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    public static void checkConfig(IdGeneratorConfig idGeneratorConfig) {
        if (idGeneratorConfig.getMaxSequenceBit() < 1) {
            throw new IdGeneratorException("ID生成组件序号长度必须大于0！");
        }
        if (idGeneratorConfig.getMaxBit() != (idGeneratorConfig.getMaxTimestampBit() + idGeneratorConfig.getMaxMachineBit() + idGeneratorConfig.getMaxSequenceBit())) {
            throw new IdGeneratorException("ID生成组件参数长度设置不正确！");
        }
        if (idGeneratorConfig.getMachineId() > idGeneratorConfig.getMaxMachineId()) {
            throw new IdGeneratorException("machineId超过最大值！");
        }
    }

    public static void checkTime(long currentTimestamp, long lastTimestamp) {
        if (currentTimestamp < lastTimestamp) {
            throw new IdGeneratorException("时钟倒退");
        }
    }
}
