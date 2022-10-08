package com.example.jwt.constant;

public enum UserErrorCode {
    MISSING_FULLNAME_FIELD(0, "Họ và tên là bắt buộc"),
    MISSING_USERNAME_FIELD(0, "Tên người dùng là bắt buộc"),
    MISSING_EMAIL_FIELD(0, "Địa chỉ email là bắt buộc"),
    ORGANIZATION_INVALID(0, "Id tổ chức không hợp lệ"),
    LOCATION_INVALID(0, " Id chi nhánh không hợp lệ"),
    EMAIL_INVALID(0, "Địa chỉ email không hợp lệ"),
    EMAIL_EXISTED(0, "Địa chỉ email đã được sử dụng"),
    USERNAME_EXISTED(0, "Tên người dùng đã được sử dụng"),
    LIST_ROLE_INVALID(0, "Danh sách quyền không hợp lệ"),
    CAN_NOT_DELETE_USER(0, "Không thể xóa tài khoản"),
    USER_NOT_EXIST(0, "Người dùng không tồn tại"),
    CAN_NOT_ADD_USER(0, "Tên tài khoản đã được sử dụng"),
    PERMISSION_DENIED(0, "Bạn không có quyền thực hiện chức năng này"),
    SUCCESS(1, "Success"),
    FAIL(0, "Fail"),
    MISSING_FILE_FIELD(0, "File là bắt buộc"),
    UN_SUPPORT_FILE_UPLOAD(0, "File tải lên không được"),
    CAN_NOT_GET_ORGANIZATION(0, "Không thể lấy thông tin tổ chức"),
    INTERNAL_ERROR(0, "Có lỗi xảy ra, hãy thử lại sau!");

    private final int code;
    private String message;

    UserErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
