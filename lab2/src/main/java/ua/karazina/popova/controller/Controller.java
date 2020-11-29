package ua.karazina.popova.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.karazina.popova.service.InputParameters;
import ua.karazina.popova.service.first.SimpleIntegrator;
import ua.karazina.popova.service.third.SimpleMonteCarloIntegrator;
import ua.karazina.popova.view.CallShow;
import ua.karazina.popova.service.fourth.GeometricMonteCarloIntegrator;
import ua.karazina.popova.service.second.RectangleIntegrator;

import static java.lang.Math.abs;


public class Controller {

    @FXML
    private TextField aParameterField;
    @FXML
    private TextField uParameterField;
    @FXML
    private TextField kParameterField;
    @FXML
    private TextField methodRectangleNField;
    @FXML
    private TextField methodMKNField;

    @FXML
    private Label resultTextAreaFirstMethod;
    @FXML
    private Label resultTextAreaSecondMethod;
    @FXML
    private Label resultTextAreaThirdMethod;
    @FXML
    private Label resultTextAreaFourthMethod;

    private InputParameters inputParameters;

    //    For third method
    private double simpleMonteCarloResult;
    private double simpleMonteCarloError;
    private double simpleMonteCarloSigma;
    //  For fourth method
    private double geometricMonteCarloResult;
    private double geometricMonteCarloError;
    private double geometricMonteCarloSigma;
    //  For second method
    private double rectangleIntegratorResult;
    private double rectangleIntegratorError;
    private double rectangleIntegratorSigma;
    //    For first method
    private double realIntegratorResult;

    @FXML
    private void onButtonClick(ActionEvent event) {
        CallShow callShow = new CallShow(resultTextAreaFirstMethod,
                                        resultTextAreaSecondMethod,
                                        resultTextAreaThirdMethod,
                                        resultTextAreaFourthMethod);
        try {
            double aParameter = Double.parseDouble(aParameterField.getText());
            double bParameter = Double.parseDouble(uParameterField.getText());
            double cParameter = Double.parseDouble(kParameterField.getText());

            inputParameters = new InputParameters(aParameter, bParameter, cParameter);

            getResultFirstMethod(aParameter, bParameter, cParameter);
            getResultSecondMethod(realIntegratorResult);
            getResultThirdMethod(realIntegratorResult);
            getResultFourthMethod(realIntegratorResult);

            callShow.showFirst(realIntegratorResult);
            callShow.showSecond(rectangleIntegratorResult, rectangleIntegratorError, rectangleIntegratorSigma);
            callShow.showThird(simpleMonteCarloResult, simpleMonteCarloError, simpleMonteCarloSigma);
            callShow.showFourth(geometricMonteCarloResult, geometricMonteCarloError, geometricMonteCarloSigma);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getResultFirstMethod(double aParameter, double bParameter, double cParameter) {
        SimpleIntegrator simpleIntegrator = new SimpleIntegrator(aParameter, bParameter, cParameter);
        realIntegratorResult = simpleIntegrator.integrate();
    }

    private void getResultSecondMethod(double realIntegratorResult) {
        RectangleIntegrator rectangleIntegrator = new RectangleIntegrator(inputParameters);
        rectangleIntegratorResult = rectangleIntegrator.integrate(Integer.parseInt(methodRectangleNField.getText()));
        rectangleIntegratorError = abs(realIntegratorResult - rectangleIntegratorResult);
        rectangleIntegratorSigma = rectangleIntegrator.calculateSigma();
    }

    private void getResultThirdMethod(double realIntegratorResult) {
        SimpleMonteCarloIntegrator simpleMonteCarloIntegrator = new SimpleMonteCarloIntegrator(inputParameters);
        simpleMonteCarloResult = simpleMonteCarloIntegrator.integrate(Integer.parseInt(methodMKNField.getText()));
        simpleMonteCarloError = abs(realIntegratorResult - simpleMonteCarloResult);
        simpleMonteCarloSigma = simpleMonteCarloIntegrator.calculateSigma();
    }

    private void getResultFourthMethod(double realIntegratorResult) {
        GeometricMonteCarloIntegrator geometricMonteCarloIntegrator = new GeometricMonteCarloIntegrator(inputParameters);
        geometricMonteCarloResult = geometricMonteCarloIntegrator.integrate(300, Integer.parseInt(methodMKNField.getText()));
        geometricMonteCarloError = abs(realIntegratorResult - geometricMonteCarloResult);
        geometricMonteCarloSigma = geometricMonteCarloIntegrator.calculateSigma();
    }
}

