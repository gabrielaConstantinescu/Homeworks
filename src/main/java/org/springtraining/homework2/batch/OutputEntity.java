package org.springtraining.homework2.batch;

public class OutputEntity {

    private String name;

    private Long diffMinutes;

    public OutputEntity(String name, Long diffMinutes) {
        this.name = name;
        this.diffMinutes = diffMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDiffMinutes() {
        return diffMinutes;
    }

    public void setDiffMinutes(Long diffMinutes) {
        this.diffMinutes = diffMinutes;
    }
}
