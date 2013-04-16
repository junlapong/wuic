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


package com.github.wuic.configuration.impl;

import com.github.wuic.FileType;
import com.github.wuic.configuration.YuiConfiguration;
import com.github.wuic.configuration.YuiCssConfiguration;
import com.github.wuic.configuration.YuiJavascriptConfiguration;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>
 * Implementation as a POJO of the {@link YuiCssConfiguration}.
 * </p>
 * 
 * @author Guillaume DROUET
 * @version 1.0
 * @since 0.1.0
 */
public class YuiCssConfigurationImpl extends YuiConfigurationImpl implements YuiCssConfiguration {
    
    /**
     * <p>
     * Builds a new instance based on a given global {@link YuiConfiguration configuration}.
     * </p>
     * 
     * @param base the base {@link YuiConfiguration configuration}
     */
    public YuiCssConfigurationImpl(final YuiConfiguration base) {
        super(base);
    }
    
    /**
     * <p>
     * Calculates the hash code. Hash code is based on the following values :
     * <ul>
     * <li> aggregate() </li>
     * <li> charset() </li>
     * <li> compress() </li>
     * <li> yuiLineBreakPos() </li>
     * </ul>
     * </p>
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        
        builder.append(this.aggregate());
        builder.append(this.charset());
        builder.append(this.compress());
        builder.append(this.yuiLineBreakPos());
        
        return builder.hashCode();
    }
    
    /**
     * <p>
     * Tests the equality with another object. Compared values are :
     * <ul>
     * <li> aggregate() </li>
     * <li> charset() </li>
     * <li> compress() </li>
     * <li> yuiLineBreakPos() </li>
     * </ul>
     * </p>
     * 
     * @param other the object to compare
     * @return {@code true} if the objects equal, {@code false} otherwise
     */
    @Override
    public boolean equals(final Object other) {
        if (other instanceof YuiJavascriptConfiguration) {
            final YuiJavascriptConfiguration config = (YuiJavascriptConfiguration) other;
            final EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.aggregate(), config.aggregate());
            builder.append(this.charset(), config.charset());
            builder.append(this.compress(), config.compress());
            builder.append(this.yuiLineBreakPos(), config.yuiLineBreakPos());
            
            return builder.isEquals();
        } else {
            return Boolean.FALSE;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public FileType getFileType() {
        return FileType.CSS;
    }
}