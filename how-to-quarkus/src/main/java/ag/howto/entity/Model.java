package ag.howto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "models")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model {

    @Id
    @GeneratedValue
    @Column(name = "model_id")
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private OffsetDateTime requestedAt;
    private OffsetDateTime buildStartedAt;
    private OffsetDateTime buildFinishedAt;
    private DeploymentStatus deploymentStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public OffsetDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(OffsetDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public OffsetDateTime getBuildStartedAt() {
        return buildStartedAt;
    }

    public void setBuildStartedAt(OffsetDateTime buildStartedAt) {
        this.buildStartedAt = buildStartedAt;
    }

    public OffsetDateTime getBuildFinishedAt() {
        return buildFinishedAt;
    }

    public void setBuildFinishedAt(OffsetDateTime buildFinishedAt) {
        this.buildFinishedAt = buildFinishedAt;
    }

    public DeploymentStatus getDeploymentStatus() {
        return deploymentStatus;
    }

    public void setDeploymentStatus(DeploymentStatus deploymentStatus) {
        this.deploymentStatus = deploymentStatus;
    }

    public enum DeploymentStatus {
        EVALUATION,
        PRODUCTION,
        NONE
    }
}