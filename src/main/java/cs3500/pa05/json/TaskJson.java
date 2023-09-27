package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task in the JSON file.
 *
 * @param name        of the task
 * @param description of the task
 * @param completed   if the task is completed
 */
public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("completed") boolean completed
) {
}
