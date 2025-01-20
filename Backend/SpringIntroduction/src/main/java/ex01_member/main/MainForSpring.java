package ex01_member.main;

import ex01_member.*;
import ex01_member.config.AppConf1;
import ex01_member.config.AppConf2;
import ex01_member.config.AppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {
    private static ApplicationContext applicationContext = null;

    // new      : 새로운 회원 데이터를 추가
    // change   : 회원의 패스워드를 변경
    // exit     : 프로그램을 종료 d
    public static void main(String[] args) throws IOException {
        // applicationContext = new AnnotationConfigApplicationContext(AppContext.class);
        applicationContext = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("명령어를 입력하세요. ");
            String command = reader.readLine();
            if (command.startsWith("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if (command.startsWith("new")) {
                processNewCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("list")) {
                processListCommand();
                continue;
            }
            if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("version")) {
                processVersionCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processVersionCommand(String[] args) {
        VersionPrinter versionPrinter = applicationContext.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }

    private static void processInfoCommand(String[] args) {
        if (args.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter = applicationContext.getBean("memberInfoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMemberInfo(args[1]);
    }

    private static void processListCommand() {
        MemberListPrinter memberListPrinter = applicationContext.getBean("memberListPrinter", MemberListPrinter.class);
        memberListPrinter.printAll();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("new email name password confirmPassword");
        System.out.println("change email currentPassword newPassword");
        System.out.println();
    }

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }

        MemberRegisterService registerService = applicationContext.getBean("memberRegisterService", MemberRegisterService.class);
        RegisterRequest reg = new RegisterRequest();
        reg.setEmail(args[1]);
        reg.setName(args[2]);
        reg.setPassword(args[3]);
        reg.setConfirmPassword(args[4]);

        if (!reg.isPasswordEqualToConfirmPassword()) {
            System.out.println("패스워드와 패스워드 확인이 일치하지 않습니다.");
            return;
        }

        try {
            registerService.regist(reg);
            System.out.println("등록되었습니다.");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }
    }

    private static void processChangeCommand(String[] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService pwdSvc = applicationContext.getBean("changePasswordService", ChangePasswordService.class);

        try {
            pwdSvc.changePassword(args[1], args[2], args[3]);
            System.out.println("패스워드를 변경하였습니다.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
