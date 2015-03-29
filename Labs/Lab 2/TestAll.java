/*
 * ITI 1121. Introduction to Computing II; Laboratory 2
 * ITI 1521. Introduction a l'informatique II; Laboratoire 2
 */

/**
 * Runs all the tests using a textual runner. This is the
 * alternative to running all the tests within your favorite
 * development environment (DrJava, Eclipse...). This may require
 * downloading JUnit from
 * <a href="https://github.com/KentBeck/junit/wiki/Download-and-Install">github.com/KentBeck/junit/wiki/Download-and-Install</a>.
 *
 * <pre>
 * > javac -cp junit.jar:. RunTests.java
 * > java -cp junit.jar:. RunTests
 * ************************************************************
 * *                                                          *
 * *                                                          *
 * *                                                          *
 * *                                                          *
 * ************************************************************
 *
 * ..............
 * Time: 0.031
 *
 * OK (14 tests)
 *  *
 * </pre>
 *
 * @author Marcel Turcotte (turcotte@site.uottawa.ca)
 */

import junit.framework.Test;
import junit.framework.TestSuite;
import me.matt.genetics.util.StudentInfo;

public class TestAll {

    // Creates and returns a TestSuite object.

    /**
     * Runs the test suite using the textual runner.
     *
     * @param args
     *            reference to an array of arguments passed to the program on the command line
     */

    public static void main(final String[] args) {

        StudentInfo.display();

        junit.textui.TestRunner.run(TestAll.suite());
    }

    private static Test suite() {

        final TestSuite suite = new TestSuite();

        suite.addTestSuite(TestFindAndReplace.class);

        return suite;
    }
}