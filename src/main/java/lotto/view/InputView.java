package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;


public class InputView {
    /* 구입 금액 입력 */
    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();
                validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        try {
            int amount = Integer.parseInt(purchaseAmount);
            if (amount <= 0) {
                throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("구매 금액은 1000 단위로 나누어 떨어져야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        }
    }

    /* 당첨 금액 입력 */
    public static LottoDto getWinningNumbers(){
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해주세요.");
                String inputWinningNumbers = Console.readLine();
                List<Integer> numbers = parseWinningNumbers(inputWinningNumbers);
                return new LottoDto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        String[] numberStrings = inputWinningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String numberString : numberStrings) {
                numbers.add(Integer.parseInt(numberString.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }

        return numbers;
    }

    /* 보너스 번호 입력 */
    public static int getBonusNumber(){
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해주세요.");
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input.trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("보너스 번호는 1과 45 사이의 숫자여야 합니다.");
                }
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
