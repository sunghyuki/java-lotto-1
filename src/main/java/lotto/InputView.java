package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NOT_DIGIT_MESSAGE = "[ERROR] 입력 값은 숫자가 아닙니다.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String WHITESPACE = "\\s";
    private static final String EMPTY = "";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateIsDigit(input);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        String input = Console.readLine();
        return parse(input);
    }

    private static void validateIsDigit(String input) {
        char[] inputs = input.toCharArray();
        for (char character : inputs) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(INPUT_NOT_DIGIT_MESSAGE);
            }
        }
    }

    private static List<Integer> parse(String input) {
        return Arrays.stream(split(removeBlank(input)))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        return input.split(COMMA);
    }

    private static String removeBlank(String input) {
        return input.replaceAll(WHITESPACE, EMPTY);
    }
}
