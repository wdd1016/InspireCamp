package member_annotation;

import ex01_member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

// 자동 주입할 대상이 필수가 아닌 경우 → 선택적으로 주입
// @Autowired 어노테이션에 required 속성을 false로 설정

// public class MemberPrinter {
//     @Autowired(required = false)
//     private DateTimeFormatter dateTimeFormatter;
//
//
//     public void print(Member member) {
//         if (dateTimeFormatter == null) {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     member.getRegisterDateTime());
//         } else {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     dateTimeFormatter.format(member.getRegisterDateTime()));
//         }
//     }
// }

// 의존 주입 대상에 자바 8의 Optional 객체를 사용 - 2가지
// 1. setter 메서드를 Optional로 구현
// public class MemberPrinter {
//
//     private DateTimeFormatter dateTimeFormatter;
//
//     @Autowired
//     public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatterOptional) {
//         if (dateTimeFormatterOptional.isPresent()) {
//             this.dateTimeFormatter = dateTimeFormatterOptional.get();
//         } else {
//             this.dateTimeFormatter = null;
//         }
//     }
//
//     public void print(Member member) {
//         if (dateTimeFormatter == null) {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     member.getRegisterDateTime());
//         } else {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     dateTimeFormatter.format(member.getRegisterDateTime()));
//         }
//     }
// }

// 2. 필드에 Optional로 구현
// public class MemberPrinter {
//     @Autowired
//     private Optional<DateTimeFormatter> dateTimeFormatterOptional;
//
//     public void print(Member member) {
//         DateTimeFormatter dateTimeFormatter = dateTimeFormatterOptional.orElse(null);
//
//         if (dateTimeFormatter == null) {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     member.getRegisterDateTime());
//         } else {
//             System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                     member.getId(), member.getEmail(), member.getName(),
//                     dateTimeFormatter.format(member.getRegisterDateTime()));
//         }
//     }
// }

// @Nullable ⇒ 자동 주입할 빈이 존재하면 해당 빈을 전달하고, 존재하지 않으면 null을 전달

public class MemberPrinter {
    @Autowired
    @Nullable
    private DateTimeFormatter dateTimeFormatter;

    // 또는
    // @Autowired
    // @Nullable
    // public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
    //     this.dateTimeFormatter = dateTimeFormatter;
    // }

    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(),
                    member.getRegisterDateTime());
        } else {
            System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }
}
