package ua.karazina.popova.view.show;

import javafx.scene.control.Label;

public class ShowFourthMethod {

    private static final String RESULT_TEMPLATE = ""
            + "Geometric M-K:    S=%.6f  error=%.6f  sigma=%.6f\n";

    private final Label resultArea;

    public ShowFourthMethod(Label resultTextAreaFourthMethod) {
        resultArea = resultTextAreaFourthMethod;
    }

    public void showResult(double geometricMonteCarloResult, double geometricMonteCarloError, double geometricMonteCarloSigma) {
        resultArea.setText(
                String.format(RESULT_TEMPLATE, geometricMonteCarloResult, geometricMonteCarloError, geometricMonteCarloSigma));
    }

}
