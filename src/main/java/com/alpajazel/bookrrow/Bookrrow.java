package com.alpajazel.bookrrow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alpajazel.bookrrow.databases.DatabaseBook;
import com.alpajazel.bookrrow.databases.DatabaseTransaction;
import com.alpajazel.bookrrow.databases.DatabaseUser;
import com.alpajazel.bookrrow.enums.Genre;
import com.alpajazel.bookrrow.enums.Language;
import com.alpajazel.bookrrow.exceptions.BookAlreadyExistsException;
import com.alpajazel.bookrrow.exceptions.UserAlreadyExistsException;
import com.alpajazel.bookrrow.models.*;

@SpringBootApplication
public class Bookrrow {
    public static void main(String[] args){
        SpringApplication.run(Bookrrow.class, args);
    }
}
