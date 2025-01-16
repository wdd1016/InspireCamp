import java.util.*;

public class LibraryManagementTest {
    // 도서 정보
    List<Book> books = new ArrayList<>();

    // ISBN => 도서 등록 시 동일 도서가 존재하는지 확인
    Set<String> isbnSet = new HashSet<>();

    // 조회수 => ISB
    Map<String, Integer> bookViews = new HashMap<>();

    // 도서 등록
    public void addBook(Book book) {
        if (isbnSet.contains(book.getIsbn())) {
            System.out.printf("ISBN %s과 동일한 도서가 이미 등록되어 있습니다.\n", book.getIsbn());
            return;
        }
        books.add(book);
        isbnSet.add(book.getIsbn());
        bookViews.put(book.getIsbn(), 0);
        System.out.println("정상적으로 등록되었습니다. " + book);
    }

    // 전체 도서 목록 조회
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("등록한 도서가 없습니다.");
            return;
        }
        books.forEach(System.out::println);
    }

    // 도서 검색 => 책 이름과 저자 항목을 검색
    public void searchBooks(String keyword) {
        keyword = keyword.trim().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            // normalization (대소문자, 좌우공백)
            if (book.getTitle().trim().toLowerCase().contains(keyword) ||
                    book.getAuthor().trim().toLowerCase().contains(keyword)) {
                System.out.println(book);
                bookViews.put(book.getIsbn(), bookViews.get(book.getIsbn()) + 1);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("%s를 포함하는 도서가 없습니다.\n", keyword);
        }
    }

    // 도서 삭제
    public void deleteBook(String isbn) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                isbnSet.remove(isbn);
                bookViews.remove(isbn);
                System.out.printf("ISBN %s 책을 삭제했습니다.\n", isbn);
                return;
            }
        }
        System.out.printf("ISBN %s와 일치하는 도서를 찾을 수 없습니다.\n", isbn);
    }

    // 인기 도서 조회
    public void mostViewedBooks() {
        int maxViews = Collections.max(bookViews.values());

        if (bookViews.isEmpty() || maxViews == 0) {
            System.out.println("등록된 인기 도서가 없습니다.");
            return;
        }

        for (Map.Entry<String, Integer> entry : bookViews.entrySet()) {
            if (entry.getValue() == maxViews) {
                books.stream()
                        .filter(book -> book.getIsbn().equals(entry.getKey()))
                        .forEach(System.out::println);
            }
        }
    }
}
