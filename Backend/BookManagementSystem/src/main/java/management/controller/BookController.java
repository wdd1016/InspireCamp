package management.controller;

import management.dto.BooksDto;
import management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String redirectToBookList() {
        return "redirect:/book/openBookList";
    }

    @GetMapping("/book/openBookList")
    public ModelAndView openBookList() throws Exception {
        ModelAndView mv = new ModelAndView("/book/bookList");

        List<BooksDto> list = bookService.selectBookList();
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/book/openBookRegister")
    public String openBookRegister() throws Exception {
        return "book/bookRegister";
    }

    @PostMapping("/book/insertBook")
    public String insertBook(BooksDto booksDto, MultipartHttpServletRequest request) throws Exception {
        bookService.insertBook(booksDto, request);
        return "redirect:/book/openBookList";
    }

    @GetMapping("/book/openBookDetail")
    public ModelAndView openBookDetail(@RequestParam("bookId") Long bookId) throws Exception {
        BooksDto booksDto = bookService.selectBookDetail(bookId);

        ModelAndView mv = new ModelAndView("/book/bookDetail");
        mv.addObject("book", booksDto);
        return mv;
    }

    @PostMapping("/book/updateBook")
    public String updateBook(BooksDto booksDto) throws Exception {
        bookService.updateBook(booksDto);
        return "redirect:/book/openBookList";
    }

    @PostMapping("/book/deleteBook")
    public String deleteBook(@RequestParam("bookId") Long bookId) throws Exception {
        bookService.deleteBook(bookId);
        return "redirect:/book/openBookList";
    }
}

