package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an event in the JSON file.
 *
 * @param name        of the task
 * @param description of the task
 * @param time        the time it will start
 * @param duration    the length of the event
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("starttime") String time,
    @JsonProperty("duration") String duration
) {
}
