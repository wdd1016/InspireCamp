package ex01_member;

import lombok.Setter;

@Setter
public class VersionPrinter {
    private int majorVersion;
    private int minorVersion;

    public void print() {
        System.out.printf("이 프로그램의 버전은 %d.%d 입니다.", this.majorVersion, this.minorVersion);
    }
}
