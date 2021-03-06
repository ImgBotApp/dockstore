/*
 *    Copyright 2017 OICR
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.dockstore.webservice.jdbi;

import io.dockstore.webservice.core.Workflow;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author dyuen
 */
public class WorkflowDAO extends EntryDAO<Workflow> {
    public WorkflowDAO(SessionFactory factory) {
        super(factory);
    }

    public Workflow findByPath(String path) {
        return uniqueResult(namedQuery("io.dockstore.webservice.core.Workflow.findByPath").setParameter("path", path));
    }

    public Workflow findPublishedByPath(String path) {
        return uniqueResult(namedQuery("io.dockstore.webservice.core.Workflow.findPublishedByPath").setParameter("path", path));
    }
    public Workflow findPublishedByWorkflowPath(String path, String name) {
        return uniqueResult(namedQuery("io.dockstore.webservice.core.Workflow.findPublishedByWorkflowPath")
                .setParameter("path", path)
                .setParameter("name", name));
    }

    public Workflow findPublishedByWorkflowPathNullWorkflowName(String path) {
        return uniqueResult(namedQuery("io.dockstore.webservice.core.Workflow.findPublishedByWorkflowPathNullWorkflowName")
                .setParameter("path", path));
    }

    public List<Workflow> findByGitUrl(String giturl) {
        return list(namedQuery("io.dockstore.webservice.core.Workflow.findByGitUrl").setParameter("gitUrl", giturl));
    }

    public List<Workflow> findPublishedByOrganization(String organization) {
        return list(namedQuery("io.dockstore.webservice.core.Workflow.findPublishedByOrganization").setParameter("organization", organization));
    }
}
