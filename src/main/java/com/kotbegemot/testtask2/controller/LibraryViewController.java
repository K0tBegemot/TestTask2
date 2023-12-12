package com.kotbegemot.testtask2.controller;

import com.kotbegemot.testtask2.api.dto.book.BookDTO;
import com.kotbegemot.testtask2.api.dto.library.LibraryRecordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/library")
public class RecordViewController {
    private static final LibraryRecordDTO DEFAULT_RECORD = new LibraryRecordDTO(null, "", null, null, null, null);
    @GetMapping(path = "/addPage", produces = MediaType.TEXT_HTML_VALUE)
    public String getRecordAddPage(Model model) {
        model.addAttribute("newEntity", DEFAULT_RECORD);
        model.addAttribute("action", "/library/add");
        return "addOrEditLibrary";
    }
    @PostMapping(path = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView addRecord(@Valid @ModelAttribute(name = "newEntity") BookDTO newEntity, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            for(FieldError error : result.getFieldErrors())
            {
                logger.info("{} : {}", error.getField(), error.getDefaultMessage());
            }
            ModelAndView modelAndView = new ModelAndView("addOrEditBook");
            modelAndView.addObject("action", "/book/add");
            return modelAndView;
        }
        bookService.saveOrUpdateEntity(newEntity);
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
        return new ModelAndView("redirect:/book/listPage");
    }
}
