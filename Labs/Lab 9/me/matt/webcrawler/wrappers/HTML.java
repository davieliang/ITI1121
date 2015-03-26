package me.matt.webcrawler.wrappers;

/* Introduction a l'informatique II (ITI 1521)
 * Introduction to Computing II (ITI 1121)
 */

/**
 * 
 * @author Marcel Turcotte, Universite d'Ottawa/University of Ottawa
 */

import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.NoSuchElementException;

public class HTML {

    // CONSTANT(S)

    // RFC 2396 --- Uniform Resource Identifiers (URI): Generic Syntax
    // Link http://www.ietf.org/rfc/rfc2396.txt

    private static final String urlRegExp = "http\\s*://[-_.!~*';/?:@&=+$,a-z0-9]+";

    // instance variables

    private URL url;          // the URL of this HTML document
    private String content;   // the content of this HTML document
    private final Matcher matcher;  // a matcher to find the next URL in the document

    private String nextURL;   // a cache

    /**
     * Initialises an HTML object.  Fetches and store the content
     * of the Web page.
     * 
     * @param spec the URL of the document to be represented.
     * @throws MalformedURLException
     * @throws IOExceptio
     */

    public HTML( String spec ) 
    throws MalformedURLException, IOException {

        this.url = new URL( spec );

        getContent();

        Pattern p = Pattern.compile( urlRegExp, Pattern.CASE_INSENSITIVE );
        matcher = p.matcher( content );

        nextURL = null;
    }

    /** Auxilliary method used to fetch the content of the Web document.
     */

    private void getContent() throws IOException {

        BufferedReader in = new BufferedReader( new InputStreamReader( url.openStream() ) );

        StringBuffer buffer = new StringBuffer();
        String line = null;

        while ( ( line = in.readLine() ) != null ) {  // throws away line separators as well
            buffer.append( line ); // append is more efficient than string concatenation
        }

        in.close();

        content = buffer.toString();
    }

    /** Auxilliary method that is used by nextURL and hasMoreURLs.
     *  The nextURL is cached, i.e. in order to determine if there is
     *  a next URL we need to find one, hasMoreURLs will return this
     *  URL, therefore the URL that been found is saved, in the
     *  variable nextURL, and will be returned by the next call to
     *  this method.
     */

    private void getNextURL() {
        if ( nextURL == null ) {
            boolean done = false;
            while ( ! done ) {
                if ( matcher.find() ) {
                    String match = matcher.group();
                    if ( ( ! match.equals( "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" ) ) &&
                            ( ! match.equals( "http://www.w3.org/1999/xhtml" ) ) ) {
                        nextURL = match;
                        done = true;
                    }
                } else {
                    nextURL = null;
                    done = true;
                }
            }
        }
    }

    /** Returns the next URL found in this page.
     *
     * @return the next URL found in the page.
     * @throws NoSuchElementException if there are no URL is found in this page.
     */

    public String nextURL() throws NoSuchElementException {
        String savedURL;
        getNextURL();
        if ( nextURL == null ) {
            throw new NoSuchElementException();
        }
        savedURL = nextURL;
        nextURL = null;
        return savedURL;
    }

    /** Returns true there are more URLs that have not yet been
     *  returned by calls to nextURL
     *
     * @return true if this page has more URLs
     */

    public boolean hasMoreURLs() {
        getNextURL();
        return nextURL != null;
    }

    /** Returns the content of this page.  Note. The line separators
     *  have been removed.
     *
     * @return the content of the Web page designated by the URL.
     */

    public String getPage() {
        return content;
    }
}