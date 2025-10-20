package calculator.enums;

public enum Message {
    INIT("덧셈할 문자열을 입력해 주세요."),
    RESULT("결과 : "),
    ILLEGAL_NUMBER_FORMAT("올바른 숫자 형식이 아닙니다"),
    EMPTY_DELIMITER("구분자가 비어있습니다."),
    NOT_POSITIVE("숫자가 양수가 아닙니다."),
    INVALID_PATTERN("잘못된 커스텀 구분자 형식입니다");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }
}