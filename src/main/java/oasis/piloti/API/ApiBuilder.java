package oasis.piloti.API;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


public class ApiBuilder {

    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";
    private static final String ERROR_STATUS = "error";

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ApiResponse<T> {
        private final String status;
        private final T response;
        private final String error;
    }
    // 성공 후 응답값 ( response ) 에 데이터를 넣고 싶을 때 사용
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS_STATUS, data, null);
    }
    // 성공 후 아무런 값도 넣지 않고 싶을 때 사용
    public static <T> ApiResponse<T> successWithNoContent() {
        return new ApiResponse<>(SUCCESS_STATUS, null, null);
    }
    // 실패 후 에러메시지를 넣고 싶을 때 사용
    public static ApiResponse<?> fail(Map<String, String> errors, String message) {
        return new ApiResponse<>(FAIL_STATUS, errors, message);
    }
    // 에러 발생 시 에러메시지를 넣고 싶을 때 사용
    public static ApiResponse<?> error(String message) {
        return new ApiResponse<>(ERROR_STATUS, null, message);
    }
}
