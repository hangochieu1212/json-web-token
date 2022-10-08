package com.example.jwt.util;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateField {
    public boolean validField(String value, String patternString) {
        Pattern pattern = Pattern.compile("^" + patternString + "$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public boolean validEmail(String email) {
        return validField(email, "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    }

//    public boolean validFile(MultipartFile file, String type) {
//        if (file == null) {
//            throw new AccountRestApiException(UserErrorCode.MISSING_FILE_FIELD);
//        }
//        String[] tmp = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
//        String extension = tmp[tmp.length - 1];
//        if (Objects.equals(type, Const.IMAGE_TYPE)) {
//            if (extension == null
//                    || (!Objects.equals(extension.toLowerCase(), "jpg")
//                    && !Objects.equals(extension.toLowerCase(), "png")
//                    && !Objects.equals(extension.toLowerCase(), "jpeg"))) {
//                throw new AccountRestApiException(UserErrorCode.UN_SUPPORT_FILE_UPLOAD);
//            }
//        } else if (Objects.equals(type, Const.EXCEL_TYPE)) {
//            if (extension == null
//                    || (!Objects.equals(extension.toLowerCase(), "xlsx"))) {
//                throw new AccountRestApiException(UserErrorCode.UN_SUPPORT_FILE_UPLOAD);
//            }
//        }
//        return true;
//    }

//    public boolean validStringArray(String strings) {
//        return validField(strings, "\\[[\"aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n" +
//                "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n" +
//                "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ, ]+\\]");
//    }

    public boolean validPassword(String password) {
        return validField(password, "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
    }

    public boolean validUsername(String username) {
        return validField(username, "[a-zA-Z0-9]{" + 5 + ",}");
    }

}
