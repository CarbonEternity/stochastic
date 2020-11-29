package ua.karazina.popova.service.first;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.exp;

public class SimpleIntegrator {

    private final double a;
    private final double u;
    private final double k;

    public SimpleIntegrator(double a, double u, double k) {
        this.a = a;
        this.u = u;
        this.k = k;
    }

    public double integrate() {
        double x = (a * (1.0 / 6));

        double y;
        if (u != 0) {
            y = (-1.0 / u) * (exp(-1.0 * u) - 1);
        } else {
            y = exp(0);
        }

        double z = (-1.0 / (PI * k)) * (cos(PI * k) - 1);

        return x * y * z;
    }

}
