package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 실제 LottoService 기능 구현*/
public class LottoServiceImpl implements LottoService {
    @Override
    public List<List<Integer>> generateLottoNumbers(int numberOfLottos) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }

    @Override
    public Map<String, Integer> calculateLotto(List<List<Integer>> lottoNumbers, Lotto winningLotto, int bonusNumber){
            Map<String, Integer> lottoNumbersMap = new HashMap<>();
            lottoNumbersMap.put("3개 일치", 0);
            lottoNumbersMap.put("4개 일치", 0);
            lottoNumbersMap.put("5개 일치", 0);
            lottoNumbersMap.put("5개 일치, 보너스 볼 일치", 0);
            lottoNumbersMap.put("6개 일치", 0);

            for (List<Integer> lottoNumber : lottoNumbers) {
                int matchCount = getMatchCount(lottoNumber, winningLotto.getNumbers());
                boolean bonusMatch = lottoNumber.contains(bonusNumber);

                if (matchCount == 6) {
                    lottoNumbersMap.put("6개 일치", lottoNumbersMap.get("6개 일치") + 1);
                } else if (matchCount == 5 && bonusMatch) {
                    lottoNumbersMap.put("5개 일치, 보너스 볼 일치", lottoNumbersMap.get("5개 일치, 보너스 볼 일치") + 1);
                } else if (matchCount == 5) {
                    lottoNumbersMap.put("5개 일치", lottoNumbersMap.get("5개 일치") + 1);
                } else if (matchCount == 4) {
                    lottoNumbersMap.put("4개 일치", lottoNumbersMap.get("4개 일치") + 1);
                } else if (matchCount == 3) {
                    lottoNumbersMap.put("3개 일치", lottoNumbersMap.get("3개 일치") + 1);
                }
            }
        return lottoNumbersMap;
    }

    private int getMatchCount(List<Integer> lottoNumber, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumber) {
            if(winningNumbers.contains(number)) matchCount++;
        }
        return matchCount;
    }

    @Override
    public double calculateProfitRate(int purchaseAmount, Map<String, Integer> lottoNumberMap) {
        int totalWinningAmount = calculateTotalWinningAmount(lottoNumberMap);
        return (double) totalWinningAmount / purchaseAmount;
    }

    private int calculateTotalWinningAmount(Map<String, Integer> statistics) {
        int totalAmount = 0;

        totalAmount += statistics.get("3개 일치") * 5000;
        totalAmount += statistics.get("4개 일치") * 50000;
        totalAmount += statistics.get("5개 일치") * 1500000;
        totalAmount += statistics.get("5개 일치, 보너스 볼 일치") * 30000000;
        totalAmount += statistics.get("6개 일치") * 2000000000;

        return totalAmount;
    }
}
