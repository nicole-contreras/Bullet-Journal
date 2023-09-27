package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the JSON file that is read in.
 *
 * @param events    the list of events in a given day
 * @param tasks     the list of tasks in a given day
 * @param cssFile   the css file to use
 * @param maxEvents the max number of events
 * @param maxTasks  the max number of tasks
 */
public record BujoJson(
    @JsonProperty("events") HashMap<DayOfWeek, List<EventJson>> events,
    @JsonProperty("tasks") HashMap<DayOfWeek, List<TaskJson>> tasks,
    @JsonProperty("theme") String cssFile,
    @JsonProperty("maxevents") int maxEvents,
    @JsonProperty("maxtasks") int maxTasks
) {
}
