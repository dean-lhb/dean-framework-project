package org.deanframework.common.functional;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalFunction<T> {

    BigDecimal applyAsBigDecimal(T value);
}
