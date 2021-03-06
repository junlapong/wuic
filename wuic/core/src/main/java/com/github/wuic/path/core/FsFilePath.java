/*
 * "Copyright (c) 2015   Capgemini Technology Services (hereinafter "Capgemini")
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


package com.github.wuic.path.core;

import com.github.wuic.path.DirectoryPath;
import com.github.wuic.path.FilePath;
import com.github.wuic.path.FsItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * This {@link com.github.wuic.path.FilePath} represents a path on the path system.
 * </p>
 *
 * @author Guillaume DROUET
 * @version 1.1
 * @since 0.3.4
 */
public class FsFilePath extends SimplePath implements FilePath, FsItem {

    /**
     * The path.
     */
    private File file;

    /**
     * <p>
     * Builds a new instance. Throws a {@link IllegalArgumentException} if the specified path does not represents a
     * path on the path system.
     * </p>
     *
     * @param f the path
     * @param parent the parent, {@code null} if this path is a root
     */
    public FsFilePath(final File f, final DirectoryPath parent) {
        super(f.getName(), parent);

        if (!f.isFile()) {
            throw new IllegalArgumentException(String.format("%s is not a file on the file system", f.getAbsolutePath()));
        }

        file = f;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream openStream() throws IOException {
        return new FileInputStream(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLastUpdate() {
        return file.lastModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getFile() {
        return file;
    }
}
