package ua.karazina.popova.view.show;

import javafx.scene.control.Label;

public class ShowSecondMethod {

    private static final String RESULT_TEMPLATE = "Rectangle method: S=%.6f  error=%.6f  sigma=%.6f\n";

    private final Label resultArea;

    public ShowSecondMethod(Label resultTextAreaSecondMethod) {
        resultArea = resultTextAreaSecondMethod;
    }

    public void showResult(double rectangleIntegratorResult, double rectangleIntegratorError, double rectangleIntegratorSigma) {
        resultArea.setText(
                String.format(RESULT_TEMPLATE, rectangleIntegratorResult, rectangleIntegratorError, rectangleIntegratorSigma));
    }


}
