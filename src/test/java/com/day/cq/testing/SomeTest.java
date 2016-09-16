/*******************************************************************************
 * ADOBE CONFIDENTIAL
 * __________________
 *
 * Copyright 2016 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 ******************************************************************************/

package com.day.cq.testing;

import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.testing.jcr.RepositoryUtil;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.io.IOException;

/**
 * Your comment here
 */
public class SomeTest {

    public AemContext context = new AemContext(ResourceResolverType.JCR_OAK);

    Resource theResouce;

    @Before
    public void setUp() throws IOException, RepositoryException {
        Session session = context.resourceResolver().adaptTo(Session.class);
        RepositoryUtil.registerSlingNodeTypes(session);
        context.create().resource("/content/the-resource");
    }

    @Test
    public void testSomething() {
        Assert.assertNotNull(theResouce);
    }
}
