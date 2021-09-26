package pl.wsb.exercises;

import java.util.*;
import java.util.stream.Collectors;


class ContextDataEntry {
    private final String id;
    private final Map<String, String> parameters;

    ContextDataEntry(String id, Map<String, String> parameters) {
        this.id = id;
        this.parameters = parameters;
    }


    public String getId() {
        return id;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "ContextDataEntry{" +
                "id='" + id + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}

public class MergeData {
    public static Map<String, Map<String, String>> toData(final List<ContextDataEntry> entries) {
        Map<String, Map<String, String>> result = new HashMap<>();

        entries.forEach(contextDataEntry -> {
            if (!result.containsKey(contextDataEntry.getId())) {
                result.put(contextDataEntry.getId(), new HashMap<>());
            }
            Map<String, String> stringStringMap = result.get(contextDataEntry.getId());
            contextDataEntry.getParameters().forEach((key, value) -> {
                stringStringMap.merge(key, value, (v1, v2) -> v2);
            });
        });
        return result;
    }

    public static void main(String[] args) {
        var entries = List.of(new ContextDataEntry("id", Map.of("value", "dupa1")),
                new ContextDataEntry("id2", Map.of("value", "dupa2")),
                new ContextDataEntry("id", Map.of("value", "dupa3")));
        entries
                .stream()
                .collect(Collectors.groupingBy(ContextDataEntry::getId, Collectors.mapping(ContextDataEntry::getParameters, Collectors.toMap(k -> k, v -> v))))
                .forEach((k, v) -> {
                    System.out.println(k + " " + v);
                });
    }
}
