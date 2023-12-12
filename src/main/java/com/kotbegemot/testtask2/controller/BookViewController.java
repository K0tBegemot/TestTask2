package com.kotbegemot.testtask2.controller;

import com.kotbegemot.testtask2.api.dto.Paged;
import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.service.BookService;
import com.kotbegemot.testtask2.service.implementation.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Controller
@RequestMapping("/book")
public class BookViewController {
    private static final Logger logger = LoggerFactory.getLogger(BookViewController.class);
    private static final String SMALL_PAGE_SIZE = "10";
    private static final String MEDIUM_PAGE_SIZE = "20";
    private static final String LARGE_PAGE_SIZE = "50";
    private static final String DEFAULT_PAGE_SIZE = SMALL_PAGE_SIZE;
    private static final BookDTO DEFAULT_BOOK = new BookDTO(null, "", "", "");
    private static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String[] PAGE_SIZE_LIST = {SMALL_PAGE_SIZE, MEDIUM_PAGE_SIZE, LARGE_PAGE_SIZE};
    private BookService bookService;

    public BookViewController(BookServiceImpl bookService1) {
        bookService = bookService1;
    }

    @GetMapping(path = "/listPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getBookListMainPage(@RequestParam(name = "pageSize", required = false, defaultValue = SMALL_PAGE_SIZE) @Valid @NotNull @Positive Integer pageSize,
                                      @RequestParam(name = "pageNumber", required = false, defaultValue = DEFAULT_PAGE_NUMBER) @Valid @NotNull @PositiveOrZero Integer pageNumber,
                                      Model model) {
        Paged<BookDTO> books = bookService.getPageByNumber(pageNumber, pageSize);
        model.addAttribute("pageSizes", PAGE_SIZE_LIST);
        model.addAttribute("pagingReference", "/book/listPage");
        model.addAttribute("page", books);
        return "books";
    }

    @GetMapping(path = "/addPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getBookAddPage(Model model) {
        model.addAttribute("newEntity", DEFAULT_BOOK);
        model.addAttribute("action", "/book/add");
        model.addAttribute("buttonText", "Add book");
        return "addOrEditBook";
    }

    @GetMapping(path = "/editPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getBookEditPage(@RequestParam(name = "id", required = true) @Valid @NotNull @PositiveOrZero Long id, Model model) {
        BookDTO bookDTO = bookService.getEntityDTOById(id);
        model.addAttribute("newEntity", bookDTO);
        model.addAttribute("action", "/book/edit");
        model.addAttribute("buttonText", "Edit book");
        return "addOrEditBook";
    }

    @PostMapping(path = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView addBook(@Valid @ModelAttribute(name = "newEntity") BookDTO newEntity, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            for(FieldError error : result.getFieldErrors())
            {
                logger.info("{} : {}", error.getField(), error.getDefaultMessage());
            }
            ModelAndView modelAndView = new ModelAndView("addOrEditBook");
            modelAndView.addObject("action", "/book/add");
            modelAndView.addObject("buttonText", "Add book");
            return modelAndView;
        }
        bookService.saveOrUpdateEntity(newEntity);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return new ModelAndView("redirect:/book/listPage");
    }

    @PostMapping(path = "/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView editBook(@Valid @ModelAttribute(name = "newEntity") BookDTO newEntity, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("addOrEditBook");
            modelAndView.addObject("action", "/book/edit");
            modelAndView.addObject("buttonText", "Edit book");
            return modelAndView;
        }
        bookService.saveOrUpdateEntity(newEntity);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return new ModelAndView("redirect:/book/listPage");
    }
}
