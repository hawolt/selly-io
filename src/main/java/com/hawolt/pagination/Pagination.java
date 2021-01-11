package com.hawolt.pagination;

import com.hawolt.SellyException;
import com.hawolt.SellyJson;
import com.hawolt.SellyRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pagination<T extends SellyJson> implements ExceptionalIterable<List<T>> {

    protected Direction direction;

    private String location;
    private int index, total;
    private SellyRequest initial;
    private Function<JSONObject, T> function;

    public Pagination(Function<JSONObject, T> function, String location, SellyRequest initial, Direction direction) {
        this.total = initial.getTotalPages();
        this.function = function;
        this.location = location;
        this.direction = direction;
        this.initial = initial;
        this.index = 1 + (direction == Direction.ASCENDING ? 0 : initial.getTotalPages());
    }

    public int getIndex() {
        return index;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public boolean hasNext() {
        return direction == Direction.ASCENDING ? index < total : index > 0;
    }

    @Override
    public List<T> next() throws IOException, SellyException {
        if (index == 1) {
            index += 1;
            return convert(initial);
        }
        int tmp = direction == Direction.ASCENDING ? 1 : -1;
        SellyRequest request = SellyRequest.get(String.format("%s?page=%s", location, index + (tmp)));
        index += tmp;
        return convert(request);
    }

    public List<T> convert(SellyRequest request) {
        JSONArray array = new JSONArray(request.getBody());
        IntStream indices = direction == Direction.ASCENDING
                ? IntStream.range(0, array.length())
                : IntStream.rangeClosed(array.length() - 1, 0);
        return indices.mapToObj(array::getJSONObject)
                .map(function::apply)
                .collect(Collectors.toList());
    }

    public enum Direction {
        ASCENDING, DESCENDING
    }
}
