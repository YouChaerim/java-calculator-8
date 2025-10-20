package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 연속된_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정규식_특수문자_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 허용되지_않은_문자_포함시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식_오류시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1:2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
