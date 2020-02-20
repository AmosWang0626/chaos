package com.amos.design.creation.factory.method;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
@Data
@Accessors(chain = true)
public abstract class BaseOperation {

    private BigDecimal num1;
    private BigDecimal num2;

    public abstract BigDecimal getResult();

}
