package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 기본 구분자 테스트
    @Test
    void 빈_문자열_입력시_0_반환() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 쉼표_구분자_덧셈() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 쉼표_구분자_여러_숫자_덧셈() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론_구분자_덧셈() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표_콜론_혼합_구분자_덧셈() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자 테스트
    @Test
    void 커스텀_구분자_세미콜론_덧셈() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_단일_숫자() {
        assertSimpleTest(() -> {
            run("//;\\n5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 커스텀_구분자_복잡한_문자() {
        assertSimpleTest(() -> {
            run("//***\\n1***2***3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 실수형 입력 테스트
    @Test
    void 실수형_입력_반올림() {
        assertSimpleTest(() -> {
            run("1.5,2.7");
            assertThat(output()).contains("결과 : 4.2");
        });
    }

    @Test
    void 실수형_입력_반올림_세_번째_자리() {
        assertSimpleTest(() -> {
            run("1.556,2.444");
            assertThat(output()).contains("결과 : 4");
        });
    }

    // 예외 처리 테스트
    @Test
    void 음수_입력시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 혼합_음수_입력시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 특수문자_입력시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,@,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 경계값 테스트
    @Test
    void 큰_숫자_덧셈() {
        assertSimpleTest(() -> {
            run("100,200,300");
            assertThat(output()).contains("결과 : 600");
        });
    }

    @Test
    void 소수점_0_입력() {
        assertSimpleTest(() -> {
            run("1.0,2.0");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_점_사용시_실수_처리() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}