/*
 * Copyright (C) 2015 Collaboratory
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.dockstore.webservice.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author xliu
 */
@ApiModel(value = "A registered container that a user has submitted")
@Entity
@Table(name = "container")
@NamedQueries({
        @NamedQuery(name = "io.consonance.webservice.core.Container.findByNameAndNamespace", query = "SELECT c FROM Container c WHERE c.name = :name AND c.namespace = :namespace"),
        @NamedQuery(name = "io.consonance.webservice.core.Container.findByUserId", query = "SELECT c FROM Container c WHERE c.userId = :userId") })
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private String name;
    @Column
    private String namespace;
    @Column
    private String description;
    @Column
    private boolean isStarred;
    @Column
    private boolean isPublic;

    public Container() {
    }

    public Container(long id, long userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public long getUserId() {
        return userId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty
    public boolean getIsStarred() {
        return isStarred;
    }

    @JsonProperty
    public boolean getIsPublic() {
        return isPublic;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    /**
     * @param enduserId
     *            the user ID to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @param name
     *            the repo name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param namespace
     *            the repo name to set
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * @param description
     *            the repo name to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param isStarred
     *            the repo name to set
     */
    public void setIsStarred(boolean isStarred) {
        this.isStarred = isStarred;
    }

    /**
     * @param isPublic
     *            the repo name to set
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the isPublic
     */
    @JsonProperty("is_public")
    public boolean isIsPublic() {
        return isPublic;
    }

    /**
     * @return the isStarred
     */
    @JsonProperty("is_starred")
    public boolean isIsStarred() {
        return isStarred;
    }
}
