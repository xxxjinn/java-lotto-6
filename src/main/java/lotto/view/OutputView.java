package lotto.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    /* 로또 구입 개수 출력 */
    public static void printPurchaseCount(int numberOfLottos){
        System.out.println("\n"+numberOfLottos+"개를 구매했습니다.");
    }

    /* 로또 번호 출력 */
    public static void printLottoNumers(List<List<Integer>> lottoNumbers){
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    /* 당첨 통계 출력 */
    public static void printStatistics(Map<String, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get("3개 일치") + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get("4개 일치") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get("5개 일치") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get("5개 일치, 보너스 볼 일치") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get("6개 일치") + "개");
    }

    /* 수익률 출력 */
    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
