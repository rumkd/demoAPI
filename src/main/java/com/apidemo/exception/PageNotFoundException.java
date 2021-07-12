package com.apidemo.exception;


/**
 * @author Urminder Deol
 *
 */
public class PageNotFoundException extends RuntimeException
{
    public PageNotFoundException(final int pageNumber) {
        super("Could not find page " + pageNumber);
    }
}