package testsuite.sitemesh;

import java.io.IOException;
import java.io.StringReader;

import org.xml.sax.SAXException;

import com.opensymphony.util.XMLUtils;

import testsuite.tester.WebTest;
import com.meterware.httpunit.WebResponse;
import electric.xml.Document;
import electric.xml.ParseException;

/**
 *
 *
 * @author <a href="mailto:joe@truemesh.com">Joe Walnes</a>
 */
public class SimpleDecoratorTest extends WebTest {

	public void testPage1() throws Exception {
		WebResponse rs = wc.getResponse( server.getBaseURL() + "/simple/page1.jsp" );
		Document doc = getDocument( rs );
		assertEquals( "[:: Simple page1 ::]", rs.getTitle() );
		assertEquals( "Hello world 1", doc.getElementWithId( "p1" ).getText().toString() );
		assertEquals( "footer", doc.getElementWithId( "footer" ).getText().toString() );
		assertEquals( "Simple page1", doc.getElementWithId( "header" ).getText().toString() );
	}

	public void testPage2() throws Exception {
		WebResponse rs = wc.getResponse( server.getBaseURL() + "/simple/page2.jsp" );
		Document doc = getDocument( rs );
		assertEquals( "[:: Simple page2 ::]", rs.getTitle() );
		assertEquals( "Hello world 2", doc.getElementWithId( "p2" ).getText().toString() );
		assertEquals( "footer", doc.getElementWithId( "footer" ).getText().toString() );
		assertEquals( "Simple page2", doc.getElementWithId( "header" ).getText().toString() );
	}

	public void testPage3() throws Exception {
		WebResponse rs = wc.getResponse( server.getBaseURL() + "/simple/page3.jsp" );
		Document doc = getDocument( rs );
		assertEquals( "[:: MySite ::]", rs.getTitle() );
		assertEquals( "Hello world 3", doc.getElementWithId( "mainbody" ).getText().toString() );
		assertEquals( "footer", doc.getElementWithId( "footer" ).getText().toString() );
		assertEquals( "MySite", doc.getElementWithId( "header" ).getText().toString() );
	}

    /**
     * Internationalisation Test
     * @throws Exception
     */
    public void testPage4() throws Exception {
		WebResponse rs = wc.getResponse( server.getBaseURL() + "/simple/page4.jsp" );
		Document doc = getDocument( rs );
		assertEquals( "[:: MySite ::]", rs.getTitle() );
		assertEquals( "\u0126\u0118\u0139\u0139\u0150 world 4", doc.getElementWithId( "mainbody" ).getText().toString() );
		assertEquals( "footer", doc.getElementWithId( "footer" ).getText().toString() );
		assertEquals( "MySite", doc.getElementWithId( "header" ).getText().toString() );
	}

}