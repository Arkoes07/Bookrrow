package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.enums.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Controller Class that handle request that want to know list of each Enum
 *
 * @author M. Alwi Sukra
 * @version 1.0.0
 * @since 2019-05-10
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/enum")
public class EnumController {

    /**
     * Send the list of value from Enum BookStatus
     *
     * @return the list of value from Enum BookStatus
     * @since 2019-05-10
     */
    @RequestMapping("/bookstatus")
    public List<BookStatus> getBookStatusEnum(){
        return Arrays.asList(BookStatus.values());
    }

    /**
     * Send the list of value from Enum BookType
     *
     * @return the list of value from Enum BookType
     * @since 2019-05-10
     */
    @RequestMapping("/booktype")
    public List<BookType> getBookTypeEnum(){
        return Arrays.asList(BookType.values());
    }

    /**
     * Send the list of value from Enum Genre
     *
     * @return the list of value from Enum Genre
     * @since 2019-05-10
     */
    @RequestMapping("/genre")
    public List<Genre> getGenreEnum(){
        return Arrays.asList(Genre.values());
    }

    /**
     * Send the list of value from Enum Language
     *
     * @return the list of value from Enum Language
     * @since 2019-05-10
     */
    @RequestMapping("/language")
    public List<Language> getLanguageEnum(){
        return Arrays.asList(Language.values());
    }

    /**
     * Send the list of value from Enum TransactionStatus
     *
     * @return the list of value from Enum TransactionStatus
     * @since 2019-05-10
     */
    @RequestMapping("/transactionstatus")
    public List<TransactionStatus> getTransactionStatus(){
        return Arrays.asList(TransactionStatus.values());
    }
}
