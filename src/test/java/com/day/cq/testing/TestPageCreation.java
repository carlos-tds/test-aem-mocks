
package com.day.cq.testing;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.jcr.Session;

/**
 * Your comment here
 */
public class TestPageCreation {

    @Rule
    public AemContext context = new AemContext(ResourceResolverType.JCR_OAK);

    @Before
    public void setUp() {

        Session session = context.resourceResolver().adaptTo(Session.class);

        context.load().json(getClass().getResourceAsStream("/sample_templates.json"), "/content/templates");

    }

    @Test
    public void testPageCreation() throws WCMException {
        PageManager pMgr = context.pageManager();
        Page samplePage = pMgr.create("/content", "", "/content/templates/sample-template","Some title", true);
    }

}
