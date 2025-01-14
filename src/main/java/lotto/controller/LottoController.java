package lotto.controller;

import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        int purchaseAmount = InputView.getPurchaseAmount();
        int numberOfLottos = purchaseAmount/1000;
        Lotto winningLotto = null;

        List<List<Integer>> lottoNumbersList = lottoService.generateLottoNumbers(numberOfLottos);
        OutputView.printPurchaseCount(numberOfLottos);
        OutputView.printLottoNumers(lottoNumbersList);

        while(true) {
            LottoDto winningNumbersDto = InputView.getWinningNumbers();
            try {
                winningLotto = new Lotto(winningNumbersDto.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        int bonusNumber = InputView.getBonusNumber();

        Map<String, Integer> statistics = lottoService.calculateLotto(lottoNumbersList, winningLotto, bonusNumber);
        OutputView.printStatistics(statistics);

        double profitRate = lottoService.calculateProfitRate(purchaseAmount, statistics);
        OutputView.printProfitRate(profitRate);
    }
}
