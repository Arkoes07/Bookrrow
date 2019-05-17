package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseConsumer;
import com.alpajazel.bookrrow.models.Consumer;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller Class that handle request that related to DatabaseConsumer class
 *
 * @author Reja Aji Saputra
 * @version 1.0.0
 * @since 2019-05-10
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private DatabaseConsumer dc = new DatabaseConsumer();

    /**
     * Method that use to register a new consumer to the database by requesting /customer/register in the URL
     *
     * @param username username that inputed by consumer to create an account for login to the website
     * @param password password that inputed by consumer to create an account for login to the website
     * @param name consumer's name that inputed by consumer for consumer data in the website
     * @param email consumer's email that inputed by consumer for consumer data in the website
     * @param phoneNumber consumer's phone number that inputed by consumer for consumer data in the website
     * @return Consumer object that created by the user
     * @since 2019-05-10
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Consumer registerConsumer(
                                     @RequestParam(value ="username") String username,
                                     @RequestParam(value ="password") String password,
                                     @RequestParam(value ="name") String name,
                                     @RequestParam(value ="email") String email,
                                     @RequestParam(value ="phonenum") String phoneNumber
                            ){
        /*
        Tidak boleh diawali dengan simbol
        Sebelum '@', minimal terdapat satu karakter, dua simbol tidak boleh berurutan
        Tepat sebelum '@' tidak boleh simbol
        Setelah '@', boleh terdapat [a-zA-Z0-9-] sebanyak banyaknya hingga '.'
        Setelah '.', jika ada titik lain setelahnya, maka diantara dua titik boleh memiliki [a-zA-Z0-9-] sebanyak-banyaknya
        Setelah '.', jika tidak ada titik lain, maka [a-zA-Z] minimal 2 dan maximal 7
         */
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if(!m.find( )){
            return null;
        }

        // Regex password minimal 6 karakter, terdapat Huruf kapital dan non kapital.
        String patternPwd = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern rPwd = Pattern.compile(patternPwd);
        Matcher mPwd = rPwd.matcher(password);
        if(!mPwd.find( )){
            return null;
        }

        dc.connect();
        Consumer consumer = dc.registerConsumer(username,password,name,email,phoneNumber);
        dc.disconnect();
        return consumer;
    }

    /**
     * Method that use by consumer to login to the website by requesting /customer/login in the URL
     *
     * @param username username that inputed by consumer to login to the website
     * @param password password that inputed by consumer to login to the website
     * @return Consumer object which have the username and password that have been specified
     * @since 2019-05-10
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Consumer logincons(@RequestParam(value ="username") String username,
                              @RequestParam(value ="password") String password){
        dc.connect();
        Consumer consumer = dc.loginConsumer(username,password);
        dc.disconnect();
        return consumer;

    }

    /**
     * Method that use by consumer to update their data in database by requesting /customer/update in the URL
     *
     * @param password consumer's password that consumer want to update in the database
     * @param name consumer's name that consumer want to update in the database
     * @param phoneNumber consumer's phone number that consumer want to update in the database
     * @param consumerID the primary key that determine the consumer row that the program want to take
     * @return Consumer object that updated by the user
     * @since 2019-05-10
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Consumer updatecons (@RequestParam(value= "id") int consumerID,
                                @RequestParam(value ="password") String password,
                                @RequestParam(value ="name") String name,
                                @RequestParam(value ="phonenum") String phoneNumber){
        dc.connect();
        Consumer consumer = dc.updateConsumer(password,name,phoneNumber,consumerID);
        dc.disconnect();
        return consumer;
    }
}
