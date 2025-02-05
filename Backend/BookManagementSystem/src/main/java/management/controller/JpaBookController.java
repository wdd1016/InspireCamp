package management.controller;

import management.entity.BooksEntity;
import management.service.JpaBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class JpaBookController {
    @Autowired
    private JpaBookService bookService;

    @GetMapping({"", "/"})
    public String redirectToBookList() {
        return "redirect:/jpa/book/openBookList";
    }

    @GetMapping("/book/openBookList")
    public ModelAndView openBookList() throws Exception {
        ModelAndView mv = new ModelAndView("/book/jpaBookList");

        List<BooksEntity> list = bookService.selectBookList();
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/book/openBookRegister")
    public String openBookRegister() throws Exception {
        return "book/jpaBookRegister";
    }

    @PostMapping("/book/insertBook")
    public String insertBook(BooksEntity booksEntity, MultipartHttpServletRequest request) throws Exception {
        bookService.insertBook(booksEntity, request);
        return "redirect:/jpa/book/openBookList";
    }

    @GetMapping("/book/openBookDetail")
    public ModelAndView openBookDetail(@RequestParam("bookId") Long bookId) throws Exception {
        BooksEntity booksEntity = bookService.selectBookDetail(bookId);

        ModelAndView mv = new ModelAndView("/book/jpaBookDetail");
        mv.addObject("book", booksEntity);
        return mv;
    }

    @PostMapping("/book/updateBook")
    public String updateBook(BooksEntity booksEntity) throws Exception {
        bookService.updateBook(booksEntity);
        return "redirect:/jpa/book/openBookList";
    }

    @PostMapping("/book/deleteBook")
    public String deleteBook(@RequestParam("bookId") Long bookId) throws Exception {
        bookService.deleteBook(bookId);
        return "redirect:/jpa/book/openBookList";
    }
}
