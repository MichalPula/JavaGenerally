package pulson.java_generally.javadoc;
import org.springframework.stereotype.Service;
import java.util.Random;

/**
 * The {@code Calculator} class provides functionalities of a calculator.
 *
 * <p>
 * I have worked really hard for this class to work
 * You can use it as you want. For example:
 * <blockquote><pre>
 *     Calculator calc = new Calculator();
 *     Integer randomNumber = calc.randomNumberWithUpperBound(500);
 *     "pre" is preformatting code (for example splitting it into multiple lines)
 * </pre></blockquote>
 *
 *<pre class="code"><code class="java">
 *  System.out.println("Some code inside");
 *</code></pre>
 *
 * The class {@code Calculator} is the <b>best</b> <i>class ever written in Java.</i>
 *
 *<p>All methods can throw a {@link Throwable}.</p>
 *
 * <p>
 * I love wasting time on <a href="https://www.youtube.com/">YouTube</a>
 * instead of learning.
 * </p>
 *
 * <p># is used to link methods</p>
 * @see java.lang.Integer
 * @see #randomNumberWithUpperBound(Integer, String)
 * @author Michał Puła
 */

@Service
public class Calculator {

    /**
     * Holds value "OK", because everything will be fine <3
     * @implNote This field is wholesome. And you're awesome!
     * Always believe in yourself and never give up on your dreams.
     * We're all gonna make it brahz.
     * @since 2.0
     */
    private static final String string = "OK";


    /**
     * Returns random Integer with max value equal to passed upperBound parameter.
     * Link to {@linkplain java.util.Random Random} java class.
     *
     *<pre>
     *    {@link java.lang.Object} link formatted as code font
     *    {@linkplain java.lang.Object} standard text link
     *</pre>
     *
     * @deprecated 4.0 - deprecated is always on top of the @tags
     *
     * @param upperBound max value of returned number
     * @param someUselessString this String literally does nothing..
     * @return random Integer
     * @throws Throwable the throwable to be thrown
     * @exception NullPointerException will be thrown if one of passed arguments is null
     *
     * @since 1.0 - since is always on bottom of the @tags
     */
    public Integer randomNumberWithUpperBound(Integer upperBound, String someUselessString) throws Throwable {
        if(upperBound.equals(null) || someUselessString.equals(null)) {
            throw new NullPointerException();
        }
        return new Random().nextInt(upperBound);
    }
}


