package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class AppConfig {
    public LottoService lottoService(){
        return new LottoServiceImpl();
    };

    public LottoController lottoController(){
        return new LottoController(lottoService());
    };
}
