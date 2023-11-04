package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;

public class OutputView {

    private static final String LINE_BREAK = System.lineSeparator();

    public static void printBuyerLotto(int lottoCount, List<Lotto> lottoNumbers) {
        System.out.print(LINE_BREAK);
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(Map<WinningStatistics, Integer> map) {
        System.out.print(LINE_BREAK);
        System.out.println("당첨 통계\n" + "---");
        printStatistics(map);
    }

    private static void printStatistics(Map<WinningStatistics, Integer> map) {
        for (WinningStatistics statistics : map.keySet()) {
            printRankInfo(statistics, map.get(statistics));
        }
    }

    private static void printRankInfo(WinningStatistics statistics, int count) {
        NumberFormat nf = NumberFormat.getInstance();

        String matchInfo = statistics.getMatchCount() + "개 일치";

        if (statistics.hasBonusCount()) {
            matchInfo += ", 보너스 볼 일치";
        }

        String rewardInfo = " (" + nf.format(statistics.getReward()) + "원) - " + count + "개";

        System.out.println(matchInfo + rewardInfo);
    }
}
