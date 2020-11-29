package ua.karazina.popova.view.show;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public final class ShowFirstMethod {

    private static final String RESULT_TEMPLATE = "Analitic:         S=%.6f\n";

    private final Label resultArea;

    public ShowFirstMethod(Label resultTextAreaFirstMethod) {
        resultArea = resultTextAreaFirstMethod;
    }

    public void showResult(double realIntegratorResult) {
        resultArea.setText(
                String.format(RESULT_TEMPLATE, realIntegratorResult));
    }

}
