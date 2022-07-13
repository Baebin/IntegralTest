package com.baebin.IntegralTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    private static Function<Double, Double> func;

    public static void main(String[] args) {
        // f(x) = e^2x / F(x) = (e^2x)/2+C
        func = x -> Math.pow(Math.E, 2*x);

        Scanner scanner = new Scanner(System.in);
        String input = "";
        List<Double> inputs = new ArrayList<>();

        p("범위를 입력해주세요: ");
        do {
            input = scanner.next();
            if (input.equals("Exit")) break;

            inputs.add(Double.parseDouble(input.split(",")[0]));
            inputs.add(Double.parseDouble(input.split(",")[1]));

            pln("f(x)=e^2x의 정적분 결과: " + getResult(inputs));
            pln("");
            p("범위를 입력해주세요: ");

            inputs.clear();
        } while (scanner.hasNext());

        pln("");
        pln("프로그램이 종료되었습니다.");
        pln("");
    }

    private static double getResult(List<Double> datas) {
        // f(x) = e^2x / F(x) = (e^2x)/2+C
        double s1 = 0.0f;
        double s2 = 0.0f;

        s1 = func.apply(datas.get(0))/2;
        s2 = func.apply(datas.get(1))/2;

        return s2-s1;
    }

    private static void p(String msg) {
        System.out.print(msg);
    }

    private static void pln(String msg) {
        System.out.println(msg);
    }
}
