package ua.karazina.popova.view.show;

import javafx.scene.control.Label;

public class ShowThirdMethod {

    private static final String RESULT_TEMPLATE = "Simple M-K:       S=%.6f  error=%.6f  sigma=%.6f\n";

    private final Label resultArea;

    public ShowThirdMethod(Label resultTextAreaThirdMethod) {
        resultArea = resultTextAreaThirdMethod;
    }

    public void showResult(double simpleMonteCarloResult, double simpleMonteCarloError, double simpleMonteCarloSigma) {
        resultArea.setText(
                String.format(RESULT_TEMPLATE, simpleMonteCarloResult, simpleMonteCarloError, simpleMonteCarloSigma));
    }

}
