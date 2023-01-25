import java.util.Scanner;

public class DepositCalculator {
    //Параметры программы:
    double yearRate = 0.06; //процентная ставка
    int places=2; //число цифр после запятой в денежных суммах

    double calculateComplexPercent(double moneyAmount, double yearRate, int depositPeriod) {
       double pay =  moneyAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return trimDigitsAfterComma (pay, places);
    }

    double calculateSimplePercent(double moneyAmount, double yearRate, int depositPeriod) {
        return trimDigitsAfterComma(moneyAmount+moneyAmount * yearRate * depositPeriod, places);
    }

    double trimDigitsAfterComma (double value, int places) {
        double ScaLe= Math.pow (10, places);
        return Math.round (value * ScaLe) / ScaLe;
    }

    void calculateDepositWithPercents() {
        int period;
        int percentType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int moneyAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        percentType = scanner.nextInt ();
        double finalSum = 0;
        if (percentType == 1) {
            finalSum = calculateSimplePercent(moneyAmount, yearRate, period);
        } else if (percentType == 2) {
            finalSum = calculateComplexPercent(moneyAmount, yearRate, period);
        }
        System.out.println("Результат вклада: " + moneyAmount + " за " + period + " лет превратятся в " + finalSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositWithPercents();
    }
}
