/*
 *   Copyright 2006 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.felix.bundlerepository;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.obr.RepositoryAdmin;

public class Activator implements BundleActivator
{
    private transient BundleContext m_context = null;
    private transient RepositoryAdminImpl m_repoAdmin = null;

    public void start(BundleContext context)
    {
        m_context = context;

        // Register bundle repository service.
        m_repoAdmin = new RepositoryAdminImpl(m_context);
        context.registerService(
            RepositoryAdmin.class.getName(),
            m_repoAdmin, null);

        // We dynamically import the impl service API, so it
        // might not actually be available, so be ready to catch
        // the exception when we try to register the command service.
        try
        {
            // Register "obr" impl command service as a
            // wrapper for the bundle repository service.
            context.registerService(
                org.apache.felix.shell.Command.class.getName(),
                new ObrCommandImpl(m_context, m_repoAdmin), null);
        }
        catch (Throwable th)
        {
            // Ignore.
        }
    }

    public void stop(BundleContext context)
    {
    }
}