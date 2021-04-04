package com.unlu.sdypp.renderizado.fileserver.entities;

import com.unlu.sdypp.renderizado.fileserver.converters.ObjectToJsonConverter;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

import java.util.Date;

@Entity("partial_job")
public class PartialJobStatusEntity {

    @Id
    private String id;

    @Property("job_reference")
    private String jobReference;

    private int initialPart;

    private int finalParts;

    private int completes;

    @Property("start_date")
    private Date startDate;

    @Property("finish_date")
    private Date finishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobReference() {
        return jobReference;
    }

    public void setJobReference(String jobReference) {
        this.jobReference = jobReference;
    }

    public int getInitialPart() {
        return initialPart;
    }

    public void setInitialPart(int initialPart) {
        this.initialPart = initialPart;
    }

    public int getFinalParts() {
        return finalParts;
    }

    public void setFinalParts(int finalParts) {
        this.finalParts = finalParts;
    }

    public int getCompletes() {
        return completes;
    }

    public void setCompletes(int completes) {
        this.completes = completes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return ObjectToJsonConverter.instance.toJson(this);
    }
}
