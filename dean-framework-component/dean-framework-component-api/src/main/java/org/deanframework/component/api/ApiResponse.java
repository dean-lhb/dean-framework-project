package org.deanframework.component.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther Dean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Integer code;
    private String message;
    private Object data;

    public static ApiResponse create(Integer code, String message) {
        return create(code, message, null);
    }

    public static ApiResponse create(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }
}
