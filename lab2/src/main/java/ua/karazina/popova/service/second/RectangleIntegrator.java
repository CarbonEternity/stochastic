package ua.karazina.popova.service.second;

import ua.karazina.popova.service.InputParameters;

public class RectangleIntegrator {

    private final InputParameters inputParameters;

    private int N;

    public RectangleIntegrator(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    public double integrate(int N) {
        this.N = N;
        double step = 1.0 / N;
        double current = step;
        int stepCount = 0;

        double fx = 0;
        double fy = 0;
        double fz = 0;

        while (current <= 1.0) {
            fx += inputParameters.xFunction(current);
            fy += inputParameters.yFunction(current);
            fz += inputParameters.zFunction(current);
            stepCount++;
            current += step;
        }

        fx /= stepCount;
        fy /= stepCount;
        fz /= stepCount;

        return fx * fy * fz;
    }

    public double calculateSigma() {
        return Math.abs(integrate(N) - integrate(N * 2));
    }
}