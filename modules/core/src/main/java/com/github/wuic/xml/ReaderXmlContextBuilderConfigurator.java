/*
 * "Copyright (c) 2013   Capgemini Technology Services (hereinafter "Capgemini")
 *
 * License/Terms of Use
 * Permission is hereby granted, free of charge and for the term of intellectual
 * property rights on the Software, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to use, copy, modify and
 * propagate free of charge, anywhere in the world, all or part of the Software
 * subject to the following mandatory conditions:
 *
 * -   The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Any failure to comply with the above shall automatically terminate the license
 * and be construed as a breach of these Terms of Use causing significant harm to
 * Capgemini.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, PEACEFUL ENJOYMENT,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Except as contained in this notice, the name of Capgemini shall not be used in
 * advertising or otherwise to promote the use or other dealings in this Software
 * without prior written authorization from Capgemini.
 *
 * These Terms of Use are subject to French law.
 *
 * IMPORTANT NOTICE: The WUIC software implements software components governed by
 * open source software licenses (BSD and Apache) of which CAPGEMINI is not the
 * author or the editor. The rights granted on the said software components are
 * governed by the specific terms and conditions specified by Apache 2.0 and BSD
 * licenses."
 */


package com.github.wuic.xml;

import com.github.wuic.exception.wrapper.StreamException;
import com.github.wuic.exception.xml.WuicXmlReadException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 * <p>
 * Represents a configurator based on XML read from a {@link Reader}. Polling is not supported by this kind of
 * configurator.
 * </p>
 *
 * @author Guillaume DROUET
 * @version 1.0
 * @since 0.4.2
 */
public class ReaderXmlContextBuilderConfigurator extends XmlContextBuilderConfigurator {

    /**
     * The tag.
     */
    private String tag;

    /**
     * The {@link  Reader} pointing to the XML stream.
     */
    private Reader reader;

    /**
     * <p>
     * Creates a new instance.
     * </p>
     *
     * @param r the reader to XML
     * @param t the tag
     * @param multiple {@code true} if multiple configurations with the same tag could be executed, {@code false} otherwise
     * @throws JAXBException if an context can't be initialized
     * @throws WuicXmlReadException if the XML is not well formed
     */
    public ReaderXmlContextBuilderConfigurator(final Reader r, final String t, final Boolean multiple)
            throws JAXBException, WuicXmlReadException {
        super(multiple);

        if (r == null) {
            throw new WuicXmlReadException("XML configuration reader for WUIC is null", new IllegalArgumentException());
        }

        reader = r;
        tag = t;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTag() {
        return tag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getLastUpdateTimestampFor(final String path) throws StreamException {
        return -1L;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected XmlWuicBean unmarshal(final Unmarshaller unmarshaller) throws JAXBException {
        return (XmlWuicBean) unmarshaller.unmarshal(reader);
    }
}
