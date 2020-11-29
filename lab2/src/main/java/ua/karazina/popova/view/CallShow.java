package ua.karazina.popova.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ua.karazina.popova.view.show.ShowFirstMethod;
import ua.karazina.popova.view.show.ShowFourthMethod;
import ua.karazina.popova.view.show.ShowSecondMethod;
import ua.karazina.popova.view.show.ShowThirdMethod;

public class CallShow {

    private final ShowFirstMethod showFirstMethod;
    private final ShowSecondMethod showSecondMethod;
    private final ShowThirdMethod showThirdMethod;
    private final ShowFourthMethod showFourthMethod;

    public CallShow(Label resultTextAreaFirstMethod, Label resultTextAreaSecondMethod, Label resultTextAreaThirdMethod, Label resultTextAreaFourthMethod) {
        showFirstMethod = new ShowFirstMethod(resultTextAreaFirstMethod);
        showSecondMethod = new ShowSecondMethod(resultTextAreaSecondMethod);
        showThirdMethod = new ShowThirdMethod(resultTextAreaThirdMethod);
        showFourthMethod = new ShowFourthMethod(resultTextAreaFourthMethod);
    }

    public void showFirst(double result) {
        showFirstMethod.showResult(result);
    }

    public void showSecond(double result, double error, double sigma) {
        showSecondMethod.showResult(result, error, sigma);
    }

    public void showThird(double result, double error, double sigma) {
        showThirdMethod.showResult(result, error, sigma);
    }

    public void showFourth(double result, double error, double sigma) {
        showFourthMethod.showResult(result, error, sigma);
    }

}
