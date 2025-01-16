public class Test {
    public static void main(String[] args) {
        LibraryManagementTest library = new LibraryManagementTest();
        Book book1 = new Book("12345", "Java Programming", "John", 2020);
        Book book2 = new Book("67890", "Python Programming", "Tom", 2024);
        Book book3 = new Book("88888", "C++ Programming", "Jane", 2000);

        // 도서 목록 초기 상태 출력
        System.out.println("1. 초기 도서 목록:");
        library.listBooks();
        System.out.println();

        // 도서 추가 작업 및 결과 출력
        System.out.println("2. 도서 추가 작업:");
        library.addBook(book1);
        library.addBook(book1); // 중복 추가 시도
        library.addBook(book2);
        library.addBook(book3);
        System.out.println();

        // 도서 목록 출력
        System.out.println("3. 도서 목록 (추가 후):");
        library.listBooks();
        System.out.println();

        // 가장 많이 조회된 도서 출력
        System.out.println("4. 인기 도서 목록:");
        library.mostViewedBooks();
        System.out.println();

        // 도서 검색 작업
        System.out.println("5. 특정 키워드로 도서 검색 ('programming'):");
        library.searchBooks("programming");
        System.out.println();
        System.out.println("6. 특정 키워드로 도서 검색 ('mybook'):");
        library.searchBooks("mybook");
        System.out.println();

        // 도서 삭제 작업
        System.out.println("7. 특정 ISBN으로 도서 삭제 시도:");
        library.deleteBook("99999"); // 존재하지 않는 도서
        library.deleteBook("88888"); // 존재하는 도서 삭제
        System.out.println();
        System.out.println("8. 도서 목록 (삭제 후):");
        library.listBooks();
        System.out.println();

        // 가장 많이 조회된 도서 출력 (삭제 후)
        System.out.println("9. 인기 도서 목록 (삭제 후):");
        library.mostViewedBooks();
    }
}
