package polymorphism;

// Samsung 프린터 구현
class SamsungPrinter {
    public void print(String s) {
    }

    public void lineFeed() {
    }

    public void loadPaper() {
    }
}

// HP 프린터 구현
class HpPrinter {
    public void print(String s) {
    }

    public void lineFeed() {
    }

    public void loadPaper() {
    }
}

// 인터페이스로 변경
// 프린터가 가져야 할 사양
interface Printer {
    public void print(String s);

    public void lineFeed();

    public void loadPaper();
}

// 해당 제품에 맞는 기능 구현
class PrinterImpl implements Printer {
    public void print(String s) { // ⇐ 각 프린터를 제어하는 코드를 구현
    }

    public void lineFeed() {
    }

    public void loadPaper() {
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // 삼성 프린터를 이용하는 경우
        SamsungPrinter sp = new SamsungPrinter();
        sp.print("어떤 내용");
        sp.lineFeed();
        sp.loadPaper();

        // HP 프린터를 이용하는 경우
        HpPrinter hp = new HpPrinter();
        hp.print("어떤 내용");
        hp.lineFeed();
        hp.loadPaper();

        // 인터페이스로 변경
        Printer op = new PrinterImpl(); // ⇐ 프린터가 변경되어도 해당 코드는 변경할 필요가 없음
        op.print("어떤 내용");
        op.lineFeed();
        op.loadPaper();
    }
}
