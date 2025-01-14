package lotto.service;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public interface LottoService {
    List<List<Integer>> generateLottoNumbers(int numberOfLottos);
    Map<String, Integer> calculateLotto(List<List<Integer>> lottoNumbers, Lotto winningLotto, int bonusNumber);
    double calculateProfitRate(int purchaseAmount, Map<String, Integer> lottoNumberMap);
}
