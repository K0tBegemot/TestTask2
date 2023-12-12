package com.kotbegemot.testtask2.controller;

import com.kotbegemot.testtask2.api.dto.Paged;
import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.reader.ReaderDTO;
import com.kotbegemot.testtask2.service.ReaderService;
import com.kotbegemot.testtask2.service.implementation.ReaderServiceImpl;
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
@RequestMapping("/reader")
public class ReaderViewController {
    private static final Logger logger = LoggerFactory.getLogger(ReaderViewController.class);
    private static final String SMALL_PAGE_SIZE = "10";
    private static final String MEDIUM_PAGE_SIZE = "20";
    private static final String LARGE_PAGE_SIZE = "50";
    private static final String DEFAULT_PAGE_SIZE = SMALL_PAGE_SIZE;
    private static final ReaderDTO DEFAULT_READER = new ReaderDTO(null, "", "", "", "");
    private static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String[] PAGE_SIZE_LIST = {SMALL_PAGE_SIZE, MEDIUM_PAGE_SIZE, LARGE_PAGE_SIZE};
    private ReaderService readerService;

    public ReaderViewController(ReaderServiceImpl readerService1) {
        readerService = readerService1;
    }

    @GetMapping(path = "/listPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getReaderListMainPage(@RequestParam(name = "pageSize", required = false, defaultValue = SMALL_PAGE_SIZE) @Valid @NotNull @Positive Integer pageSize,
                                        @RequestParam(name = "pageNumber", required = false, defaultValue = DEFAULT_PAGE_NUMBER) @Valid @NotNull @PositiveOrZero Integer pageNumber,
                                        Model model) {
        Paged<ReaderDTO> readers = readerService.getPageByNumber(pageNumber, pageSize);
        model.addAttribute("pageSizes", PAGE_SIZE_LIST);
        model.addAttribute("page", readers);
        model.addAttribute("pagingReference", "/reader/listPage");
        return "readers";
    }

    @GetMapping(path = "/addPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getReaderAddPage(Model model) {
        model.addAttribute("newEntity", DEFAULT_READER);
        model.addAttribute("action", "/reader/add");
        model.addAttribute("buttonText", "Add reader");
        return "addOrEditReader";
    }

    @GetMapping(path = "/editPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getReaderEditPage(@RequestParam(name = "id", required = true) @Valid @NotNull @PositiveOrZero Long id, Model model) {
        ReaderDTO readerDTO = readerService.getEntityDTOById(id);
        model.addAttribute("newEntity", readerDTO);
        model.addAttribute("action", "/reader/edit");
        model.addAttribute("buttonText", "Edit reader");
        return "addOrEditReader";
    }

    @PostMapping(path = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView addReader(@Valid @ModelAttribute(name = "newEntity") ReaderDTO newEntity, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            for(FieldError error : result.getFieldErrors())
            {
                logger.info("{} : {}", error.getField(), error.getDefaultMessage());
            }
            ModelAndView modelAndView = new ModelAndView("addOrEditReader");
            modelAndView.addObject("action", "/reader/add");
            modelAndView.addObject("buttonText", "Add reader");
            return modelAndView;
        }
        readerService.saveOrUpdateEntity(newEntity);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return new ModelAndView("redirect:/reader/listPage");
    }

    @PostMapping(path = "/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView editReader(@Valid @ModelAttribute(name = "newEntity") ReaderDTO newEntity, BindingResult result,
                                   HttpServletRequest request) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("addOrEditReader");
            modelAndView.addObject("action", "/reader/edit");
            modelAndView.addObject("buttonText", "Edit reader");
            return modelAndView;
        }
        readerService.saveOrUpdateEntity(newEntity);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return new ModelAndView("redirect:/reader/listPage");
    }
}
